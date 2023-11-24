package interface_adapter.get_recipe;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GetRecipeViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Get Recipe View";
    public static final String COLLECT_BUTTON_LABEL = "Collect";
    private GetRecipeState state = new GetRecipeState();
    public GetRecipeViewModel() {
        super("get recipe");
    }
    public void setState(GetRecipeState state) {
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
    public GetRecipeState getState() {
        return state;
    }
}
