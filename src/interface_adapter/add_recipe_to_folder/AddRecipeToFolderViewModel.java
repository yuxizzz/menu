package interface_adapter.add_recipe_to_folder;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddRecipeToFolderViewModel extends ViewModel {
    public final String TITLE_LABEL = "Select Folder View";
    public static final String FOLDER_BUTTON_LABEL = "Folders";
    private AddRecipeToFolderState state = new AddRecipeToFolderState();

    public AddRecipeToFolderViewModel() {
        super("select folder");
    }

    public void setState(AddRecipeToFolderState state) {
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

    public AddRecipeToFolderState getState() {
        return state;
    }
}
