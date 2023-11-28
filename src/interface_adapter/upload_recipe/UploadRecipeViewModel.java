package interface_adapter.upload_recipe;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UploadRecipeViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Upload Recipe View";

    public static final String RECIPENANME_LABEL = "Choose recipename";

    public static final String UPLOADFOLDER_BUTTON_LABEL = "upload recipe";

    private UploadRecipeState state = new UploadRecipeState();
    public UploadRecipeViewModel() {
        super("upload recipe");
    }


    public void setState(UploadRecipeState uploadRecipeState) {
        this.state = uploadRecipeState;
    }
    public final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);

    }



    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);

    }

    public UploadRecipeState getState(){return state;}
}
