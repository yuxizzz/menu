<<<<<<< HEAD
package src.interface_adapter;
=======
package interface_adapter;
>>>>>>> Hong

import java.beans.PropertyChangeListener;

public abstract class ViewModel {

    private String viewName;

    public ViewModel(String viewName) {
        this.viewName = viewName;
    }
    public String getViewName() {
        return this.viewName;
    }

    public abstract void firePropertyChanged();
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);


}
