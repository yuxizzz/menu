<<<<<<< HEAD
package src.interface_adapter.clear_users;
=======
package interface_adapter.clear_users;

>>>>>>> Hong

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
<<<<<<< HEAD

public class ClearViewModel extends ViewModel {
    public final String TITLE_LABEL = "Clear View";
    public static final String CLEAR_BUTTON_LABEL = "Clear all";
=======
public class ClearViewModel extends ViewModel{
    public static final String CLEAR_BUTTON_LABEL = "Clear";
    public static final String TITLE_LABEL = "Clear View";
>>>>>>> Hong
    private ClearState state = new ClearState();

    public ClearViewModel() {
        super("clear");
    }

    public void setState(ClearState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

<<<<<<< HEAD
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

=======
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
>>>>>>> Hong
    public ClearState getState() {
        return state;
    }
}
<<<<<<< HEAD
=======

>>>>>>> Hong
