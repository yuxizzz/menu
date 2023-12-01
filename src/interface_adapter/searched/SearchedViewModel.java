package interface_adapter.searched;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class SearchedViewModel extends ViewModel {
    public static final String GET_BUTTON_LABEL = "GET";
    public static final String TITLE_LABEL = "Searched Result View";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private SearchedState state = new SearchedState();
    public SearchedViewModel(){super("get recipes");}

    public void setState(SearchedState state){this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Searched Presenter will call to let the ViewModel know
    // to alert the View
    @Override
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public SearchedState getState(){return state;}
}
