package android.diego.appsrappi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego on 6/3/2016.
 */
public class Feed {

    @SerializedName("author")
    @Expose
    public Author author;
    @SerializedName("entry")
    @Expose
    public List<Entry> entry = new ArrayList<Entry>();
    @SerializedName("updated")
    @Expose
    public Updated updated;
    @SerializedName("rights")
    @Expose
    public FeedRights rights;
    @SerializedName("title")
    @Expose
    public FeedTitle title;
    @SerializedName("icon")
    @Expose
    public FeedIcon icon;
    @SerializedName("link")
    @Expose
    public List<LinkFeed> link = new ArrayList<LinkFeed>();
    @SerializedName("id")
    @Expose
    public FeedId id;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

    public Updated getUpdated() {
        return updated;
    }

    public void setUpdated(Updated updated) {
        this.updated = updated;
    }

    public FeedRights getRights() {
        return rights;
    }

    public void setRights(FeedRights rights) {
        this.rights = rights;
    }

    public FeedTitle getTitle() {
        return title;
    }

    public void setTitle(FeedTitle title) {
        this.title = title;
    }

    public FeedIcon getIcon() {
        return icon;
    }

    public void setIcon(FeedIcon icon) {
        this.icon = icon;
    }

    public List<LinkFeed> getLink() {
        return link;
    }

    public void setLink(List<LinkFeed> link) {
        this.link = link;
    }

    public FeedId getId() {
        return id;
    }

    public void setId(FeedId id) {
        this.id = id;
    }
}
