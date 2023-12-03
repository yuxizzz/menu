package app;

import entity.recipe.CommonRecipeFactory;
import entity.recipe.RecipeFactory;
import entity.recipe.UserRecipeFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import interface_adapter.default_opened_folder.DefaultOpenedFolderViewModel;
import interface_adapter.delete_userRecipe.DeleteRecipeController;
import interface_adapter.delete_userRecipe.DeleteRecipePresenter;
import interface_adapter.delete_userRecipe.DeleteRecipeViewModel;
import interface_adapter.edit_recipe.EditRecipeController;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.open_recipe.OpenRecipeController;
import interface_adapter.open_recipe.OpenRecipePresenter;
import interface_adapter.open_recipe.OpenRecipeViewModel;
import interface_adapter.opened_folder.OpenedFolderViewModel;
import interface_adapter.remove_recipe.RemoveController;
import interface_adapter.remove_recipe.RemovePresenter;
import interface_adapter.remove_recipe.RemoveViewModel;
import interface_adapter.upload_recipe.UploadRecipeController;
import interface_adapter.upload_recipe.UploadRecipePresenter;
import interface_adapter.upload_recipe.UploadRecipeViewModel;
import use_case.delete_userRecipe.DeleteRecipeDataAccessInterface;
import use_case.delete_userRecipe.DeleteRecipeInputBoundary;
import use_case.delete_userRecipe.DeleteRecipeInteractor;
import use_case.delete_userRecipe.DeleteRecipeOutputBoundary;
import use_case.open_recipe.OpenRecipeDataAccessInterface;
import use_case.open_recipe.OpenRecipeInputBoundary;
import use_case.open_recipe.OpenRecipeInteractor;
import use_case.open_recipe.OpenRecipeOutputBoundary;
import use_case.remove_recipe.RemoveDataAccessInterface;
import use_case.remove_recipe.RemoveInputBoundary;
import use_case.remove_recipe.RemoveInteractor;
import use_case.remove_recipe.RemoveOutputBoundary;
import use_case.upload_recipe.UploadDataAccessInterface;
import use_case.upload_recipe.UploadInputBoundary;
import use_case.upload_recipe.UploadInteractor;
import use_case.upload_recipe.UploadOutputBoundary;
import view.DefaultOpenedFolderView;
import view.OpenedFolderView;

import javax.swing.*;
import java.io.IOException;

public class DefaultOpenedFolderUseCaseFactory {
    private DefaultOpenedFolderUseCaseFactory() {}

    public static DefaultOpenedFolderView create(
            ViewManagerModel viewManagerModel,
            OpenRecipeViewModel openRecipeViewModel,
            EditRecipeViewModel editRecipeViewModel,
            CollectRecipeViewModel collectRecipeViewModel,
            OpenRecipeDataAccessInterface openRecipeDataAccessObject,
            DefaultOpenedFolderViewModel defaultOpenedFolderViewModel,
            DeleteRecipeViewModel deleteRecipeViewModel,
            UploadRecipeViewModel uploadRecipeViewModel,
            UploadDataAccessInterface uploadDataAccessObject,
            DeleteRecipeDataAccessInterface deleteDataAccessObject,
            GetRecipeViewModel getRecipeViewModel
            ) {

        try {
            UploadRecipeController uploadRecipeController = createUploadUseCase(viewManagerModel,
                    uploadRecipeViewModel, uploadDataAccessObject);
            OpenRecipeController openRecipeController = createOpenRecipeUseCase(viewManagerModel,
                    openRecipeViewModel,editRecipeViewModel, getRecipeViewModel, collectRecipeViewModel,openRecipeDataAccessObject);

            DeleteRecipeController deleteRecipeController = createDeleteUseCase(viewManagerModel,
                    deleteDataAccessObject, deleteRecipeViewModel,
                    defaultOpenedFolderViewModel);

            return new DefaultOpenedFolderView(defaultOpenedFolderViewModel,
                    openRecipeViewModel, openRecipeController, deleteRecipeViewModel,
                    deleteRecipeController, uploadRecipeViewModel,
                    uploadRecipeController);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }
    private static UploadRecipeController createUploadUseCase(ViewManagerModel viewManagerModel,
                                                              UploadRecipeViewModel uploadRecipeViewModel,
                                                              UploadDataAccessInterface uploadDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        UploadOutputBoundary uploadOutputBoundary = new UploadRecipePresenter(uploadRecipeViewModel,
                viewManagerModel);

        UserRecipeFactory userRecipeFactory = new UserRecipeFactory();

        UploadInputBoundary uploadInteractor = new UploadInteractor(
                uploadDataAccessObject, uploadOutputBoundary, userRecipeFactory);
        return new UploadRecipeController(uploadInteractor);
    }

    private static DeleteRecipeController createDeleteUseCase(ViewManagerModel viewManagerModel,
                                                              DeleteRecipeDataAccessInterface deleteDataAccessObject,
                                                              DeleteRecipeViewModel deleteRecipeViewModel,
                                                              DefaultOpenedFolderViewModel defaultOpenedFolderViewModel) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        DeleteRecipeOutputBoundary  deleteOutputBoundary = new DeleteRecipePresenter(viewManagerModel, deleteRecipeViewModel,
                defaultOpenedFolderViewModel);

//        SearchResult searchResult = new SearchResult();
//        userFactory = new CommonUserFactory();

        DeleteRecipeInputBoundary deleteInteractor = new DeleteRecipeInteractor(
                deleteDataAccessObject, deleteOutputBoundary);
        return new DeleteRecipeController(deleteInteractor);
    }


    private static OpenRecipeController createOpenRecipeUseCase(
            ViewManagerModel viewManagerModel, OpenRecipeViewModel openRecipeViewModel,
            EditRecipeViewModel editRecipeViewModel,
            GetRecipeViewModel getRecipeViewModel,
            CollectRecipeViewModel collectRecipeViewModel,
            OpenRecipeDataAccessInterface openRecipeDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        OpenRecipeOutputBoundary openRecipeOutputBoundary = new OpenRecipePresenter(openRecipeViewModel,
                getRecipeViewModel, editRecipeViewModel, collectRecipeViewModel, viewManagerModel);

        RecipeFactory recipeFactory = new CommonRecipeFactory();

        OpenRecipeInputBoundary openRecipeController = new OpenRecipeInteractor(
                openRecipeDataAccessObject, openRecipeOutputBoundary);

        return new OpenRecipeController(openRecipeController);
    }
}
