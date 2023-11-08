package interface_adapter.delete_folder;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteFolderViewModel extends ViewModel {
    public final String TITLE_LABEL = "Delete Folder View";
    public static final String DELETE_FOLDER_BUTTON_LABEL = "Delete";
    private DeleteFolderState state = new DeleteFolderState();

    public DeleteFolderViewModel() {
        super("delete folder");
    }

    public void setState(DeleteFolderState state) {
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

    public DeleteFolderState getState() {
        return state;
    }

}
