package interface_adapter.clear_users;


import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
public class ClearViewModel extends ViewModel{
    public static final String CLEAR_BUTTON_LABEL = "Clear";
    public static final String TITLE_LABEL = "Clear View";
    private ClearState state = new ClearState();

    public ClearViewModel() {
        super("clear");
    }

    public void setState(ClearState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public ClearState getState() {
        return state;
    }
}

