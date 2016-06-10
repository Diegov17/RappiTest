package android.diego.appsrappi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Diego on 6/3/2016.
 */
public class LinkFeed {

    @SerializedName("rel")
    @Expose
    public String rel;
    @SerializedName("href")
    @Expose
    public String href;
}
