package android.diego.appsrappi.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.diego.appsrappi.R;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Diego on 6/5/2016.
 */
public class ConnectionChangeReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive( Context context, Intent intent )
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService( Context.CONNECTIVITY_SERVICE );
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();

        boolean isConnected = activeNetInfo != null && activeNetInfo.isConnectedOrConnecting();

        if (isConnected == true) {
            BusStation.getBus().post(context.getResources().getString(R.string.onlineMode));
            //Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
        } else {
            BusStation.getBus().post(context.getResources().getString(R.string.offlineMode));
            //Toast.makeText(context, "Not Connected", Toast.LENGTH_SHORT).show();
        }

    }
}
