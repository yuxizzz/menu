package interface_adapter.edit_recipe;

import entity.recipe.UserRecipe;
import entity.user.User;
import interface_adapter.ViewModel;
import interface_adapter.open_folder.OpenFolderState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EditRecipeViewModel extends ViewModel {


    public static final String TITLE_LABEL = "Edit Recipe View";



    public static final String INGREDIENTS_LABEL = "Input ingredients";


    public static final String NUTRITION_LABEL = "Input nutrition";


    public static final String INSTRUCTIONS_LABEL = "Input instructions";


    public static final String IMAGE_LABEL = "Input image";


    public static final String RECIPEURL_LABEL = "Input recipeurl";


    public static final String RECIPEID_LABEL = "Input recipeid";
    public static final String RECIPENANME_LABEL = "Input recipename";


    private  EditRecipeState state = new EditRecipeState();
    public static final String EDIT_BUTTON_LABEL = "edit recipe";

    public static final String CANCEL_BUTTON_LABEL = "cancel recipe";

    private Integer recipeID;



    public EditRecipeViewModel(){super("edit recipe");}


    public EditRecipeViewModel(String viewName) {
        super(viewName);
    }

    public void setState(EditRecipeState state){
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Presenter will call to let the ViewModel know
    // to alert the View

    @Override
    public void firePropertyChanged() {


        support.firePropertyChange("state", null, this.state);

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {


        support.addPropertyChangeListener(listener);

    }

    public  EditRecipeState getState() {
        return state;
    }


    public Integer getRecipeID() {
        return recipeID;
    }
}
