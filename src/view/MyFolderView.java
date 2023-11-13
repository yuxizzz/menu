package view;

import interface_adapter.my_folder.MyFolderViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MyFolderView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "My Folder View";
    private final MyFolderViewModel myFolderViewModel;

    JLabel username;

    final JButton logOut;



    /**
     * A window with a title and a JButton.
     */
    public MyFolderView(MyFolderViewModel myFolderViewModel) {
        this.myFolderViewModel = myFolderViewModel;
        this.myFolderViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("My Folder Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Username: ");
        username = new JLabel();

        JPanel buttons = new JPanel();
        logOut = new JButton(myFolderViewModel.LOGOUT_BUTTON_LABEL);
        buttons.add(logOut);

        logOut.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(username);
        this.add(buttons);
    }


    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}
