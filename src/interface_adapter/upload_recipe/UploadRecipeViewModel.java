package interface_adapter.upload_recipe;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UploadRecipeViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Upload Recipe View";

    public static final String RECIPENANME_LABEL = "Choose recipename";


    public static final String INGREDIENTS_LABEL = "Choose ingredients";


    public static final String NUTRITION_LABEL = "Choose nutrition";


    public static final String INSTRUCTIONS_LABEL = "Choose instructions";


    public static final String IMAGE_LABEL = "Choose image";


    public static final String RECIPEURL_LABEL = "Choose recipeURL";


    public static final String RECIPEID_LABEL = "Choose recipeid";



    public static final String UPLOAD_BUTTON_LABEL = "upload recipe";

    public static final String CANCEL_BUTTON_LABEL = "cancel recipe";



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

    public UploadRecipeState getState(){

        return state;
    }
}
