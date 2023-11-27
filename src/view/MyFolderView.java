package view;

import interface_adapter.logout.LogoutState;
import interface_adapter.logout.LogoutViewModel;
import interface_adapter.my_folder.MyFolderViewModel;
import interface_adapter.signup.SignupState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MyFolderView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "My Folder View";
    private final MyFolderViewModel myFolderViewModel;

    private final LogoutViewModel logoutViewModel;

    JLabel username;

    final JButton logOut;



    /**
     * A window with a title and a JButton.
     */
    public MyFolderView(MyFolderViewModel myFolderViewModel, LogoutViewModel logoutViewModel) {
        this.myFolderViewModel = myFolderViewModel;
        this.logoutViewModel = logoutViewModel;
        this.myFolderViewModel.addPropertyChangeListener(this);
        this.logoutViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("My Folder Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Username: ");
        username = new JLabel();

        JPanel buttons = new JPanel();
        logOut = new JButton(myFolderViewModel.LOGOUT_BUTTON_LABEL);
        buttons.add(logOut);

        logOut.addActionListener(

                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logOut)) {
                            LogoutState currentState = logoutViewModel.getState();
                            
                }
            }
        });

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
