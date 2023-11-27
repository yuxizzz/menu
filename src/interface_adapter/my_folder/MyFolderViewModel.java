package interface_adapter.my_folder;

import interface_adapter.ViewModel;
import interface_adapter.login.LoginState;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class MyFolderViewModel extends ViewModel {
    public final String TITLE_LABEL = "My Folder View";
    public final String USERNAME_LABEL = "Username: ";
    public static final String ALL_FOLDER_LABEL = "All Folders";
    public static final String LOGOUT_BUTTON_LABEL = "Log Out";
    public static final String OPEN_BUTTON_LABEL = "Open Folder";
    public static final String DELETE_BUTTON_LABEL = "Delete Folder";
    public static final String CREATE_BUTTON_LABEL = "Create Folder";

    private MyFolderState state = new MyFolderState();

    private ArrayList<String> folderList = new ArrayList<>();

    public MyFolderViewModel() {
        super("my folder");
    }

    public void setState(MyFolderState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public MyFolderState getState() {
        return state;
    }

    public void setFolderList(ArrayList<String> folderList){
        this.folderList = folderList;
    }
    public ArrayList<String> getFolderList(){return folderList;}
}
