package image.view;

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
    private JLabel fullImage = new JLabel();

    public ImageContainer(BufferedImage bufferedImage) {
        fullImage.setIcon(new ImageIcon(bufferedImage));

        Image image = bufferedImage.getScaledInstance(Thumbnail.SIZE, Thumbnail.SIZE, Image.SCALE_SMOOTH);
        thumbnail.setIcon(new ImageIcon(image));
        thumbnail.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    ImageViewDialog viewDialog = new ImageViewDialog(JOptionPane.getRootFrame(), fullImage);
                    viewDialog.pack();
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
        });
    }

    public JLabel getFullImage() {
        return fullImage;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }
}
