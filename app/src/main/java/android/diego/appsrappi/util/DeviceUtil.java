package android.diego.appsrappi.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Diego on 6/3/2016.
 */
public class DeviceUtil {

    /**
     * Verifies whether the device is Tablet or Smartphone
     *
     * @param context
     *          Application Context
     * @return boolean true if device is Tablet, otherwise it returns false.
     */
    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    /**
     * Verifies if device is connected to Internet
     *
     * @param context
     *          Application Context
     * @return boolean true if device is connected to Internet, otherwise it
     *         returns false
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    /**
     * Check if the network is available and isn't create a toast to noticate the
     * user that isn't connection available
     *
     * @return boolean thats identifies to the user if the network is available
     */
    public static boolean verifyNetwork(Context context) {
        if (isNetworkAvailable(context))
            return true;
        else {
            Toast.makeText(context, "Su dispositivo no tiene conexión a internet. " +
                    "Por favor verifique y vuelva a intentarlo", Toast.LENGTH_SHORT).show();
            if (context instanceof Activity)
                ((Activity) context).finish();
        }
        return true;
    }

    /**
     * Set the screen orientation to portrait when the device is a smartphone
     */
    public static void setPortraitOrientationOnSmartPhone(Activity activity) {
        if (!DeviceUtil.isTablet(activity)) {
            activity
                    .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    /**
     * Set the screen orientation to landscape when the device is a tablet
     */
    public static void setLandscapeOrientationOnTablet(Activity activity) {
            activity
                    .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }

}
