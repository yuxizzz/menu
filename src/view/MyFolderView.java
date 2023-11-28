package view;

import interface_adapter.create_folder.CreateFolderController;
import interface_adapter.create_folder.CreateFolderState;
import interface_adapter.create_folder.CreateFolderViewModel;
import interface_adapter.delete_folder.DeleteFolderController;
import interface_adapter.delete_folder.DeleteFolderState;
import interface_adapter.delete_folder.DeleteFolderViewModel;
import interface_adapter.logout.LogoutState;
import interface_adapter.logout.LogoutViewModel;
import interface_adapter.my_folder.MyFolderViewModel;
import interface_adapter.open_folder.OpenFolderController;
import interface_adapter.open_folder.OpenFolderState;
import interface_adapter.open_folder.OpenFolderViewModel;
import interface_adapter.remove_recipe.RemoveState;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MyFolderView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "My Folder View";
    private final MyFolderViewModel myFolderViewModel;

    private final LogoutViewModel logoutViewModel;

    private final OpenFolderViewModel openFolderViewModel;
    private final OpenFolderController openFolderController;
    private final DeleteFolderViewModel deleteFolderViewModel;
    private final DeleteFolderController deleteFolderController;
    private final CreateFolderViewModel createFolderViewModel;
    private final CreateFolderController createFolderController;

    JLabel username;
    final JButton openFolder;
    final JButton deleteFolder;
    final JButton createFolder;
    final JButton logOut;


    /**
     * A window with a title and a JButton.
     */
    public MyFolderView(MyFolderViewModel myFolderViewModel,
                        LogoutViewModel logoutViewModel,
                        OpenFolderViewModel openFolderViewModel,
                        OpenFolderController openFolderController,
                        DeleteFolderViewModel deleteFolderViewModel,
                        DeleteFolderController deleteFolderController,
                        CreateFolderViewModel createFolderViewModel,
                        CreateFolderController createFolderController) {
        this.myFolderViewModel = myFolderViewModel;
        this.logoutViewModel = logoutViewModel;
        this.openFolderViewModel = openFolderViewModel;
        this.openFolderController = openFolderController;
        this.deleteFolderViewModel = deleteFolderViewModel;
        this.deleteFolderController = deleteFolderController;
        this.createFolderViewModel = createFolderViewModel;
        this.createFolderController = createFolderController;
        this.myFolderViewModel.addPropertyChangeListener(this);
        this.logoutViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("My Folder Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Username: ");
        username = new JLabel();


        JButton logOut = new JButton(myFolderViewModel.LOGOUT_BUTTON_LABEL);
        JButton openFolder = new JButton(myFolderViewModel.OPEN_BUTTON_LABEL);
        JButton deleteFolder = new JButton(myFolderViewModel.DELETE_BUTTON_LABEL);
        JButton createFolder = new JButton(myFolderViewModel.CREATE_BUTTON_LABEL);

        this.openFolder = openFolder;
        this.deleteFolder = deleteFolder;
        this.createFolder = createFolder;
        this.logOut = logOut;

        ArrayList<String> folderList = myFolderViewModel.getFolderList();
        for (String item : folderList) {
            this.myFolderViewModel.addPropertyChangeListener(this);
            JPanel buttons = new JPanel();
            buttons.add(openFolder);
            buttons.add(deleteFolder);
            openFolder.setBounds(600, 10, 250, 100);
            openFolder.setText("OPEN");

            deleteFolder.setBounds(900, 10, 250, 100);
            deleteFolder.setText("DELETE");

            openFolder.addActionListener(

                    // This creates an anonymous subclass of ActionListener and instantiates it.
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(openFolder)) {
                            OpenFolderState currentState = openFolderViewModel.getState();

                            openFolderController.execute(
                                    currentState.getFoldername());
                            }
                        }
                    }
            );

            deleteFolder.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource().equals(deleteFolder)) {

                                DeleteFolderState currentState = deleteFolderViewModel.getState();
                                deleteFolderController.execute(currentState.getFolderDeleted());
                            }
                        }
                    }
            );

//        TODO need to get information in folder for recipe

            // TODO add listener to each folder in my folder view. use the for loop in Opened Folder View


            logOut.addActionListener(

                    // This creates an anonymous subclass of ActionListener and instantiates it.
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(logOut)) {
                                LogoutState currentState = logoutViewModel.getState();

                            }
                        }
                    });
            buttons.add(logOut);
            buttons.add(createFolder);

            createFolder.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource().equals(createFolder)) {

                                CreateFolderState currentState = createFolderViewModel.getState();
                                createFolderController.execute(currentState.getFoldername());
                                // TODO check create folder state something might wrong
                            }
                        }
                    }
            );
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            this.add(title);
            this.add(usernameInfo);
            this.add(username);
            this.add(buttons);
        }
    }

            /**
             * React to a button click that results in evt.
             */
            public void actionPerformed (ActionEvent evt){
                System.out.println("Click " + evt.getActionCommand());
            }

            @Override
            public void propertyChange(PropertyChangeEvent evt){

    }
}

