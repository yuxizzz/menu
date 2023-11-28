package interface_adapter.get_recipe;

import interface_adapter.ViewManagerModel;
import interface_adapter.collect_recipe.CollectRecipeState;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import use_case.get_recipe.GetRecipeOutputBoundary;
import use_case.get_recipe.GetRecipeOutputData;

public class GetRecipePresenter implements GetRecipeOutputBoundary {
    private final GetRecipeViewModel getRecipeViewModel;
    private final CollectRecipeViewModel collectRecipeViewModel;
    private ViewManagerModel viewManagerModel;

    public GetRecipePresenter(GetRecipeViewModel getRecipeViewModel, CollectRecipeViewModel collectRecipeViewModel, ViewManagerModel viewManagerModel) {
        this.getRecipeViewModel = getRecipeViewModel;
        this.collectRecipeViewModel = collectRecipeViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(GetRecipeOutputData recipe) {
        GetRecipeState getRecipeState = getRecipeViewModel.getState();
        getRecipeState.setRecipe(recipe.getRecipe());
        CollectRecipeState collectRecipeState = collectRecipeViewModel.getState();
        collectRecipeState.setRecipeID(getRecipeState.getRecipeID());
        this.getRecipeViewModel.setState(getRecipeState);
        getRecipeViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(getRecipeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        GetRecipeState getRecipeState = getRecipeViewModel.getState();
        getRecipeState.setRecipeError(error);
        getRecipeViewModel.firePropertyChanged();
    }
}
