package android.diego.appsrappi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diego on 6/3/2016.
 */
public class ImContentType implements Serializable {

    @SerializedName("attributes")
    @Expose
    public ContentTypeAttributes attributes;

    public ContentTypeAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(ContentTypeAttributes attributes) {
        this.attributes = attributes;
    }
}
