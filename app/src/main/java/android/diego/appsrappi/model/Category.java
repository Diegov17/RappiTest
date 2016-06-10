package android.diego.appsrappi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diego on 6/3/2016.
 */
public class Category implements Serializable {

    //@DatabaseField
    @SerializedName("attributes")
    @Expose
    public CategoryAttributes attributes;

    public CategoryAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(CategoryAttributes attributes) {
        this.attributes = attributes;
    }
}
