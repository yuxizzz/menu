package view;

import interface_adapter.opened_folder.OpenedFolderState;
import interface_adapter.opened_folder.OpenedFolderViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;

public class OpenedFolderView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "opened folder";
    private final OpenedFolderViewModel openedFolderViewModel;

    JLabel foldername;
    final JButton remove;
    final JButton open;

    /**
     * A window with a title and a JButton.
     */
    public OpenedFolderView(OpenedFolderViewModel openedFolderViewModel, JButton remove, JButton get) {
        this.openedFolderViewModel = openedFolderViewModel;
        this.remove = remove;
        this.open = get;
        this.openedFolderViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Opened Folder Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel foldernameInfo = new JLabel("Currently opened folder: ");
        foldername = new JLabel();

        JPanel buttons = new JPanel();
        get = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
        buttons.add(get);

        get.addActionListener(this);

        remove = new JButton(OpenedFolderViewModel.REMOVE_BUTTON_LABEL);
        buttons.add(remove);

        remove.addActionListener(this);


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(foldernameInfo);
        this.add(foldername);
        this.add(buttons);
    }
    public static void main( String[] args)
    {   JButton remove;
        JButton get;
        Image image = null;
        try {
            URL url = new URL("https://spoonacular.com/productImages/436359-312x231.jpg");
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Border border = BorderFactory.createLineBorder(Color.green,3);

        JLabel label = new JLabel(new ImageIcon(image)); //create a label
        label.setText("bro, do you even code?");
        // set text of label label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        // set text LEFT,CENTER, RIGHT of imageicon
        label.setVerticalTextPosition(JLabel.TOP);
        // set text TOP,CENTER, BOTTOM of imageicon
        label.setForeground(new Color(0x00FF00));
        // set font color of text
        label.setFont(new Font("MV Boli",Font.PLAIN,20));
        // set font of text
        label.setIconTextGap(-25);
        // set gap of text to image
        label.setBackground(Color.black);
        // set background color
        label.setOpaque(true);
        // display background color
        label.setBorder(border);
        // sets border of label (not image+text)
        label.setVerticalAlignment(JLabel.CENTER);
        // set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER);
        // set horizontal position of icon+text within label
        label.setBounds(100, 10, 250, 250);
        // set x,y position within frame as well as dimensions

        JLabel title = new JLabel("Opened Folder Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        JButton button = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
        button.setBounds(600, 10, 250, 100);
        button.setText("OPEN");

        JButton buttonremove = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
        buttonremove.setBounds(900, 10, 250, 100);
        buttonremove.setText("REMOVE");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);
        frame.add(button);
        frame.add(buttonremove);
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
    }

    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==button) {
//            System.out.println("poo");
//            button.setEnabled(false);
//            label.setVisible(true);
//
//    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        OpenedFolderState state = (OpenedFolderState) evt.getNewValue();
        foldername.setText(state.getFoldername());
    }
}
