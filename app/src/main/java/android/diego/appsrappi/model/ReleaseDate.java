package android.diego.appsrappi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Diego on 6/3/2016.
 */
public class ReleaseDate {

    @SerializedName("labelDate")
    @Expose
    private Date labelDate;
    @SerializedName("label")
    @Expose
    private String label;
}
