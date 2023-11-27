package interface_adapter.logout;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LogoutViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Log Out View";
    public static final String LOGOUT_BUTTON_LABEL = "Log Out";
    private LogoutState state = new LogoutState();

    public LogoutViewModel() {
        super("log out");
    }
    public void setState(LogoutState state) {
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
    public LogoutState getState() {
        return state;
    }
}
