package android.diego.appsrappi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diego on 6/3/2016.
 */
public class ImArtist implements Serializable {

    @SerializedName("label")
    @Expose
    public String label;

    @SerializedName("attributes")
    @Expose
    public ImArtistAttributes attributes;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ImArtistAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(ImArtistAttributes attributes) {
        this.attributes = attributes;
    }
}
