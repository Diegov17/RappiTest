package android.diego.appsrappi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diego on 6/3/2016.
 */
public class Id implements Serializable {

    @SerializedName("label")
    @Expose
    public String label;

    @SerializedName("attributes")
    @Expose
    public IdAttributes attributes;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public IdAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(IdAttributes attributes) {
        this.attributes = attributes;
    }
}
