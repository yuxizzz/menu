package interface_adapter.open_recipe;


import interface_adapter.ViewManagerModel;
import use_case.open_recipe.OpenRecipeOutputBoundary;
import use_case.open_recipe.OpenRecipeOutputData;

public class OpenRecipePresenter implements OpenRecipeOutputBoundary {

    private final OpenRecipeViewModel openRecipeViewModel;
    private final ViewManagerModel viewManagerModel;

    public OpenRecipePresenter(OpenRecipeViewModel openRecipeViewModel,
                                ViewManagerModel viewManagerModel) {
        this.openRecipeViewModel = openRecipeViewModel;

        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(OpenRecipeOutputData response) {
        //On success, switch to open recipe view model
        OpenRecipeState openRecipeState = OpenRecipeViewModel.getState();

        openRecipeState.setRecipeID(response.getRecipeID());

        this.openRecipeViewModel.setState(openRecipeState);

        this.openRecipeViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(openRecipeViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        OpenRecipeState openRecipeState = OpenRecipeViewModel.getState();
        openRecipeState.setRecipeIDError(error);
        openRecipeState.setRecipenameError(error);
        openRecipeViewModel.firePropertyChanged();

    }
}
