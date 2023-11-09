package interface_adapter.remove_recipe;

import interface_adapter.ViewManagerModel;
import interface_adapter.opened_folder.OpenedFolderViewModel;
import use_case.remove_recipe.RemoveOuntputBoundary;
import use_case.remove_recipe.RemoveOutputData;

public class RemovePresenter implements RemoveOuntputBoundary {
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
        //on success switch to pop up remove ensure
        RemoveState removeState = RemoveViewModel.getState();
        //? What is the meaning of getRecipeRemoved(), Do I need to use this method?
        //? or I need to make a new method for present remove ensure
        removeState.setRecipeRemoved(response.getRecipeRemoved());
        this.removeViewModel.setState(removeState);
        openedFolderViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(removeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }


    public void prepareFailView(String error){
        RemoveState removeState = removeViewModel.getState();
        removeState.setMessageError(error);
        removeViewModel.firePropertyChanged();
    }
}
