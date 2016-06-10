package android.diego.appsrappi.model;

import android.os.Parcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego on 6/3/2016.
 */
public class Entry implements Serializable{

    transient private Thread myThread;

    public Entry( ) {
    }

    protected Entry (Parcel in) {

    }

    //@DatabaseField
    @SerializedName("im:name")
    @Expose
    public ImName imName;

    //    @DatabaseField
    @SerializedName("im:image")
    @Expose
    public List<ImImage> imImage = new ArrayList<ImImage>();

    //    @DatabaseField
    @SerializedName("summary")
    @Expose
    public Summary summary;

    //    @DatabaseField
    @SerializedName("im:price")
    @Expose
    public ImPrice imPrice;

    //    @DatabaseField
    @SerializedName("im:contentType")
    @Expose
    public ImContentType imContentType;

    //    @DatabaseField
    @SerializedName("rights")
    @Expose
    public Rights rights;

    //    @DatabaseField
    @SerializedName("title")
    @Expose
    public Title title;

    //    @DatabaseField
    @SerializedName("link")
    @Expose
    public Link link;

    //    @DatabaseField(id = true)
    @SerializedName("id")
    @Expose
    public Id id;

    //    @DatabaseField
    @SerializedName("im:artist")
    @Expose
    public ImArtist imArtist;

    //    @DatabaseField
    @SerializedName("category")
    @Expose
    public Category category;

    //    @DatabaseField
    @SerializedName("im:releaseDate")
    @Expose
    public ImReleaseDate imReleaseDate;


    public ImName getImName() {
        return imName;
    }

    public void setImName(ImName imName) {
        this.imName = imName;
    }

    public List<ImImage> getImImage() {
        return imImage;
    }

    public void setImImage(List<ImImage> imImage) {
        this.imImage = imImage;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public ImPrice getImPrice() {
        return imPrice;
    }

    public void setImPrice(ImPrice imPrice) {
        this.imPrice = imPrice;
    }

    public ImContentType getImContentType() {
        return imContentType;
    }

    public void setImContentType(ImContentType imContentType) {
        this.imContentType = imContentType;
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public ImArtist getImArtist() {
        return imArtist;
    }

    public void setImArtist(ImArtist imArtist) {
        this.imArtist = imArtist;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ImReleaseDate getImReleaseDate() {
        return imReleaseDate;
    }

    public void setImReleaseDate(ImReleaseDate imReleaseDate) {
        this.imReleaseDate = imReleaseDate;
    }
}
