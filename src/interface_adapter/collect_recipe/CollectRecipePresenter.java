package interface_adapter.collect_recipe;

import interface_adapter.ViewManagerModel;
import use_case.collect_recipe.CollectRecipeOutputBoundary;
import use_case.collect_recipe.CollectRecipeOutputData;

public class CollectRecipePresenter implements CollectRecipeOutputBoundary {
    private final CollectRecipeViewModel collectRecipeViewModel;
    private ViewManagerModel viewManagerModel;

    public CollectRecipePresenter(CollectRecipeViewModel collectRecipeViewModel) {

        this.collectRecipeViewModel = collectRecipeViewModel;
    }
    @Override
    public void prepareFailView(String error) {
        CollectRecipeState collectRecipeState = collectRecipeViewModel.getState();
        collectRecipeState.setNoFolderError(error);
        collectRecipeViewModel.firePropertyChanged();

    }

    @Override
    public void prepareSuccessView(CollectRecipeOutputData collectRecipeOutputData) {
        //On success, switch to folder popup View


    }
}
