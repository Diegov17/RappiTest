package android.diego.appsrappi.home.adapter;

import android.content.Context;
import android.diego.appsrappi.R;
import android.diego.appsrappi.model.Entry;
import android.diego.appsrappi.util.DeviceUtil;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Diego on 6/3/2016.
 */
public class AppAdapter extends BaseAdapter {

    private Context context;
    private List<Entry> apps;
    private DisplayMetrics metrics_;

    public AppAdapter(Context context, List<Entry> apps) {
        this.context = context;
        this.apps = apps;
    }

    @Override
    public int getCount() {
        return this.apps.size();
    }

    @Override
    public Object getItem(int position) {
        return  this.apps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        ViewHolder viewHolder;
        Entry app;

        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.app_adapter, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) rowView.findViewById(R.id.name);
            viewHolder.artist = (TextView) rowView.findViewById(R.id.artist);
            viewHolder.price = (TextView) rowView.findViewById(R.id.price);
            viewHolder.icon = (ImageView) rowView.findViewById(R.id.icon);

            rowView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) rowView.getTag();

        app = this.apps.get(position);
        Picasso.with(context)
                .load(app.getImImage().get(0).getLabel())
                .into(viewHolder.icon);

        viewHolder.name.setText(app.getImName().label);
        viewHolder.artist.setText(app.getImArtist().label);

        if (app.getImPrice().attributes.amount.contains("0.0"))
            viewHolder.price.setText("FREE");
        else
            viewHolder.price.setText(app.getImPrice().attributes.amount);

        if (!DeviceUtil.isTablet(context)) {
            Animation animation = null;
            animation = AnimationUtils.loadAnimation(context, R.anim.shake);
            rowView.startAnimation(animation);
            animation = null;
        } else if (DeviceUtil.isTablet(context)){
            Animation animation;
            animation = AnimationUtils.loadAnimation(context, R.anim.animation_move);
            viewHolder.icon.startAnimation(animation);
        }

        return rowView;
    }

    private class ViewHolder {
        ImageView icon;
        TextView name;
        TextView artist;
        TextView price;
    }
}
