package interface_adapter.opened_folder;

import interface_adapter.ViewManagerModel;
import interface_adapter.open_folder.OpenFolderState;
import interface_adapter.open_folder.OpenFolderViewModel;
import interface_adapter.remove_recipe.RemoveState;
import interface_adapter.remove_recipe.RemoveViewModel;
import use_case.open_folder.OpenFolderOutputData;
import use_case.opened_folder.OpenedFolderOutputBoundary;
import use_case.opened_folder.OpenedFolderOutputData;

import javax.swing.*;

public class OpenedFolderPresenter implements OpenedFolderOutputBoundary {
    private final OpenedFolderViewModel openedFolderViewModel;
    private ViewManagerModel viewManagerModel;
//    private OpenRecipeViewModel openRecipeViewModel;
    private RemoveViewModel removeViewModel;

    public OpenedFolderPresenter(ViewManagerModel viewManagerModel,
//                               OpenRecipeViewModel openRecipeViewModel,
                               OpenedFolderViewModel openedFolderViewModel) {
        this.viewManagerModel = viewManagerModel;
//        this.openRecipeViewModel = openRecipeViewModel;
        this.openedFolderViewModel = openedFolderViewModel;
    }

    // TODO compare response to get button and remove button
    @Override
    public void prepareSuccessView(OpenedFolderOutputData response) {
        // On success, switch to the logged in view.
//        if (response.getSource().equals(get)){
//            OpenRecipeState openedFolderState = openRecipeViewModel.getState();
//            openRecipeState.setFoldername(response.getFoldername());
//
//            this.openRecipeViewModel.setState(openedFolderState);
//            this.openRecipeViewModel.firePropertyChanged();
//
//            this.viewManagerModel.setActiveView(openRecipeViewModel.getViewName());
//            this.viewManagerModel.firePropertyChanged();
//        } else if (response.getSource().equals(remove)) {
//            RemoveState openedFolderState = removeViewModel.getState();
//            removeState.setFoldername(response.getFoldername());
//            this.removeViewModel.setState(removeState);
//            this.removeViewModel.firePropertyChanged();
//            this.viewManagerModel.setActiveView(removeViewModel.getViewName());
//            this.viewManagerModel.firePropertyChanged();
//        }
    }

    @Override
    public void prepareFailView(String error) {
        OpenedFolderState openedFolderState = OpenedFolderViewModel.getState();
        openedFolderState.setFoldernameError(error);
        openedFolderViewModel.firePropertyChanged();
    }

}
