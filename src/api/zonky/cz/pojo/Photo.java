package api.zonky.cz.pojo;

/**
 * Photo object.
 *
 * @author labut
 */
public class Photo {

    String name;
    String url;

    public Photo(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
