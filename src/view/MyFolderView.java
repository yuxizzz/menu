package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.create_folder.CreateFolderController;
import interface_adapter.create_folder.CreateFolderState;
import interface_adapter.create_folder.CreateFolderViewModel;
import interface_adapter.delete_folder.DeleteFolderController;
import interface_adapter.delete_folder.DeleteFolderState;
import interface_adapter.delete_folder.DeleteFolderViewModel;
import interface_adapter.logout.LogoutViewModel;
import interface_adapter.my_folder.MyFolderState;
import interface_adapter.my_folder.MyFolderViewModel;
import interface_adapter.open_folder.OpenFolderController;
import interface_adapter.open_folder.OpenFolderState;
import interface_adapter.open_folder.OpenFolderViewModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
    ArrayList<JLabel> folderlists;

    JButton openFolder;
    JButton deleteFolder;
    JButton createFolder;


    final private ViewManagerModel viewManagerModel;
//    final JButton logOut;


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
                        CreateFolderController createFolderController,
                        ViewManagerModel viewManagerModel) {

        JLabel title = new JLabel("My Folder Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Username: ");
        JLabel username = new JLabel();
        this.username = username;



//        JButton logOut = new JButton(myFolderViewModel.LOGOUT_BUTTON_LABEL);
        JButton openFolder = new JButton(myFolderViewModel.OPEN_BUTTON_LABEL);
        JButton deleteFolder = new JButton(myFolderViewModel.DELETE_BUTTON_LABEL);
        JButton createFolder = new JButton(myFolderViewModel.CREATE_BUTTON_LABEL);

        this.openFolder = openFolder;
        this.deleteFolder = deleteFolder;
        this.createFolder = createFolder;

        this.myFolderViewModel = myFolderViewModel;
        this.logoutViewModel = logoutViewModel;
        this.openFolderViewModel = openFolderViewModel;
        this.openFolderController = openFolderController;
        this.deleteFolderViewModel = deleteFolderViewModel;
        this.deleteFolderController = deleteFolderController;
        this.createFolderViewModel = createFolderViewModel;
        this.createFolderController = createFolderController;
        this.viewManagerModel = viewManagerModel;

        this.myFolderViewModel.addPropertyChangeListener(this);
        this.logoutViewModel.addPropertyChangeListener(this);
        this.deleteFolderViewModel.addPropertyChangeListener(this);
        this.createFolderViewModel.addPropertyChangeListener(this);

        ArrayList<JLabel> folderlists = new ArrayList<>();
        ArrayList<String> folderList = myFolderViewModel.getFolderList();
        System.out.println(folderList);
        System.out.println(folderlists);
        for (String folder: folderList){
            JLabel f = new JLabel(folder);
            folderlists.add(f);
        }
        this.folderlists = folderlists;



//        JButton logOut = new JButton(myFolderViewModel.LOGOUT_BUTTON_LABEL);
//
//
//        this.logOut = logOut;
//
//        ArrayList<String> folderList = myFolderViewModel.getFolderList();
//        this.foldernames = folderList;
//        JPanel buttons = new JPanel();

        JPanel buttons = new JPanel();
        Integer count = 0;
        for (JLabel foldername : folderlists) {
//            this.myFolderViewModel.addPropertyChangeListener(this);

            buttons.add(openFolder);
            buttons.add(deleteFolder);
            openFolder.setBounds(600, 10 + count, 100, 40);
            openFolder.setText("OPEN");

            deleteFolder.setBounds(900, 10 + count, 100, 40);
            deleteFolder.setText("DELETE");
            count += 50;

            openFolder.addActionListener(

                    // This creates an anonymous subclass of ActionListener and instantiates it.
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(openFolder)) {
                                OpenFolderState currentState = openFolderViewModel.getState();
                                openFolderController.execute(foldername.getText(), currentState.getUsername());
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
                                deleteFolderController.execute(foldername.getText(), currentState.getUsername());
                            }
                        }
                    }
            );

//        TODO need to get information in folder for recipe
//
//             TODO add listener to each folder in my folder view. use the for loop in Opened Folder View


//            logOut.addActionListener(
//
//                    // This creates an anonymous subclass of ActionListener and instantiates it.
//                    new ActionListener() {
//                        public void actionPerformed(ActionEvent evt) {
//                            if (evt.getSource().equals(logOut)) {
//                                LogoutState currentState = logoutViewModel.getState();
//
//                            }
//                        }
//                    });
//            buttons.add(logOut);
            buttons.add(foldername);
            this.add(buttons);

        }
            createFolder.setBounds(600, 1000, 100, 40);
            createFolder.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource().equals(createFolder)) {
                                viewManagerModel.setActiveView(createFolderViewModel.getViewName());
                                viewManagerModel.firePropertyChanged();

                                CreateFolderState currentState = createFolderViewModel.getState();
                                createFolderController.execute(currentState.getFoldername(), currentState.getUsername());
                                // TODO check create folder state something might wrong
                            }
                        }
                    }
            );
        JPanel buttons1 = new JPanel();
        buttons1.add(createFolder);
            buttons.add(createFolder);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(buttons1);
            this.add(buttons);
            this.add(username);
            this.add(title);
        }
    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof DeleteFolderState) {
            DeleteFolderState state = (DeleteFolderState) evt.getNewValue();
            if (state.getFolderDeleted() != null) {
                JOptionPane.showMessageDialog(this, state.getFolderDeleted());
            }
        } else if (evt.getNewValue() instanceof MyFolderState) {
            MyFolderState state = (MyFolderState) evt.getNewValue();
            setButtons(state);
        } else if (evt.getNewValue() instanceof CreateFolderState) {
            CreateFolderState state = (CreateFolderState) evt.getNewValue();
            addButton(state.getFoldername());
        }
    }

    private void addButton(String foldername) {
        JLabel folder = new JLabel(foldername);
        folderlists.add(folder);
    }

    private void setButtons(MyFolderState state) {
        username.setText(state.getUsername());
        for (String foldername : state.getFoldernames()) {
            JLabel folder = new JLabel(foldername);
            folderlists.add(folder);
        }
    }
}
