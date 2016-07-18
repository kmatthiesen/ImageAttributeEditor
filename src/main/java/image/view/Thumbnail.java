package image.view;

import image.utilities.Common;
import image.utilities.FileType;

import javax.swing.*;
import java.awt.*;

/**
 * Created by round on 7/13/2016.
 */
public class Thumbnail extends JLabel {

    public static final int SIZE = 90;
    private FileType format;

    public Thumbnail(){
    }

    public void setFormat(FileType format) {
        this.format = format;
    }

    public FileType getFormat() {
        return format;
    }
}
