package app;

import entity.recipe.CommonRecipeFactory;
import entity.recipe.RecipeFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.open_folder.OpenFolderViewModel;
import interface_adapter.open_recipe.OpenRecipeController;
import interface_adapter.open_recipe.OpenRecipePresenter;
import interface_adapter.open_recipe.OpenRecipeViewModel;
import interface_adapter.opened_folder.OpenedFolderViewModel;
import interface_adapter.remove_recipe.RemoveController;
import interface_adapter.remove_recipe.RemovePresenter;
import interface_adapter.remove_recipe.RemoveViewModel;
import use_case.open_recipe.OpenRecipeDataAccessInterface;
import use_case.open_recipe.OpenRecipeInputBoundary;
import use_case.open_recipe.OpenRecipeInteractor;
import use_case.open_recipe.OpenRecipeOutputBoundary;
import use_case.remove_recipe.RemoveDataAccessInterface;
import use_case.remove_recipe.RemoveDataAccessInterface;
import use_case.remove_recipe.RemoveInputBoundary;
import use_case.remove_recipe.RemoveInteractor;
import use_case.remove_recipe.RemoveOutputBoundary;
import view.OpenedFolderView;

import javax.swing.*;
import java.io.IOException;

public class OpenedFolderUseCaseFactory {
    private OpenedFolderUseCaseFactory() {}

    public static OpenedFolderView create(
            ViewManagerModel viewManagerModel,
            OpenedFolderViewModel openedFolderViewModel,
            OpenFolderViewModel openFolderViewModel,
            OpenRecipeViewModel openRecipeViewModel,
            EditRecipeViewModel editRecipeViewModel,
            GetRecipeViewModel getRecipeViewModel,
            CollectRecipeViewModel collectRecipeViewModel,
            RemoveViewModel removeViewModel,
            RemoveDataAccessInterface removeDataAccessObject,
            OpenRecipeDataAccessInterface openRecipeDataAccessObject) {

        try {
            RemoveController removeController = createRemoveUseCase(viewManagerModel,
                    openedFolderViewModel, removeViewModel, removeDataAccessObject);
            OpenRecipeController openRecipeController = createOpenRecipeUseCase(viewManagerModel,
                    openRecipeViewModel,editRecipeViewModel, getRecipeViewModel, collectRecipeViewModel,openRecipeDataAccessObject);

            return new OpenedFolderView(openedFolderViewModel, removeController,
                    openRecipeViewModel, openRecipeController,
                    removeViewModel);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static RemoveController createRemoveUseCase(ViewManagerModel viewManagerModel,
                                                        OpenedFolderViewModel openedFolderViewModel,
                                                        RemoveViewModel removeViewModel,
                                                        RemoveDataAccessInterface removeDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        RemoveOutputBoundary removeOutputBoundary = new RemovePresenter(viewManagerModel,
                openedFolderViewModel, removeViewModel);

//        SearchResult searchResult = new SearchResult();
//        userFactory = new CommonUserFactory();

        RemoveInputBoundary removeInteractor = new RemoveInteractor(
                removeDataAccessObject, removeOutputBoundary);
        return new RemoveController(removeInteractor);
    }


    private static OpenRecipeController createOpenRecipeUseCase(
            ViewManagerModel viewManagerModel, OpenRecipeViewModel openRecipeViewModel, EditRecipeViewModel editRecipeViewModel,
            GetRecipeViewModel getRecipeViewModel, CollectRecipeViewModel collectRecipeViewModel,
            OpenRecipeDataAccessInterface openRecipeDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        OpenRecipeOutputBoundary openRecipeOutputBoundary = new OpenRecipePresenter(openRecipeViewModel,
                getRecipeViewModel,editRecipeViewModel, collectRecipeViewModel, viewManagerModel);

        RecipeFactory recipeFactory = new CommonRecipeFactory();

        OpenRecipeInputBoundary openRecipeController = new OpenRecipeInteractor(
                openRecipeDataAccessObject, openRecipeOutputBoundary);

        return new OpenRecipeController(openRecipeController);
    }
}
