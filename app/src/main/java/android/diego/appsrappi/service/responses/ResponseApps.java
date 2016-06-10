package android.diego.appsrappi.service.responses;

import android.diego.appsrappi.model.Feed;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Diego on 6/3/2016.
 */
public class ResponseApps {

    @SerializedName("feed")
    @Expose
    public Feed feed;
}
