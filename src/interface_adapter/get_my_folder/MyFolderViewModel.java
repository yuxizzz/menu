package interface_adapter.get_my_folder;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MyFolderViewModel extends ViewModel {
    public final String TITLE_LABEL = "My Folder View";
    public final String USERNAME_LABEL = "Username: ";
    public static final String ALL_FOLDER_LABEL = "All Folders";
    public static final String LOGOUT_BUTTON_LABEL = "Log Out";

    private MyFolderState state = new MyFolderState();

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
}
