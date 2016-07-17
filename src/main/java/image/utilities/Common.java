package image.utilities;

import java.awt.*;

/**
 * Created by round on 7/13/2016.
 */
public class Common {

    public static String pictureDirectory = "";
    public static int frameWidth = 800;

    private static int lastX = 0;
    private static int lastY = 0;

    public static Dimension checkPlacement() {
        if (lastX == 0 && lastY == 0) {
            Dimension dimension =  new Dimension(lastX, lastY);
            lastX += 95;
            return dimension;
        }
        if (Common.lastX + 95 >= Common.frameWidth) {
            Common.lastX = 0;
            Common.lastY += 95;
        } else {
            Common.lastX += 95;
        }

        return new Dimension(lastX, lastY);
    }
}
