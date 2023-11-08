package interface_adapter.remove_recipe;

import interface_adapter.ViewManagerModel;
import use_case.remove_recipe.RemoveOuntputBoundary;
import use_case.remove_recipe.RemoveOutputData;

public class RemovePresenter implements RemoveOuntputBoundary {
    private final RemoveViewModel removeViewModel;
    private ViewManagerModel viewManagerModel;

    public RemovePresenter(ViewManagerModel viewManagerModel,
            RemoveViewModel removeViewModel) {
        this.removeViewModel = removeViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessView(RemoveOutputData response){
        //on success switch to opened folder view & pop up remove ensure
        RemoveState removeState = removeViewModel.getState();
        //? What is the meaning of getRecipeRemoved(), Do I need to use this method?
        //? or I need to make a new method for present remove ensure
        removeState.setRecipeRemoved(response.getRecipeRemoved());
        this.removeViewModel.setState(removeState);
        removeViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(removeViewModel.getViewname());
        viewManagerModel.firePropertyChanged();
    }

    public void prepareFailView(String error){
        RemoveState removeState = removeViewModel.getState();
        removeState.setMessageError(error);
        removeViewModel.firePropertyChanged();
    }
}
