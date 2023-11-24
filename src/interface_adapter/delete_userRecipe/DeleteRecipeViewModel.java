package interface_adapter.delete_userRecipe;

import interface_adapter.search.SearchState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteRecipeViewModel {
    private DeleteRecipeState state = new DeleteRecipeState();

    public DeleteRecipeViewModel(){ super();}

    public void setState(DeleteRecipeState state){ this.state = state;}

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
