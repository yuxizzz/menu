package interface_adapter.edit_recipe;

import interface_adapter.ViewManagerModel;
import use_case.edit_recipe.EditOutputBoundary;
import use_case.edit_recipe.EditOutputData;

public class EditRecipePresenter implements EditOutputBoundary {

    private final EditRecipeViewModel editRecipeViewModel;
    private final ViewManagerModel viewManagerModel;

    public EditRecipePresenter(EditRecipeViewModel editRecipeViewModel,
                               ViewManagerModel viewManagerModel) {

        this.editRecipeViewModel = editRecipeViewModel;
        this.viewManagerModel = viewManagerModel;
    }













    @Override
    public void prepareSuccessView(EditOutputData message) {
        //On success, switch to the edit folder view.

        EditRecipeState editRecipeState = editRecipeViewModel.getState();
        this.editRecipeViewModel.setState(editRecipeState);
        editRecipeViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(editRecipeViewModel.getViewName());

        viewManagerModel.firePropertyChanged();


    }












    @Override
    public void prepareFailView(String error) {


        EditRecipeState editRecipeState =editRecipeViewModel.getState();

        editRecipeState.setRecipeIDError(error);

        editRecipeViewModel.firePropertyChanged();

    }
}
