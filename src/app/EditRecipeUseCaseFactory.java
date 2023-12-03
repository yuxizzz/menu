package app;

import entity.recipe.UserRecipeFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.default_opened_folder.DefaultOpenedFolderViewModel;
import interface_adapter.delete_userRecipe.DeleteRecipeController;
import interface_adapter.delete_userRecipe.DeleteRecipePresenter;
import interface_adapter.delete_userRecipe.DeleteRecipeViewModel;
import interface_adapter.edit_recipe.EditRecipeController;
import interface_adapter.edit_recipe.EditRecipePresenter;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.open_recipe.OpenRecipeViewModel;
import use_case.delete_userRecipe.DeleteRecipeDataAccessInterface;
import use_case.delete_userRecipe.DeleteRecipeInputBoundary;
import use_case.delete_userRecipe.DeleteRecipeInteractor;
import use_case.delete_userRecipe.DeleteRecipeOutputBoundary;
import use_case.edit_recipe.EditDataAccessInterface;
import use_case.edit_recipe.EditInputBoundary;
import use_case.edit_recipe.EditInteractor;
import use_case.edit_recipe.EditOutputBoundary;
import view.DeleteUserRecipeView;
import view.EditView;

public class EditRecipeUseCaseFactory {
    private EditRecipeUseCaseFactory() {}
    public static EditView create(
            ViewManagerModel viewManagerModel,
            EditRecipeViewModel editRecipeViewModel,
            EditDataAccessInterface editDataAccessObject,
            DefaultOpenedFolderViewModel defaultOpenedFolderViewModel) {

        EditRecipeController editRecipeController = createEditRecipeUseCase(viewManagerModel,
                editRecipeViewModel, editDataAccessObject, defaultOpenedFolderViewModel);
        return new EditView(editRecipeViewModel, editRecipeController, defaultOpenedFolderViewModel);

    }

    private static EditRecipeController createEditRecipeUseCase(ViewManagerModel viewManagerModel,
                                                                  EditRecipeViewModel editRecipeViewModel,
                                                                  EditDataAccessInterface editDataAccessObject,
                                                                DefaultOpenedFolderViewModel defaultOpenedFolderViewModel) {
        EditOutputBoundary editRecipeOutputBoundary =
                new EditRecipePresenter(editRecipeViewModel, viewManagerModel, defaultOpenedFolderViewModel);

        UserRecipeFactory userRecipeFactory = new UserRecipeFactory();

        EditInputBoundary editRecipeInteractor = new EditInteractor(
                editDataAccessObject, editRecipeOutputBoundary, userRecipeFactory);
        return new EditRecipeController(editRecipeInteractor);
    }
}
