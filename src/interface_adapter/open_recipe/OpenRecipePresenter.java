package interface_adapter.open_recipe;


import entity.recipe.UserRecipe;
import interface_adapter.ViewManagerModel;
import interface_adapter.collect_recipe.CollectRecipeState;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import interface_adapter.edit_recipe.EditRecipeState;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.get_recipe.GetRecipeState;
import interface_adapter.get_recipe.GetRecipeViewModel;
import use_case.open_recipe.OpenRecipeOutputBoundary;
import use_case.open_recipe.OpenRecipeOutputData;
import view.RecipeView;
import view.RemoveView;
import view.UserRecipeView;

public class OpenRecipePresenter implements OpenRecipeOutputBoundary {

    private final OpenRecipeViewModel openRecipeViewModel;

    private final GetRecipeViewModel getRecipeViewModel;



    private final EditRecipeViewModel editRecipeViewModel;

    private final CollectRecipeViewModel collectRecipeViewModel;
    private final ViewManagerModel viewManagerModel;

    public OpenRecipePresenter(OpenRecipeViewModel openRecipeViewModel,
                               GetRecipeViewModel getRecipeViewModel,
                               EditRecipeViewModel editRecipeViewModel,
                               CollectRecipeViewModel collectRecipeViewModel,
                               ViewManagerModel viewManagerModel) {
        this.openRecipeViewModel = openRecipeViewModel;
        this.getRecipeViewModel = getRecipeViewModel;
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


        GetRecipeState getRecipeState = getRecipeViewModel.getState();

        getRecipeState.setRecipeID(response.getRecipeID());

        this.getRecipeViewModel.setState(getRecipeState);

        this.getRecipeViewModel.firePropertyChanged();




        EditRecipeState editRecipeState = editRecipeViewModel.getState();
        editRecipeState.setUsername(response.getUsername());
        editRecipeState.setFoldername(response.getFoldername());
        this.editRecipeViewModel.setState(editRecipeState);
        this.editRecipeViewModel.firePropertyChanged();


        CollectRecipeState collectRecipeState = collectRecipeViewModel.getState();
        collectRecipeState.setUsername(response.getUsername());
        this.collectRecipeViewModel.setState(collectRecipeState);
        this.collectRecipeViewModel.firePropertyChanged();



        if (response.getUsername() != null){
            this.viewManagerModel.setActiveView(openRecipeViewModel.getViewName());

        }else{
            this.viewManagerModel.setActiveView(getRecipeViewModel.getViewName());

        }this.viewManagerModel.firePropertyChanged();




    }

    @Override
    public void prepareFailView(String error) {

        OpenRecipeState openRecipeState = openRecipeViewModel.getState();

        openRecipeState.setRecipeIDError(error);

        openRecipeState.setRecipenameError(error);

        openRecipeViewModel.firePropertyChanged();

    }
}
