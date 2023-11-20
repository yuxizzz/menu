package entity;

import interface_adapter.opened_folder.OpenedFolderViewModel;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

// model for view

public class ReadImage {
    public static void main(String[] args) {
        JLabel title = new JLabel("Opened Folder Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel foldernameInfo = new JLabel("Currently opened folder: ");

//        JButton get = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
//        JButton remove = new JButton(OpenedFolderViewModel.REMOVE_BUTTON_LABEL);
//        JButton button = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
        JButton get = new JButton();
        JButton remove = new JButton();
        get.setBounds(600, 10, 250, 100);
        get.setText("GET");

//        JButton buttonremove = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
        remove.setBounds(900, 10, 250, 100);
        remove.setText("REMOVE");

        JPanel buttons = new JPanel();
        buttons.add(get);
        buttons.add(remove);
//        remove.addActionListener(this);
//        get.addActionListener(this);

        Image image = null;
        try {
            URL url = new URL("https://spoonacular.com/productImages/436359-312x231.jpg");
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Border border = BorderFactory.createLineBorder(Color.green,3);
        JLabel label = new JLabel(new ImageIcon(image));
        label.setBounds(150, 250, 150, 150);
        label.setVisible(true);
        label.setText("recipe title");
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
        label.setBackground(Color.black);
        // set background color
        label.setOpaque(true);
        // display background color
//        label.setBorder(border);
        // sets border of label (not image+text)
        label.setVerticalAlignment(JLabel.CENTER);
        // set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER);
        // set horizontal position of icon+text within label
        label.setBounds(100, 10, 250, 250);

//        Border border = BorderFactory.createLineBorder(Color.green,3);
//        Image image = null;
//        try {
//            URL url = new URL("https://spoonacular.com/productImages/436359-312x231.jpg");
//            image = ImageIO.read(url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        JLabel label = new JLabel(new ImageIcon(image)); //create a label
//        label.setText("bro, do you even code?");
//        // set text of label label.setIcon(image);
//        label.setHorizontalTextPosition(JLabel.CENTER);
//        // set text LEFT,CENTER, RIGHT of imageicon
//        label.setVerticalTextPosition(JLabel.TOP);
//        // set text TOP,CENTER, BOTTOM of imageicon
//        label.setForeground(new Color(0x00FF00));
//        // set font color of text
//        label.setFont(new Font("MV Boli",Font.PLAIN,20));
//        // set font of text
//        label.setIconTextGap(-25);
//        // set gap of text to image
//        label.setBackground(Color.black);
//        // set background color
//        label.setOpaque(true);
//        // display background color
//        label.setBorder(border);
//        // sets border of label (not image+text)
//        label.setVerticalAlignment(JLabel.CENTER);
//        // set vertical position of icon+text within label
//        label.setHorizontalAlignment(JLabel.CENTER);
//        // set horizontal position of icon+text within label
//        label.setBounds(100, 10, 250, 250);
//        // set x,y position within frame as well as dimensions
//
//        JLabel title = new JLabel("Opened Folder Screen");
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//
//        JButton button = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
//        button.setBounds(600, 10, 250, 100);
//        button.setText("OPEN");
//
//        JButton buttonremove = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
//        buttonremove.setBounds(900, 10, 250, 100);
//        buttonremove.setText("REMOVE");

        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);
        frame.add(remove);
        frame.add(get);
        frame.add(buttons);
        frame.add(title);
        frame.pack();

//        ImageIcon icon = new ImageIcon("point.png");
//        ImageIcon icon2 = new ImageIcon("face.png");
//
//        label = new JLabel();
//        label.setIcon(icon2);
//        label.setBounds(150, 250, 150, 150);
//        label.setVisible(false);

//        button = new JButton();
//        button.setBounds(100, 100, 250, 100);
//        button.addActionListener(this);
//        button.setText("I'm a button!");
//
//        button.setFocusable(false);
//        button.setIcon(icon);
//        button.setHorizontalTextPosition(JButton.CENTER);
//        button.setVerticalTextPosition(JButton.BOTTOM);
//        button.setFont(new Font("Comic Sans",Font.BOLD,25));
//        button.setIconTextGap(-15);
//        button.setForeground(Color.cyan);
//        button.setBackground(Color.lightGray);
//        button.setBorder(BorderFactory.createEtchedBorder());
//
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLayout(null);
//        this.setSize(500,500);
//        this.setVisible(true);
//        this.add(button);
//        this.add(label);

//            public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==button) {
//            System.out.println("poo");
//            button.setEnabled(false);
//            label.setVisible(true);

//    }
    }
}
//    public static void main( String[] args )
//    {
//        Image image = null;
//        try {
//            URL url = new URL("https://spoonacular.com/productImages/436359-312x231.jpg");
//            image = ImageIO.read(url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        JFrame frame = new JFrame();
//        frame.setSize(300, 300);
//        JLabel label = new JLabel(new ImageIcon(image));
//        frame.add(label);
//        frame.setVisible(true);
//    }
//}

