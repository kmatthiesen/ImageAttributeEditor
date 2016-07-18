package image.view;

import image.MainWindow;
import image.utilities.FileType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * Created by round on 7/13/2016.
 */
public class ImageContainer {

    private Thumbnail thumbnail = new Thumbnail();
    private Thumbnail fullImage = new Thumbnail();
    private FileType format;

    public ImageContainer(BufferedImage bufferedImage, FileType fileType) {
        fullImage.setIcon(new ImageIcon(bufferedImage));

        Image image = bufferedImage.getScaledInstance(Thumbnail.SIZE, Thumbnail.SIZE, Image.SCALE_SMOOTH);
        thumbnail.setIcon(new ImageIcon(image));
        thumbnail.addMouseListener(createMouseListener());

        fullImage.setFormat(fileType);
        thumbnail.setFormat(fileType);
    }

    public JLabel getFullImage() {
        return fullImage;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    private MouseListener createMouseListener() {
        return new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    ImageViewDialog viewDialog = new ImageViewDialog(fullImage);
                    viewDialog.pack();
                    viewDialog.setLocationRelativeTo(null);
                    viewDialog.setVisible(true);
                }
            }

            public void mousePressed(MouseEvent e) {
                //Not needed.
            }

            public void mouseReleased(MouseEvent e) {
                //Not needed.
            }

            public void mouseEntered(MouseEvent e) {
                //Not needed.
            }

            public void mouseExited(MouseEvent e) {
                //Not needed.
            }
        };
    }
}
