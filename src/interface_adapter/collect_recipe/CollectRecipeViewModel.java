package interface_adapter.collect_recipe;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CollectRecipeViewModel extends ViewModel {
    public static final String COLLECT_BUTTON_LABEL = "collect";
    public static final String TITLE_LABEL = "Collect Recipe View";

    private CollectRecipeState state = new CollectRecipeState();

    public CollectRecipeViewModel() {
        super("collect recipe");
    }

    public void setState(CollectRecipeState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


    public CollectRecipeState getState() { return state;
    }
}
