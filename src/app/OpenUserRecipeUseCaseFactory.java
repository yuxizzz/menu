package app;

import entity.recipe.CommonRecipeFactory;
import entity.recipe.RecipeFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.open_recipe.OpenRecipeController;
import interface_adapter.open_recipe.OpenRecipePresenter;
import interface_adapter.open_recipe.OpenRecipeViewModel;
import interface_adapter.remove_recipe.RemoveController;
import use_case.open_recipe.OpenRecipeDataAccessInterface;
import use_case.open_recipe.OpenRecipeInputBoundary;
import use_case.open_recipe.OpenRecipeInteractor;
import use_case.open_recipe.OpenRecipeOutputBoundary;
import view.OpenedFolderView;
import view.UserRecipeView;

import javax.swing.*;
import java.io.IOException;

public class OpenUserRecipeUseCaseFactory {
    private  OpenUserRecipeUseCaseFactory() {}

    public static UserRecipeView create (
            ViewManagerModel viewManagerModel,
            OpenRecipeViewModel openRecipeViewModel,
            EditRecipeViewModel editRecipeViewModel,
            CollectRecipeViewModel collectRecipeViewModel,
            OpenRecipeDataAccessInterface openRecipeDataAccessObject) {
        try {
            OpenRecipeController openRecipeController = createOpenRecipeUseCase(viewManagerModel,
                    openRecipeViewModel,editRecipeViewModel, collectRecipeViewModel,openRecipeDataAccessObject);
            RemoveController removeController = createRemoveUseCase(viewManagerModel,
                    openedFolderViewModel, removeViewModel, removeDataAccessObject);

            return new OpenedFolderView(removeController, openRecipeViewModel,
                    openRecipeController, removeViewModel);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }
    }

    private static OpenRecipeController createOpenRecipeUseCase(
            ViewManagerModel viewManagerModel, OpenRecipeViewModel openRecipeViewModel, EditRecipeViewModel editRecipeViewModel,
            CollectRecipeViewModel collectRecipeViewModel,
            OpenRecipeDataAccessInterface openRecipeDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        OpenRecipeOutputBoundary openRecipeOutputBoundary = new OpenRecipePresenter(openRecipeViewModel,
                editRecipeViewModel, collectRecipeViewModel, viewManagerModel);

        RecipeFactory recipeFactory = new CommonRecipeFactory();

        OpenRecipeInputBoundary openRecipeController = new OpenRecipeInteractor(
                openRecipeDataAccessObject, openRecipeOutputBoundary);

        return new OpenRecipeController(openRecipeController);
}
