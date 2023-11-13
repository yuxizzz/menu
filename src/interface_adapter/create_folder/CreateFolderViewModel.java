package interface_adapter.create_folder;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateFolderViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Create Folder View";
    public static final String FOLDERNAME_LABEL = "Choose foldername";
    public static final String CREATEFOLDER_BUTTON_LABEL = "Create folder";
    private CreateFolderState state = new CreateFolderState();

    public CreateFolderViewModel() {
        super("create folder");
    }
    public void setState(CreateFolderState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public CreateFolderState getState() {
        return state;
    }
}
