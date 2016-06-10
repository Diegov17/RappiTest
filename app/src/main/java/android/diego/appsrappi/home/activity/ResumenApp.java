package android.diego.appsrappi.home.activity;

import android.content.Context;
import android.diego.appsrappi.R;
import android.diego.appsrappi.model.Entry;
import android.diego.appsrappi.util.CircleTransform;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Diego on 6/6/2016.
 */
public class ResumenApp extends ActionBarActivity {

    private Context mContext;

    private Entry app;
    private ImageView icon;
    private TextView name, summaryApp, rights, artist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle extras = this.getIntent().getExtras();
        if (extras != null) {
            app = (Entry)getIntent().getSerializableExtra("data");
        }

        initControls();
        setInfo();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setInfo() {

        Picasso.with(mContext)
                .load(app.getImImage().get(1).getLabel())
                .transform(new CircleTransform())
                .into(icon);

        name.setText(app.getImName().label);
        artist.setText(app.getImArtist().label);
        summaryApp.setText(app.getSummary().label);
        rights.setText(app.getRights().label);

    }

    private void initControls() {

        mContext = getApplicationContext();

        icon = (ImageView) findViewById(R.id.icon);
        name = (TextView) findViewById(R.id.name);
        artist = (TextView) findViewById(R.id.artist);
        summaryApp = (TextView) findViewById(R.id.summaryApp);
        rights = (TextView) findViewById(R.id.rights);

    }

}
