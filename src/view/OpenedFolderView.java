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
    final JButton get;

    /**
     * A window with a title and a JButton.
     */
    public OpenedFolderView(OpenedFolderViewModel openedFolderViewModel, JButton remove, JButton get) {
        this.openedFolderViewModel = openedFolderViewModel;
        this.remove = remove;
        this.get = get;
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
        label.setBounds(10, 10, 500, 500);
        // set x,y position within frame as well as dimensions

        JPanel buttons = new JPanel();
        get = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
        buttons.add(get);

        remove = new JButton(OpenedFolderViewModel.REMOVE_BUTTON_LABEL);
        buttons.add(remove);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);
        frame.pack();
        frame.add(buttons);

    }

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
