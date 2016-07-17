package image.utilities;

/**
 * Created by round on 7/13/2016.
 */
public enum FileType {

    JPG("jpg"),
    JPEG("jpeg"),
    PNG("png"),
    GIF("gif");

    private String type;

    FileType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
