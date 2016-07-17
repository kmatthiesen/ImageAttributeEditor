/*
 * Created by JFormDesigner on Wed Jul 13 19:08:10 PDT 2016
 */

package image;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.List;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import image.utilities.FileType;
import image.view.ImageContainer;
import image.view.Thumbnail;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Kevin Matthiesen
 */
public class MainWindow extends JFrame {

    private List<ImageContainer> imageContainers = new ArrayList<ImageContainer>();

    public MainWindow() {
        initComponents();
    }

    private void openMenuItemActionPerformed() {
        JFileChooser fileChooser = new JFileChooser("C:\\Users\\round\\Pictures");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        JPanel imageViewPanel = new JPanel();
//        ScrollPane imageScrollPanel = new ScrollPane();

        imageViewPanel.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), imageViewPanel.getBorder())); imageViewPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        imageViewPanel.setLayout(new BoxLayout(imageViewPanel, BoxLayout.X_AXIS));

        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile.isFile()) {
                imageViewPanel.add(createImage(selectedFile));
            } else if (selectedFile.isDirectory()) {
                File[] files = selectedFile.listFiles();
                if (files == null) {
                    throw new RuntimeException();
                }
                for (File file : files) {
                    imageViewPanel.add(createImage(file));
                }
            }
            Container contentPane = getContentPane();

            contentPane.add(imageViewPanel, CC.xy(1, 1));
            revalidate();
            repaint();
            pack();
        }
    }

    @Nullable
    private Thumbnail createImage(@NotNull File file) {
        String[] filePath = file.getPath().split("\\.");
        for (FileType type : FileType.values()) {
            if (type.getType().equalsIgnoreCase(filePath[filePath.length - 1])) {
                try {
                    BufferedImage bufferedImage = ImageIO.read(file);
                    ImageContainer container = new ImageContainer(bufferedImage);
                    imageContainers.add(container);
                    return container.getThumbnail();
                } catch (IOException e) {
                    System.out.println("I can't read :(");
                }
            }
        }
        return null;
    }

    public void mouseClicked(MouseEvent event)
    {
        if (event.getClickCount() == 2) {
            System.out.println("double clicked");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Kevin Matthiesen
        menuBar1 = new JMenuBar();
        fileMenu = new JMenu();
        openMenuItem = new JMenuItem();

        //======== this ========
        setMinimumSize(new Dimension(800, 600));
        Container contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "default",
            "default"));

        //======== menuBar1 ========
        {

            //======== fileMenu ========
            {
                fileMenu.setText("File");

                //---- openMenuItem ----
                openMenuItem.setText("Open");
                openMenuItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        openMenuItemActionPerformed();
                    }
                });
                fileMenu.add(openMenuItem);
            }
            menuBar1.add(fileMenu);
        }
        setJMenuBar(menuBar1);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Kevin Matthiesen
    private JMenuBar menuBar1;
    private JMenu fileMenu;
    private JMenuItem openMenuItem;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
