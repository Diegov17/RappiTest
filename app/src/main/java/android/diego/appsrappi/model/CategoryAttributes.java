package android.diego.appsrappi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diego on 6/3/2016.
 */
public class CategoryAttributes implements Serializable {

    //@DatabaseField(id = true)
    @SerializedName("im:id")
    @Expose
    public String imId;

    //@DatabaseField
    @SerializedName("term")
    @Expose
    public String term;

    //@DatabaseField
    @SerializedName("scheme")
    @Expose
    public String scheme;

    //@DatabaseField
    @SerializedName("label")
    @Expose
    public String label;

    public String getImId() {
        return imId;
    }

    public void setImId(String imId) {
        this.imId = imId;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
