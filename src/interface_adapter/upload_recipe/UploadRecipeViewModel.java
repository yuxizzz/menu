package interface_adapter.upload_recipe;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class UploadRecipeViewModel extends ViewModel {
    public UploadRecipeViewModel(String viewName) {
        super(viewName);
    }

    public UploadRecipeState getState() {
        return null;
    }

    public void setState(UploadRecipeState uploadRecipeState) {
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
