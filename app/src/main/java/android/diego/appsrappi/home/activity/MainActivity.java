package android.diego.appsrappi.home.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.diego.appsrappi.R;
import android.diego.appsrappi.home.adapter.AppAdapter;
import android.diego.appsrappi.model.Entry;
import android.diego.appsrappi.service.RestClientPublic;
import android.diego.appsrappi.service.responses.ResponseApps;
import android.diego.appsrappi.util.BusStation;
import android.diego.appsrappi.util.DeviceUtil;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private static RestClientPublic restClientPublic;
    private Context mContext;
    private AbsListView listView;
    private TextView offlineTv;
    private Gson gson;
    private SharedPreferences appSharedPrefs;
    private SharedPreferences.Editor prefsEditor;
    private Entry app;

    private FragmentDrawer drawerFragment;
    private Toolbar mToolbar;

    private List<Entry> entry = new ArrayList<Entry>();
    List<String> categories = new ArrayList<String>();
    private List<Entry> entryCategorias = new ArrayList<Entry>();

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initControls();

        if (DeviceUtil.isNetworkAvailable(mContext)) {
            dialog = ProgressDialog.show(this, "", "loading...");
            loadApps();

        } else if (!DeviceUtil.isNetworkAvailable(mContext) && appSharedPrefs.contains("App0")) {
            fillListFromPrefs();

        } else if (!DeviceUtil.isNetworkAvailable(mContext)){
            Toast.makeText(mContext, "Check your internet connection", Toast.LENGTH_LONG).show();
            TextView emptyView = new TextView(mContext);
            emptyView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT));
            emptyView.setText(getResources().getString(R.string.emptyList));
            emptyView.setVisibility(View.GONE);
            ((ViewGroup)listView.getParent()).addView(emptyView);
            listView.setEmptyView(emptyView);
        }
    }


    private void initControls() {

        mContext = getApplicationContext();
        this.listView = (AbsListView) findViewById(R.id.listApps);
        this.offlineTv = (TextView) findViewById(R.id.connectionTV);

        appSharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(mContext);
        prefsEditor = appSharedPrefs.edit();
        gson = new Gson();
        app = new Entry();

        restClientPublic = new RestClientPublic();

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (!DeviceUtil.isTablet(mContext))
            DeviceUtil.setPortraitOrientationOnSmartPhone(MainActivity.this);
        else
            DeviceUtil.setLandscapeOrientationOnTablet(MainActivity.this);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Entry app;
                Entry app2 = new Entry();
                app = (Entry) parent.getItemAtPosition(position);

                app2.setCategory(app.getCategory());
                app2.setId(app.getId());
                app2.setImArtist(app.getImArtist());
                app2.setImContentType(app.getImContentType());
                app2.setImName(app.getImName());
                app2.setImImage(app.getImImage());
                app2.setImPrice(app.getImPrice());
                app2.setImReleaseDate(app.getImReleaseDate());
                app2.setLink(app.getLink());
                app2.setRights(app.getRights());
                app2.setSummary(app.getSummary());
                app2.setTitle(app.getTitle());


                Intent intent = new Intent(MainActivity.this, ResumenApp.class);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("data", app2);
                intent.putExtras(mBundle);
                startActivity(intent);
            }
        });
    }

    private void fillListFromPrefs () {

        Map<String,?> entries = appSharedPrefs.getAll();
        Set<String> keys = entries.keySet();
        for (String app : keys) {

            String json = appSharedPrefs.getString(app, "");
            this.app = gson.fromJson(json, Entry.class);
            entry.add(this.app);
        }

        setAdapterApps();
        setFragment();

    }


    private void loadApps (){

        categories.add("All");

        restClientPublic.getPublicService()
                .getFeed()
                .enqueue(new Callback<ResponseApps>() {
                    @Override
                    public void onResponse(Response<ResponseApps> response, Retrofit retrofit) {
                        dialog.dismiss();
                        entry = response.body().feed.getEntry();

                        for (int i = 0; i < entry.size(); i++) {
                            Entry app = new Entry();
                            app = entry.get(i);
                            String json = gson.toJson(app);

                            if (categories != null && !categories.contains(app.getCategory().getAttributes().label))
                                categories.add(app.getCategory().getAttributes().label);

                            prefsEditor.putString("App" + i, json);
                            prefsEditor.commit();
                        }

                        setAdapterApps();
                        setFragment();

                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        TextView emptyView = new TextView(mContext);
                        emptyView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT));
                        emptyView.setText(getResources().getString(R.string.emptyList));
                        emptyView.setVisibility(View.GONE);
                        ((ViewGroup)listView.getParent()).addView(emptyView);
                        listView.setEmptyView(emptyView);
                    }
                });
    }
    public void  setFragment(){

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar, categories);
        drawerFragment.setDrawerListener(this);

    }

    public void setAdapterApps() {

        // Sets the data behind this ListView
        this.listView.setAdapter(new AppAdapter(this, entry));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {

        String categoria = categories.get(position);
        displayView(categoria);
    }

    private void displayView(String categoria) {
        Fragment fragment = null;

        if (categoria.equals("All"))
            entryCategorias = entry;
        else
            entryCategorias = getListByCategory(categoria);

        this.listView.setAdapter(new AppAdapter(this, entryCategorias));

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

        }
    }

    public List<Entry> getListByCategory (String categoria) {
        List<Entry> entry2 = new ArrayList<Entry>();

        for (int i = 0; i < entry.size(); i++) {

            if (entry != null && entry.get(i).getCategory().getAttributes().label.equals(categoria))
                entry2.add(entry.get(i));
        }

        return entry2;
    }

    @Subscribe
    public void recievedBus (String busMessage){

        if (busMessage.equals(getResources().getString(R.string.offlineMode)))
            offlineTv.setVisibility(View.VISIBLE);

        else if (busMessage.equals(getResources().getString(R.string.onlineMode))) {
            offlineTv.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onPause() {
        super.onPause();

        BusStation.getBus().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        BusStation.getBus().register(this);
    }
}
