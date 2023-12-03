package interface_adapter.open_folder;

import entity.recipe.Recipe;
import interface_adapter.ViewManagerModel;
import interface_adapter.default_opened_folder.DefaultOpenedFolderState;
import interface_adapter.default_opened_folder.DefaultOpenedFolderViewModel;
import interface_adapter.delete_folder.DeleteFolderViewModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.open_recipe.OpenRecipeState;
import interface_adapter.open_recipe.OpenRecipeViewModel;
import interface_adapter.opened_folder.OpenedFolderState;
import interface_adapter.opened_folder.OpenedFolderViewModel;
import interface_adapter.remove_recipe.RemoveState;
import interface_adapter.remove_recipe.RemoveViewModel;
import interface_adapter.upload_recipe.UploadRecipeState;
import interface_adapter.upload_recipe.UploadRecipeViewModel;
import use_case.open_folder.OpenFolderOutputBoundary;
import use_case.open_folder.OpenFolderOutputData;

import java.util.HashMap;

public class OpenFolderPresenter implements OpenFolderOutputBoundary {

    private final OpenFolderViewModel openFolderViewModel;
    private final OpenRecipeViewModel openRecipeViewModel;
    private ViewManagerModel viewManagerModel;

    private final OpenedFolderViewModel openedFolderViewModel;
    private final UploadRecipeViewModel uploadRecipeViewModel;
    private final DefaultOpenedFolderViewModel defaultOpenedFolderViewModel;
    private RemoveViewModel removeViewModel;


    public OpenFolderPresenter(ViewManagerModel viewManagerModel,
                               OpenFolderViewModel openFolderViewModel,
                               OpenedFolderViewModel openedFolderViewModel,
                               UploadRecipeViewModel uploadRecipeViewModel,
                               DefaultOpenedFolderViewModel defaultOpenedFolderViewModel,
                               OpenRecipeViewModel openRecipeViewModel,
                               RemoveViewModel removeViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.openFolderViewModel = openFolderViewModel;
        this.openRecipeViewModel = openRecipeViewModel;
        this.openedFolderViewModel = openedFolderViewModel;
        this.uploadRecipeViewModel = uploadRecipeViewModel;
        this.defaultOpenedFolderViewModel = defaultOpenedFolderViewModel;
        this.removeViewModel = removeViewModel;

    }

    @Override
    public void prepareSuccessView(OpenFolderOutputData response) {
        // On success, switch to the open folder view.

        OpenedFolderState openedFolderState = openedFolderViewModel.getState();
        openedFolderState.setFoldername(response.getFoldername());
        openedFolderState.setUsername(response.getUsername());
        this.openedFolderViewModel.setState(openedFolderState);
        this.openedFolderViewModel.firePropertyChanged();


        UploadRecipeState uploadRecipeState = uploadRecipeViewModel.getState();
        uploadRecipeState.setUsername(response.getUsername());
        this.uploadRecipeViewModel.setState(uploadRecipeState);
        this.uploadRecipeViewModel.firePropertyChanged();

        DefaultOpenedFolderState defaultOpenedFolderState = defaultOpenedFolderViewModel.getState();
//        defaultOpenedFolderState.setUsername(response.getUsername());
        this.defaultOpenedFolderViewModel.setState(defaultOpenedFolderState);
        this.defaultOpenedFolderViewModel.firePropertyChanged();

        RemoveState removeState = removeViewModel.getState();
        removeState.setUsername(response.getUsername());
        this.removeViewModel.setState(removeState);
        this.removeViewModel.firePropertyChanged();

        OpenRecipeState openRecipeState = openRecipeViewModel.getState();
        openRecipeState.setUsername(response.getUsername());
        this.openRecipeViewModel.setState(openRecipeState);
        this.openRecipeViewModel.firePropertyChanged();

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
