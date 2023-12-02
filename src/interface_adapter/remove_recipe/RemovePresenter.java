package interface_adapter.remove_recipe;

import interface_adapter.ViewManagerModel;
import interface_adapter.opened_folder.OpenedFolderState;
import interface_adapter.opened_folder.OpenedFolderViewModel;
//import use_case.remove_recipe.RemoveOuntputBoundary;
import use_case.remove_recipe.RemoveOutputBoundary;
import use_case.remove_recipe.RemoveOutputData;

public class RemovePresenter implements RemoveOutputBoundary {
    private final OpenedFolderViewModel openedFolderViewModel;
    private final RemoveViewModel removeViewModel;
    private ViewManagerModel viewManagerModel;

    public RemovePresenter(ViewManagerModel viewManagerModel,
                           OpenedFolderViewModel openedFolderViewModel, RemoveViewModel removeViewModel) {
        this.openedFolderViewModel = openedFolderViewModel;
        this.viewManagerModel = viewManagerModel;
        this.removeViewModel = removeViewModel;
    }

    public void prepareSuccessView(RemoveOutputData response){
        //on success switch to pop up remove ensure, and then opened view.
        OpenedFolderState openedFolderState = OpenedFolderViewModel.getState();
        //Do we need to implement something like that loginState.setUsername(response.getUsername());
        this.openedFolderViewModel.setState(openedFolderState);
        openedFolderViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(openedFolderViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }


    public void prepareFailView(String error){
        RemoveState removeState = removeViewModel.getState();
        removeState.setMessageError(error);
        removeViewModel.firePropertyChanged();
    }
}
