package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderController;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderPresenter;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderViewModel;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import use_case.add_recipe_to_folder.AddRecipeToFolderDataAccessInterface;
import use_case.add_recipe_to_folder.AddRecipeToFolderInputBoundary;
import use_case.add_recipe_to_folder.AddRecipeToFolderInteractor;
import use_case.add_recipe_to_folder.AddRecipeToFolderOutputBoundary;
import view.FolderOptionsView;

/**
 * the usecase factor for AddRecipeToFolder UseCase and FolderOptions View
 */
public class AddRecipeToFolderUseCaseFactory {
    private AddRecipeToFolderUseCaseFactory() {}
    public static FolderOptionsView create(
            ViewManagerModel viewManagerModel,
            AddRecipeToFolderViewModel addRecipeToFolderViewModel,
            CollectRecipeViewModel collectRecipeViewModel,
            AddRecipeToFolderDataAccessInterface folderDataAccessObject) {

        AddRecipeToFolderController addRecipeToFolderController = createAddRecipeToFolderUseCase(viewManagerModel, addRecipeToFolderViewModel, collectRecipeViewModel,
                folderDataAccessObject);
        return new FolderOptionsView(addRecipeToFolderViewModel, addRecipeToFolderController);

    }

    private static AddRecipeToFolderController createAddRecipeToFolderUseCase(ViewManagerModel viewManagerModel,
                                                                              AddRecipeToFolderViewModel addRecipeToFolderViewModel,
                                                                              CollectRecipeViewModel collectRecipeViewModel,
                                                                              AddRecipeToFolderDataAccessInterface folderDataAccessObject) {
        AddRecipeToFolderOutputBoundary addRecipeToFolderOutputBoundary
                = new AddRecipeToFolderPresenter(viewManagerModel, addRecipeToFolderViewModel, collectRecipeViewModel);
        AddRecipeToFolderInputBoundary addRecipeToFolderInteractor
                = new AddRecipeToFolderInteractor(folderDataAccessObject, addRecipeToFolderOutputBoundary);
        return new AddRecipeToFolderController(addRecipeToFolderInteractor);
    }
}
