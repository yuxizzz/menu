package app;

import entity.recipe.CommonRecipeFactory;
import entity.recipe.RecipeFactory;
import entity.recipe.UserRecipeFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderViewModel;
import interface_adapter.collect_recipe.CollectRecipeController;
import interface_adapter.collect_recipe.CollectRecipePresenter;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import interface_adapter.edit_recipe.EditRecipeController;
import interface_adapter.edit_recipe.EditRecipePresenter;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.open_recipe.OpenRecipeController;
import interface_adapter.open_recipe.OpenRecipePresenter;
import interface_adapter.open_recipe.OpenRecipeViewModel;
import interface_adapter.remove_recipe.RemoveController;
import use_case.collect_recipe.CollectRecipeDataAccessInterface;
import use_case.collect_recipe.CollectRecipeInputBoundary;
import use_case.collect_recipe.CollectRecipeInteractor;
import use_case.collect_recipe.CollectRecipeOutputBoundary;
import use_case.edit_recipe.*;
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
            AddRecipeToFolderViewModel addRecipeToFolderViewModel,
            CollectRecipeDataAccessInterface fileDataAccessObject,
            OpenRecipeDataAccessInterface openRecipeDataAccessObject,
            EditDataAccessInterface editDataAccessInterface,
            UserRecipeFactory userRecipeFactory) {
        try {
            OpenRecipeController openRecipeController = createOpenRecipeUseCase(viewManagerModel,
                    openRecipeViewModel,editRecipeViewModel, collectRecipeViewModel,openRecipeDataAccessObject);
            CollectRecipeController collectRecipeController = createCollectRecipeUseCase(viewManagerModel,
                    collectRecipeViewModel, addRecipeToFolderViewModel, fileDataAccessObject);
            EditRecipeController editRecipeController = createEditRecipeController(editRecipeViewModel,
                    viewManagerModel, editDataAccessInterface, userRecipeFactory);

            return new UserRecipeView(openRecipeViewModel, openRecipeController,
                    collectRecipeViewModel, collectRecipeController,
                    editRecipeViewModel, editRecipeController);

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

    private static CollectRecipeController createCollectRecipeUseCase(ViewManagerModel viewManagerModel,
                                                                      CollectRecipeViewModel collectRecipeViewModel,
                                                                      AddRecipeToFolderViewModel addRecipeToFolderViewModel,
                                                                      CollectRecipeDataAccessInterface fileDataAccessObject) {
        CollectRecipeOutputBoundary collectRecipeOutputBoundary =
                new CollectRecipePresenter(viewManagerModel, collectRecipeViewModel, addRecipeToFolderViewModel);

        CollectRecipeInputBoundary collectRecipeInteractor = new CollectRecipeInteractor(
                fileDataAccessObject, collectRecipeOutputBoundary);
        return new CollectRecipeController(collectRecipeInteractor);
    }
    private static EditRecipeController createEditRecipeController(EditRecipeViewModel editRecipeViewModel,
                                                                   ViewManagerModel viewManagerModel,
                                                                   EditDataAccessInterface editDataAccessInterface,
                                                                   UserRecipeFactory userRecipeFactory) {
        EditOutputBoundary editOutputBoundary = new EditRecipePresenter(editRecipeViewModel, viewManagerModel);

        EditInputBoundary editInteractor = new EditInteractor(editDataAccessInterface, editOutputBoundary, userRecipeFactory);
        return new EditRecipeController(editInteractor);
    }
}

