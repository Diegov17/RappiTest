package android.diego.appsrappi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Diego on 6/3/2016.
 */
public class Author {

    @SerializedName("name")
    @Expose
    public Name name;
    @SerializedName("uri")
    @Expose
    public Uri uri;
}
