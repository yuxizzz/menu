
package interface_adapter.opened_folder;

import interface_adapter.ViewModel;
import interface_adapter.login.LoginState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OpenedFolderViewModel extends ViewModel {
    public final String TITLE_LABEL = "Opened Folder View";

    private OpenedFolderState state = new OpenedFolderState();

    public static final String LOGOUT_BUTTON_LABEL = "Log out";
    private String openedFolder;

    public OpenedFolderViewModel() {
        super("opened folder");
    }

    public OpenedFolderViewModel(String viewName) {
        super(viewName);
    }

    public void setState(OpenedFolderState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Login Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public OpenedFolderState getState() {
        return state;
    }


    public String getOpenedFolder() {
        return openedFolder;
    }

    public void setOpenedFolder(String openedFolder) {
        this.openedFolder = openedFolder;
    }
}
