package interface_adapter.open_folder;

import entity.recipe.Recipe;
import interface_adapter.ViewModel;
import interface_adapter.login.LoginState;
import interface_adapter.open_folder.OpenFolderState;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class OpenFolderViewModel extends ViewModel {
    public final String TITLE_LABEL = "Opened Folder View";

    private static OpenFolderState state = new OpenFolderState();

    public static final String REMOVE_BUTTON_LABEL = "Remove recipe";
    public static final String GET_BUTTON_LABEL = "Get recipe";
    private String openedFolder;
    private HashMap<Integer, ArrayList> recipeMap;


    public OpenFolderViewModel() {
        super("opened folder");
    }

    public OpenFolderViewModel(String viewName) {
        super(viewName);
    }

    public void setState(OpenFolderState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


    public static OpenFolderState getState() {
        return state;
    }


    public String getOpenedFolder() {
        return openedFolder;
    }

    public void setRecipeMap(HashMap<Integer, ArrayList> RecipeMap) {
        this.recipeMap = recipeMap;
    }

    public HashMap<Integer, ArrayList> getRecipeMap() {
        return recipeMap;
    }
}
