package android.diego.appsrappi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diego on 6/3/2016.
 */
public class ImReleaseDate implements Serializable {

    @SerializedName("label")
    @Expose
    public String label;

    @SerializedName("attributes")
    @Expose
    public PriceAttributes attributes;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public PriceAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(PriceAttributes attributes) {
        this.attributes = attributes;
    }
}
