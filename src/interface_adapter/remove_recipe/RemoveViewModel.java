package interface_adapter.remove_recipe;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


//Do I need to implement RemoveViewModel or directly use Opened View Model.??
public class RemoveViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Ensure View";

    public static final String Question_LABEL = "Do you ensure to remove this recipe?";
    public static final String ENSURE_BUTTON_LABEL = "Ensure";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";


    private static RemoveState state = new RemoveState();

    public RemoveViewModel() {
        super("ensure");
    }

    public void setState(RemoveState state) { this.state = state;
    }

    public final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Remove Presenter will call to let the ViewModel know
    // to alert the View
    @Override
    public void firePropertyChanged() {support.firePropertyChange("state", null, state);

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public static RemoveState getState(){ return state;}



}
