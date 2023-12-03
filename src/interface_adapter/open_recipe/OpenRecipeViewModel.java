package interface_adapter.open_recipe;

import interface_adapter.ViewModel;
import interface_adapter.open_folder.OpenFolderState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// Open Recipe View Model is the View Model after pressing the open recipe button existing
// in the OpenFolderView, including the recipe information
// For the Data Recipe, there should have remove button.
// For the User Recipe, there should have delete, edit and upload buttons.

public class OpenRecipeViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Open Recipe View";

    public static final String COLLECT_BUTTON_LABEL = "Collect";

    public static final String EDIT_BUTTON_LABEL = "Edit";


    private String openedRecipe;
    private  OpenRecipeState state = new OpenRecipeState();
    public OpenRecipeViewModel() {
        super("open recipe");
    }

    public void setState(OpenRecipeState state){
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Open Recipe Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {

        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public  OpenRecipeState getState() {
        return state;
    }

    public String getOpenedRecipe(){
        return openedRecipe;
    }
}
