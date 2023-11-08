package interface_adapter.remove_recipe;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


//Do I need to implement RemoveViewModel or directly use Opened View Model.??
public class RemoveViewModel extends ViewModel {
    public final String TITLE_LABEL = "Ensure View";
    public static final String ENSURE_BUTTON_LABEL = "Ensure";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    private static RemoveState state = new RemoveState();

    public RemoveViewModel() {
        super("ensure");
    }

    public void setState(RemoveState state) { this.state = state;
    }

    public final PropertyChangeSupport support = new PropertyChangeSupport(this);


    @Override
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public static RemoveState getState(){ return state;}



}
