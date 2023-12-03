package app;

import entity.recipe.UserRecipe;
import entity.recipe.UserRecipeFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderViewModel;
import interface_adapter.collect_recipe.CollectRecipeController;
import interface_adapter.collect_recipe.CollectRecipePresenter;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.upload_recipe.UploadRecipeController;
import interface_adapter.upload_recipe.UploadRecipePresenter;
import interface_adapter.upload_recipe.UploadRecipeViewModel;
import use_case.collect_recipe.CollectRecipeDataAccessInterface;
import use_case.collect_recipe.CollectRecipeInputBoundary;
import use_case.collect_recipe.CollectRecipeInteractor;
import use_case.collect_recipe.CollectRecipeOutputBoundary;
import use_case.upload_recipe.UploadDataAccessInterface;
import use_case.upload_recipe.UploadInputBoundary;
import use_case.upload_recipe.UploadInteractor;
import use_case.upload_recipe.UploadOutputBoundary;
import view.RecipeView;
import view.UploadView;

public class UploadRecipeUseCaseFactory {
    private UploadRecipeUseCaseFactory() {}
    public static UploadView create(
            ViewManagerModel viewManagerModel,
//            CollectRecipeViewModel collectRecipeViewModel,
//            AddRecipeToFolderViewModel addRecipeToFolderViewModel,
//            GetRecipeViewModel getRecipeViewModel,
            UploadRecipeViewModel uploadRecipeViewModel,
            UploadDataAccessInterface recipeDataAccessObject) {

        UploadRecipeController uploadRecipeController = createUploadRecipeUseCase(viewManagerModel,
                uploadRecipeViewModel, recipeDataAccessObject);
        return new UploadView(uploadRecipeViewModel, uploadRecipeController);
    }

    private static UploadRecipeController createUploadRecipeUseCase(ViewManagerModel viewManagerModel,
                                                                    UploadRecipeViewModel uploadRecipeViewModel,
                                                                    UploadDataAccessInterface recipeDataAccessObject) {
        UploadOutputBoundary uploadOutputBoundary =
                new UploadRecipePresenter(uploadRecipeViewModel, viewManagerModel);

        UserRecipeFactory userRecipeFactory = new UserRecipeFactory();

        UploadInputBoundary uploadRecipeInteractor = new UploadInteractor(recipeDataAccessObject,
                uploadOutputBoundary, userRecipeFactory);
        return new UploadRecipeController(uploadRecipeInteractor);
    }

}
