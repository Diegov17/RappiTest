package android.diego.appsrappi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diego on 6/3/2016.
 */
public class Link implements Serializable {

    @SerializedName("attributes")
    @Expose
    public LinkAttributes attributes;

    public LinkAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(LinkAttributes attributes) {
        this.attributes = attributes;
    }
}
