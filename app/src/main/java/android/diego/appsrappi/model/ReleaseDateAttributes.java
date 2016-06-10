package android.diego.appsrappi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Diego on 6/3/2016.
 */
public class ReleaseDateAttributes {

    //@DatabaseField
    @SerializedName("label")
    @Expose
    public String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
