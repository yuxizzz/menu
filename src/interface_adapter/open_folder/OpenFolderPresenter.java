package interface_adapter.open_folder;

import entity.recipe.Recipe;
import interface_adapter.ViewManagerModel;
import interface_adapter.opened_folder.OpenedFolderState;
import interface_adapter.opened_folder.OpenedFolderViewModel;
import use_case.open_folder.OpenFolderOutputBoundary;
import use_case.open_folder.OpenFolderOutputData;

import java.util.HashMap;

public class OpenFolderPresenter implements OpenFolderOutputBoundary {

    private final OpenFolderViewModel openFolderViewModel;
    private final OpenedFolderViewModel openedFolderViewModel;
    private ViewManagerModel viewManagerModel;

    public OpenFolderPresenter(ViewManagerModel viewManagerModel,
                               OpenFolderViewModel openFolderViewModel,
                               OpenedFolderViewModel openedFolderViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.openFolderViewModel = openFolderViewModel;
        this.openedFolderViewModel = openedFolderViewModel;
    }

    @Override
    public void prepareSuccessView(OpenFolderOutputData response) {
        // On success, switch to the logged in view.

        OpenedFolderState openedFolderState = openedFolderViewModel.getState();
        openedFolderState.setFoldername(response.getFoldername());
        this.openedFolderViewModel.setState(openedFolderState);
        this.openedFolderViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(openedFolderViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        OpenFolderState openFolderState = OpenFolderViewModel.getState();
        openFolderState.setFoldernameError(error);
        openFolderViewModel.firePropertyChanged();
    }

}
