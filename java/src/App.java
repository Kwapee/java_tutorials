import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("E-commerce Order Processing System");

        // Set the size of the frame
        frame.setSize(600, 600);

        // Set the default close operation (exit when closed)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels
        JLabel label = new JLabel();
        label.setText("WELCOME TO MY E-COMMERCE APP");
        label.setFont(new Font("Serif", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        label.setBounds(100, 50, 400, 50);

        JLabel label2 = new JLabel();
        label2.setText(
                "This app got you covered with all you needs from groceries to car spare parts with affordable prices you can trust");
        label2.setFont(new Font("Italic", Font.ITALIC, 11));
        label2.setForeground(Color.WHITE);
        label2.setBounds(10, 80, 700, 50);

        JLabel label3 = new JLabel();
        label3.setText("Our Products:");
        label3.setFont(new Font("Serif", Font.ITALIC, 18));
        label3.setForeground(Color.WHITE);
        label3.setBounds(10, 120, 700, 50);

        try {
            BufferedImage image1 = ImageIO.read(new File("C:\\Users\\perry\\Desktop\\App1\\hoodie.png"));
            BufferedImage image2 = ImageIO.read(new File("C:\\Users\\perry\\Desktop\\App1\\dress.png"));
            BufferedImage image3 = ImageIO.read(new File("C:\\Users\\perry\\Desktop\\App1\\shirt.png"));

            // Resize the images
            int width = 150;
            int height = 300;
            BufferedImage hoodie = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d1 = hoodie.createGraphics();
            g2d1.drawImage(image1, 0, 0, width, height, null);
            g2d1.dispose();

            BufferedImage dress = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d2 = dress.createGraphics();
            g2d2.drawImage(image2, 0, 0, width, height, null);
            g2d2.dispose();

            BufferedImage shirt = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d3 = shirt.createGraphics();
            g2d3.drawImage(image3, 0, 0, width, height, null);
            g2d3.dispose();

            JLabel label4 = new JLabel();
            ImageIcon imageIcon1 = new ImageIcon(hoodie);
            label4.setIcon(imageIcon1);
            label4.setBounds(30, 180, 500, 300);

            JLabel label5 = new JLabel();
            ImageIcon imageIcon2 = new ImageIcon(dress);
            label5.setIcon(imageIcon2);
            label5.setBounds(220, 180, 500, 300);

            JLabel label6 = new JLabel();
            ImageIcon imageIcon3 = new ImageIcon(shirt);
            label6.setIcon(imageIcon3);
            label6.setBounds(400, 180, 500, 300);

            JLabel label7 = new JLabel();
            label7.setText("Hoodie, $300");
            label7.setFont(new Font("Serif", Font.ITALIC, 18));
            label7.setForeground(Color.WHITE);
            label7.setBounds(50, 460, 700, 50);

            JLabel label8 = new JLabel();
            label8.setText("Dress, $200");
            label8.setFont(new Font("Serif", Font.ITALIC, 18));
            label8.setForeground(Color.WHITE);
            label8.setBounds(430, 460, 700, 50);

            JLabel label9 = new JLabel();
            label9.setText("Shirt, $350");
            label9.setFont(new Font("Serif", Font.ITALIC, 18));
            label9.setForeground(Color.WHITE);
            label9.setBounds(250, 460, 700, 50);

            // Create a panel to hold the application's components
            JPanel orangepanel = new JPanel();
            orangepanel.setBackground(Color.ORANGE);
            orangepanel.setBounds(0, 50, 600, 100);
            orangepanel.setLayout(null); // Use null layout to set the position and size manually

            // Add the label to the panel
            orangepanel.add(label);
            orangepanel.add(label2);
            orangepanel.add(label3);
            orangepanel.add(label4);
            orangepanel.add(label5);
            orangepanel.add(label6);
            orangepanel.add(label7);
            orangepanel.add(label8);
            orangepanel.add(label9);


            // Add the panel to the frame
            frame.getContentPane().add(orangepanel);

            // Center the frame on the screen
            frame.setLocationRelativeTo(null);

            // Make the frame visible
            frame.setVisible(true);

        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }
}