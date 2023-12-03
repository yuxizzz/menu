package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderViewModel;
import interface_adapter.collect_recipe.CollectRecipeController;
import interface_adapter.collect_recipe.CollectRecipePresenter;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import interface_adapter.default_opened_folder.DefaultOpenedFolderViewModel;
import interface_adapter.delete_userRecipe.DeleteRecipeController;
import interface_adapter.delete_userRecipe.DeleteRecipePresenter;
import interface_adapter.delete_userRecipe.DeleteRecipeViewModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import use_case.collect_recipe.CollectRecipeDataAccessInterface;
import use_case.collect_recipe.CollectRecipeInputBoundary;
import use_case.collect_recipe.CollectRecipeInteractor;
import use_case.collect_recipe.CollectRecipeOutputBoundary;
import use_case.delete_userRecipe.DeleteRecipeDataAccessInterface;
import use_case.delete_userRecipe.DeleteRecipeInputBoundary;
import use_case.delete_userRecipe.DeleteRecipeInteractor;
import use_case.delete_userRecipe.DeleteRecipeOutputBoundary;
import view.DeleteUserRecipeView;
import view.RecipeView;

public class DeleteRecipeUseCaseFactory {

    private DeleteRecipeUseCaseFactory() {}
    public static DeleteUserRecipeView create(
            ViewManagerModel viewManagerModel,
            DeleteRecipeViewModel deleteRecipeViewModel,
            DeleteRecipeDataAccessInterface deleteRecipeDataAccessObject,
            DefaultOpenedFolderViewModel defaultOpenedFolderViewModel) {

        DeleteRecipeController deleteRecipeController = createDeleteRecipeUseCase(viewManagerModel,
                deleteRecipeViewModel, deleteRecipeDataAccessObject);
        return new DeleteUserRecipeView(deleteRecipeViewModel, deleteRecipeController, defaultOpenedFolderViewModel);

    }

    private static DeleteRecipeController createDeleteRecipeUseCase(ViewManagerModel viewManagerModel,
                                                                    DeleteRecipeViewModel deleteRecipeViewModel,
                                                                    DeleteRecipeDataAccessInterface deleteRecipeDataAccessObject) {
        DeleteRecipeOutputBoundary deleteRecipeOutputBoundary =
                new DeleteRecipePresenter(viewManagerModel, deleteRecipeViewModel);

        DeleteRecipeInputBoundary collectRecipeInteractor = new DeleteRecipeInteractor(
                deleteRecipeDataAccessObject, deleteRecipeOutputBoundary);
        return new DeleteRecipeController(collectRecipeInteractor);
    }
}
