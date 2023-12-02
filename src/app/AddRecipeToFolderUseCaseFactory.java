package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderController;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderPresenter;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderViewModel;
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
            AddRecipeToFolderDataAccessInterface folderDataAccessObject) {

        AddRecipeToFolderController addRecipeToFolderController = createAddRecipeToFolderUseCase(viewManagerModel, addRecipeToFolderViewModel,
                folderDataAccessObject);
        return new FolderOptionsView(addRecipeToFolderViewModel, addRecipeToFolderController);

    }

    private static AddRecipeToFolderController createAddRecipeToFolderUseCase(ViewManagerModel viewManagerModel,
                                                                              AddRecipeToFolderViewModel addRecipeToFolderViewModel,
                                                                              AddRecipeToFolderDataAccessInterface folderDataAccessObject) {
        AddRecipeToFolderOutputBoundary addRecipeToFolderOutputBoundary
                = new AddRecipeToFolderPresenter(viewManagerModel, addRecipeToFolderViewModel);
        AddRecipeToFolderInputBoundary addRecipeToFolderInteractor
                = new AddRecipeToFolderInteractor(folderDataAccessObject, addRecipeToFolderOutputBoundary);
        return new AddRecipeToFolderController(addRecipeToFolderInteractor);
    }
}
