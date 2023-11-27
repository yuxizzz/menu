package interface_adapter.open_folder;

import entity.recipe.Recipe;
import interface_adapter.ViewManagerModel;
import interface_adapter.open_recipe.OpenRecipeState;
import interface_adapter.open_recipe.OpenRecipeViewModel;
import interface_adapter.opened_folder.OpenedFolderState;
import interface_adapter.opened_folder.OpenedFolderViewModel;
import use_case.open_folder.OpenFolderOutputBoundary;
import use_case.open_folder.OpenFolderOutputData;

import java.util.HashMap;

public class OpenFolderPresenter implements OpenFolderOutputBoundary {

    private final OpenFolderViewModel openFolderViewModel;
    private final OpenRecipeViewModel openRecipeViewModel;
    private ViewManagerModel viewManagerModel;

    public OpenFolderPresenter(ViewManagerModel viewManagerModel,
                               OpenFolderViewModel openFolderViewModel,
                               OpenRecipeViewModel openRecipeViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.openFolderViewModel = openFolderViewModel;
        this.openRecipeViewModel = openRecipeViewModel;
    }

    @Override
    public void prepareSuccessView(OpenFolderOutputData response) {
        // On success, switch to the logged in view.

//        OpenRecipeState openRecipeState = openRecipeViewModel.getState();
//        openRecipeState.setFoldername(response.getFoldername());
//        this.openRecipeViewModel.setState(openedFolderState);
//        this.openRecipeViewModel.firePropertyChanged();
//
//        this.viewManagerModel.setActiveView(openRecipeViewModel.getViewName());
//        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        OpenFolderState openFolderState = OpenFolderViewModel.getState();
        openFolderState.setFoldernameError(error);
        openFolderViewModel.firePropertyChanged();
    }

}
