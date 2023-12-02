package interface_adapter.open_recipe;


import interface_adapter.ViewManagerModel;
import interface_adapter.collect_recipe.CollectRecipeState;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import interface_adapter.edit_recipe.EditRecipeState;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import use_case.open_recipe.OpenRecipeOutputBoundary;
import use_case.open_recipe.OpenRecipeOutputData;

public class OpenRecipePresenter implements OpenRecipeOutputBoundary {

    private final OpenRecipeViewModel openRecipeViewModel;

    private final EditRecipeViewModel editRecipeViewModel;

    private final CollectRecipeViewModel collectRecipeViewModel;
    private final ViewManagerModel viewManagerModel;

    public OpenRecipePresenter(OpenRecipeViewModel openRecipeViewModel,
                               EditRecipeViewModel editRecipeViewModel,
                               CollectRecipeViewModel collectRecipeViewModel,
                               ViewManagerModel viewManagerModel) {
        this.openRecipeViewModel = openRecipeViewModel;
        this.editRecipeViewModel = editRecipeViewModel;
        this.collectRecipeViewModel = collectRecipeViewModel;

        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(OpenRecipeOutputData response) {
        //On success, switch to open recipe view model
        OpenRecipeState openRecipeState = openRecipeViewModel.getState();

        openRecipeState.setRecipeID(response.getRecipeID());

        this.openRecipeViewModel.setState(openRecipeState);

        this.openRecipeViewModel.firePropertyChanged();






        EditRecipeState editRecipeState = editRecipeViewModel.getState();
        editRecipeState.setUsername(response.getUsername());
        editRecipeState.setFoldername(response.getFoldername());
        this.editRecipeViewModel.setState(editRecipeState);
        this.editRecipeViewModel.firePropertyChanged();

        CollectRecipeState collectRecipeState = collectRecipeViewModel.getState();
        collectRecipeState.setUsername(response.getUsername());
        this.collectRecipeViewModel.setState(collectRecipeState);
        this.collectRecipeViewModel.firePropertyChanged();




        this.viewManagerModel.setActiveView(openRecipeViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();



    }

    @Override
    public void prepareFailView(String error) {

        OpenRecipeState openRecipeState = openRecipeViewModel.getState();

        openRecipeState.setRecipeIDError(error);

        openRecipeState.setRecipenameError(error);

        openRecipeViewModel.firePropertyChanged();

    }
}
