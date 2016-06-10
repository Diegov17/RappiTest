package android.diego.appsrappi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diego on 6/3/2016.
 */
public class ImArtistAttributes implements Serializable {

    @SerializedName("href")
    @Expose
    public String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
