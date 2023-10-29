package interface_adapter.search;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchViewModel {
    public static final String SEARCH_BUTTON_LABEL = "Search";
    public static final String TITLE_LABEL = "Search View";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private SearchState state = new SearchState();

    public SearchViewModel() {
        super("search recipes");
    }

    public void setState(SearchState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SearchState getState() {
        return state;
    }
}
