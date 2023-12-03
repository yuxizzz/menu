package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.default_opened_folder.DefaultOpenedFolderViewModel;
import interface_adapter.delete_userRecipe.DeleteRecipeController;
import interface_adapter.delete_userRecipe.DeleteRecipePresenter;
import interface_adapter.delete_userRecipe.DeleteRecipeViewModel;
import interface_adapter.opened_folder.OpenedFolderViewModel;
import interface_adapter.remove_recipe.RemoveController;
import interface_adapter.remove_recipe.RemovePresenter;
import interface_adapter.remove_recipe.RemoveViewModel;
import use_case.delete_userRecipe.DeleteRecipeDataAccessInterface;
import use_case.delete_userRecipe.DeleteRecipeInputBoundary;
import use_case.delete_userRecipe.DeleteRecipeInteractor;
import use_case.delete_userRecipe.DeleteRecipeOutputBoundary;
import use_case.remove_recipe.RemoveDataAccessInterface;
import use_case.remove_recipe.RemoveInputBoundary;
import use_case.remove_recipe.RemoveInteractor;
import use_case.remove_recipe.RemoveOutputBoundary;
import view.DeleteUserRecipeView;
import view.RemoveView;

public class RemoveRecipeUseCaseFactory {
    private RemoveRecipeUseCaseFactory() {}



    public static RemoveView create(
            ViewManagerModel viewManagerModel,
            RemoveViewModel removeRecipeViewModel,
            RemoveDataAccessInterface removeDataAccessObject,
            OpenedFolderViewModel openedFolderViewModel) {



        RemoveController removeRecipeController = createRemoveRecipeUseCase(viewManagerModel,
                removeRecipeViewModel, openedFolderViewModel,
                removeDataAccessObject);
        return new RemoveView(removeRecipeViewModel, removeRecipeController);

    }



    private static RemoveController createRemoveRecipeUseCase(ViewManagerModel viewManagerModel,
                                                                    RemoveViewModel removeRecipeViewModel,
                                                                    OpenedFolderViewModel openedFolderViewModel,
                                                              RemoveDataAccessInterface removeDataAccessObject) {
        RemoveOutputBoundary removeRecipeOutputBoundary =
                new RemovePresenter(viewManagerModel, openedFolderViewModel, removeRecipeViewModel);



        RemoveInputBoundary removeRecipeInteractor = new RemoveInteractor(
                removeDataAccessObject, removeRecipeOutputBoundary);
        return new RemoveController(removeRecipeInteractor);
    }
}
