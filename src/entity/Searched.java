package entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Searched {
    public static void main(String[] args) {

//    {716426=[https://spoonacular.com/recipeImages/716426-312x231.jpg, Cauliflower, Brown Rice, and Vegetable Fried Rice],
        // 782601=[https://spoonacular.com/recipeImages/782601-312x231.jpg, Red Kidney Bean Jambalaya],
        // 782585=[https://spoonacular.com/recipeImages/782585-312x231.jpg, Cannellini Bean and Asparagus Salad with Mushrooms],
        // 715497=[https://spoonacular.com/recipeImages/715497-312x231.jpg, Berry Banana Breakfast Smoothie],
        // 644387=[https://spoonacular.com/recipeImages/644387-312x231.jpg, Garlicky Kale],
        // 795751=[https://spoonacular.com/recipeImages/795751-312x231.jpg, Chicken Fajita Stuffed Bell Pepper],
        // 716406=[https://spoonacular.com/recipeImages/716406-312x231.jpg, Asparagus and Pea Soup: Real Convenience Food],
        // 715446=[https://spoonacular.com/recipeImages/715446-312x231.jpg, Slow Cooker Beef Stew],
        // 715415=[https://spoonacular.com/recipeImages/715415-312x231.jpg, Red Lentil Soup with Chicken and Turnips],
        // 766453=[https://spoonacular.com/recipeImages/766453-312x231.jpg, Hummus and Za'atar]}
JLabel title = new JLabel("Search Result Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel foldernameInfo = new JLabel("Currently opened folder: ");

    //        JButton get = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
//        JButton remove = new JButton(OpenedFolderViewModel.REMOVE_BUTTON_LABEL);
//        JButton button = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
    JButton get = new JButton();
//    JButton remove = new JButton();
        get.setBounds(600, 10, 250, 100);
        get.setText("GET");

//        JButton buttonremove = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
//        remove.setBounds(900, 10, 250, 100);
//        remove.setText("REMOVE");

    JPanel buttons = new JPanel();
        buttons.add(get);

        JButton get2 = new JButton();
//    JButton remove = new JButton();

    get2.setBounds(600, 350, 250, 100);
    get2.setText("GET");

//        JButton buttonremove = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
//        remove.setBounds(900, 10, 250, 100);
//        remove.setText("REMOVE");
        JPanel buttons2 = new JPanel();
        buttons2.add(get2);
//        buttons.add(remove);
//        remove.addActionListener(this);
//        get.addActionListener(this);
        JButton get3 = new JButton();
//    JButton remove = new JButton();

        get3.setBounds(600, 650, 250, 100);
        get3.setText("GET");

//        JButton buttonremove = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
//        remove.setBounds(900, 10, 250, 100);
//        remove.setText("REMOVE");
        JPanel buttons3 = new JPanel();
        buttons3.add(get3);

    Image image = null;
        try {
        URL url = new URL("https://spoonacular.com/recipeImages/716426-312x231.jpg");
        image = ImageIO.read(url);
    } catch (
    IOException e) {
        e.printStackTrace();
    }

        Image image2 = null;
        try {
            URL url = new URL("https://spoonacular.com/recipeImages/782601-312x231.jpg");
            image2 = ImageIO.read(url);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        Image image3 = null;
        try {
            URL url = new URL("https://spoonacular.com/recipeImages/782585-312x231.jpg");
            image3 = ImageIO.read(url);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel(new ImageIcon(image3));
        label3.setBounds(150, 550, 250, 250);
        label3.setVisible(true);
        label3.setText("Cannellini Bean and Asparagus Salad with Mushrooms");
        // set text of label label.setIcon(image);
        label3.setHorizontalTextPosition(JLabel.CENTER);
        // set text LEFT,CENTER, RIGHT of imageicon
        label3.setVerticalTextPosition(JLabel.TOP);
        // set text TOP,CENTER, BOTTOM of imageicon
//        label.setForeground(new Color(0x00FF00));
        // set font color of text
        label3.setFont(new Font("MV Boli", Font.PLAIN, 20));
        // set font of text
        label3.setIconTextGap(-25);
        // set gap of text to image
        label3.setBackground(Color.gray);
        // set background color
        label3.setOpaque(true);
        // display background color
//        label.setBorder(border);
        // sets border of label (not image+text)
        label3.setVerticalAlignment(JLabel.CENTER);
        // set vertical position of icon+text within label
        label3.setHorizontalAlignment(JLabel.CENTER);
        // set horizontal position of icon+text within label

        JLabel label2 = new JLabel(new ImageIcon(image2));
        label2.setBounds(150, 270, 250, 250);
        label2.setVisible(true);
        label2.setText("Red Kidney Bean Jambalaya");
        // set text of label label.setIcon(image);
        label2.setHorizontalTextPosition(JLabel.CENTER);
        // set text LEFT,CENTER, RIGHT of imageicon
        label2.setVerticalTextPosition(JLabel.TOP);
        // set text TOP,CENTER, BOTTOM of imageicon
//        label.setForeground(new Color(0x00FF00));
        // set font color of text
        label2.setFont(new Font("MV Boli", Font.PLAIN, 20));
        // set font of text
        label2.setIconTextGap(-25);
        // set gap of text to image
        label2.setBackground(Color.GRAY);
        // set background color
        label2.setOpaque(true);
        // display background color
//        label.setBorder(border);
        // sets border of label (not image+text)
        label2.setVerticalAlignment(JLabel.CENTER);
        // set vertical position of icon+text within label
        label2.setHorizontalAlignment(JLabel.CENTER);
        // set horizontal position of icon+text within label

    //        Border border = BorderFactory.createLineBorder(Color.green,3);
    JLabel label = new JLabel(new ImageIcon(image));
        label.setBounds(150, 10, 250, 250);
        label.setVisible(true);
        label.setText("Cauliflower, Brown Rice, and Vegetable Fried Rice");
    // set text of label label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
    // set text LEFT,CENTER, RIGHT of imageicon
        label.setVerticalTextPosition(JLabel.TOP);
    // set text TOP,CENTER, BOTTOM of imageicon
//        label.setForeground(new Color(0x00FF00));
    // set font color of text
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));
    // set font of text
        label.setIconTextGap(-25);
    // set gap of text to image
        label.setBackground(Color.gray);
    // set background color
        label.setOpaque(true);
    // display background color
//        label.setBorder(border);
    // sets border of label (not image+text)
        label.setVerticalAlignment(JLabel.CENTER);
    // set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER);
    // set horizontal position of icon+text within label

    JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);
        frame.add(label2);
        frame.add(label3);
        frame.add(get3);
        frame.add(buttons3);
//        frame.add(remove);
        frame.add(get);
        frame.add(buttons);
        frame.add(get2);
        frame.add(buttons2);
        frame.add(title);
        frame.pack();


//    }
}
}
