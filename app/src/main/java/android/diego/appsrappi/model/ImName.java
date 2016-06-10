package android.diego.appsrappi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diego on 6/3/2016.
 */
public class ImName implements Serializable {

    //@DatabaseField
    @SerializedName("label")
    @Expose
    public String label;
}
