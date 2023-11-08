package interface_adapter.search;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Search Your Recipes!";
    public static final String SEARCH_BUTTON_LABEL = "Search";
    public static final String INGREDIENT_BUTTON_LABEL = "Ingredients";

    public static final String ALLERGY_BUTTON_LABEL = "Allergy/Intolerance";
    public static final String MYFOLDER_BUTTON_LABEL = "My Folder";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private SearchState state = new SearchState();

    public SearchViewModel() {
        super("search recipes");
    }

    public void setState(SearchState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Search Presenter will call to let the ViewModel know
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
