package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderViewModel;
import interface_adapter.collect_recipe.CollectRecipeController;
import interface_adapter.collect_recipe.CollectRecipePresenter;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.upload_recipe.UploadRecipeController;
import interface_adapter.upload_recipe.UploadRecipeViewModel;
import use_case.collect_recipe.CollectRecipeDataAccessInterface;
import use_case.collect_recipe.CollectRecipeInputBoundary;
import use_case.collect_recipe.CollectRecipeInteractor;
import use_case.collect_recipe.CollectRecipeOutputBoundary;
import view.RecipeView;

public class UploadRecipeUseCaseFactory {
    private UploadRecipeUseCaseFactory() {}
//    public static UploadRecipeView create(
//            ViewManagerModel viewManagerModel,
//            CollectRecipeViewModel collectRecipeViewModel,
//            AddRecipeToFolderViewModel addRecipeToFolderViewModel,
//            GetRecipeViewModel getRecipeViewModel,
//            CollectRecipeDataAccessInterface fileDataAccessObject) {
//
//        UploadRecipeController uploadRecipeController = createCollectRecipeUseCase(viewManagerModel, collectRecipeViewModel,
//                addRecipeToFolderViewModel, fileDataAccessObject);
//        return new UploadRecipeView(uploadRecipeViewModel, uploadRecipeController);
//    }
//
//    private static CollectRecipeController createCollectRecipeUseCase(ViewManagerModel viewManagerModel,
//                                                                      CollectRecipeViewModel collectRecipeViewModel,
//                                                                      AddRecipeToFolderViewModel addRecipeToFolderViewModel,
//                                                                      CollectRecipeDataAccessInterface fileDataAccessObject) {
//        CollectRecipeOutputBoundary collectRecipeOutputBoundary =
//                new CollectRecipePresenter(viewManagerModel, collectRecipeViewModel, addRecipeToFolderViewModel);
//
//        CollectRecipeInputBoundary collectRecipeInteractor = new CollectRecipeInteractor(
//                fileDataAccessObject, collectRecipeOutputBoundary);
//        return new CollectRecipeController(collectRecipeInteractor);
//    }

}
