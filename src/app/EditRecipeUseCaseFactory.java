package app;

import entity.recipe.UserRecipeFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.default_opened_folder.DefaultOpenedFolderViewModel;
import interface_adapter.edit_recipe.EditRecipeController;
import interface_adapter.edit_recipe.EditRecipePresenter;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import use_case.edit_recipe.EditDataAccessInterface;
import use_case.edit_recipe.EditInputBoundary;
import use_case.edit_recipe.EditInteractor;
import use_case.edit_recipe.EditOutputBoundary;
import view.EditView;

public class EditRecipeUseCaseFactory {
    private EditRecipeUseCaseFactory() {}



    public static EditView create() {
        return null;
    }




    private static EditRecipeController createEditRecipeController(EditRecipeViewModel editRecipeViewModel,
                                                                   ViewManagerModel viewManagerModel,
                                                                   DefaultOpenedFolderViewModel defaultOpenedFolderViewModel,
                                                                   EditDataAccessInterface editDataAccessInterface,
                                                                   UserRecipeFactory userRecipeFactory) {
        EditOutputBoundary editOutputBoundary = new EditRecipePresenter(editRecipeViewModel, viewManagerModel,
                defaultOpenedFolderViewModel);

        EditInputBoundary editInteractor = new EditInteractor(editDataAccessInterface, editOutputBoundary, userRecipeFactory);
        return new EditRecipeController(editInteractor);
    }

}
