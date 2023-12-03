package interface_adapter.edit_recipe;

import interface_adapter.ViewManagerModel;
import interface_adapter.default_opened_folder.DefaultOpenedFolderViewModel;
import interface_adapter.open_recipe.OpenRecipeState;
import interface_adapter.open_recipe.OpenRecipeViewModel;
import interface_adapter.opened_folder.OpenedFolderState;
import use_case.edit_recipe.EditOutputBoundary;
import use_case.edit_recipe.EditOutputData;

public class EditRecipePresenter implements EditOutputBoundary {

    private final EditRecipeViewModel editRecipeViewModel;
    private final ViewManagerModel viewManagerModel;

    private final DefaultOpenedFolderViewModel defaultOpenedFolderViewModel;

    public EditRecipePresenter(EditRecipeViewModel editRecipeViewModel,
                               ViewManagerModel viewManagerModel,
                               DefaultOpenedFolderViewModel defaultOpenedFolderViewModel) {

        this.editRecipeViewModel = editRecipeViewModel;
        this.viewManagerModel = viewManagerModel;
        this.defaultOpenedFolderViewModel = defaultOpenedFolderViewModel;
    }













    @Override
    public void prepareSuccessView(EditOutputData message) {
        //On success, switch to the edit folder view.

        EditRecipeState editRecipeState = editRecipeViewModel.getState();
        this.editRecipeViewModel.setState(editRecipeState);
        editRecipeViewModel.firePropertyChanged();
        defaultOpenedFolderViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(defaultOpenedFolderViewModel.getViewName());
        viewManagerModel.firePropertyChanged();


    }












    @Override
    public void prepareFailView(String error) {


        EditRecipeState editRecipeState =editRecipeViewModel.getState();

        editRecipeState.setRecipeIDError(error);

        editRecipeViewModel.firePropertyChanged();

    }
}
