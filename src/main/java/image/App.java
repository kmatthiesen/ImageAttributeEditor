package image;

import image.utilities.Common;

import javax.swing.*;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

//        Common.pictureDirectory = "C:\\Users\\round\\Pictures";
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainWindow main = new MainWindow();
                main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                main.pack();
                main.setVisible(true);
            }
        });
    }
}
