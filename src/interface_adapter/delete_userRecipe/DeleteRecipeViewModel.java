package interface_adapter.delete_userRecipe;

import interface_adapter.ViewModel;
import interface_adapter.search.SearchState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteRecipeViewModel extends ViewModel {
    public static final String TITLE_LABEL = "delete recipe view";
    private DeleteRecipeState state = new DeleteRecipeState();

    public DeleteRecipeViewModel(){ super("delete user recipe");}

    public void setState(DeleteRecipeState state){
        this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    // This is what the DeleteRecipe Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public DeleteRecipeState getState() {
        return state;
    }


}
