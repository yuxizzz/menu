package interface_adapter.remove_recipe;

import interface_adapter.ViewModel;
import interface_adapter.clear_users.ClearState;

import java.beans.PropertyChangeListener;


//Do I need to implement RemoveViewModel or directly use Opened View Model.??
public class RemoveViewModel extends ViewModel {
    public final String TITLE_LABEL = "Clear View";
    public static final String CLEAR_BUTTON_LABEL = "Clear all";
    private ClearState state = new ClearState();

    public RemoveViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
