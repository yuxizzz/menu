package app;

import entity.folder.CommonFolderFactory;
import entity.folder.FolderFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_folder.CreateFolderController;
import interface_adapter.create_folder.CreateFolderPresenter;
import interface_adapter.create_folder.CreateFolderViewModel;
import interface_adapter.default_opened_folder.DefaultOpenedFolderViewModel;
import interface_adapter.delete_folder.DeleteFolderController;
import interface_adapter.delete_folder.DeleteFolderPresenter;
import interface_adapter.delete_folder.DeleteFolderViewModel;
import interface_adapter.delete_userRecipe.DeleteRecipeState;
import interface_adapter.delete_userRecipe.DeleteRecipeViewModel;
import interface_adapter.logout.LogoutViewModel;
import interface_adapter.my_folder.MyFolderViewModel;
import interface_adapter.open_folder.OpenFolderController;
import interface_adapter.open_folder.OpenFolderPresenter;
import interface_adapter.open_folder.OpenFolderViewModel;
import interface_adapter.open_recipe.OpenRecipeViewModel;
import interface_adapter.opened_folder.OpenedFolderViewModel;
import interface_adapter.remove_recipe.RemoveViewModel;
import interface_adapter.upload_recipe.UploadRecipeViewModel;
import use_case.create_folder.CreateFolderDataAccessInterface;
import use_case.create_folder.CreateFolderInputBoundary;
import use_case.create_folder.CreateFolderInteractor;
import use_case.create_folder.CreateFolderOutputBoundary;
import use_case.delete_folder.DeleteFolderInputBoundary;
import use_case.delete_folder.DeleteFolderInteractor;
import use_case.delete_folder.DeleteFolderOutputBoundary;
import use_case.delete_folder.DeleteFolderUserDataAccessInterface;
import use_case.open_folder.OpenFolderDataAccessInterface;
import use_case.open_folder.OpenFolderInputBoundary;
import use_case.open_folder.OpenFolderInteractor;
import use_case.open_folder.OpenFolderOutputBoundary;
import view.MyFolderView;

/**
 * MyFolderView that contains MyFolder, OpenFolder, DeleteFolder, CreateFolder
 */
public class MyFolderUseCaseFactory {
    private MyFolderUseCaseFactory() {}

    public static MyFolderView create(
            ViewManagerModel viewManagerModel,
            MyFolderViewModel myFolderViewModel,
            LogoutViewModel logoutViewModel,
            OpenFolderViewModel openFolderViewModel,
            DeleteFolderViewModel deleteFolderViewModel,
            CreateFolderViewModel createFolderViewModel,
            OpenedFolderViewModel openedFolderViewModel,
            OpenFolderDataAccessInterface openFolderDataAccessInterface,
            DeleteFolderUserDataAccessInterface deleteFolderUserDataAccessInterface,
            CreateFolderDataAccessInterface createFolderDataAccessInterface,
            UploadRecipeViewModel uploadRecipeViewModel,
            DefaultOpenedFolderViewModel defaultOpenedFolderViewModel,
            OpenRecipeViewModel openRecipeViewModel,
            RemoveViewModel removeViewModel,
            DeleteRecipeViewModel deleteRecipeViewModel) {

            OpenFolderController openFolderController = createOpenFolderUseCase(viewManagerModel,
                    openFolderViewModel, openFolderDataAccessInterface, openedFolderViewModel,
                    uploadRecipeViewModel, defaultOpenedFolderViewModel, openRecipeViewModel,
                    removeViewModel, deleteRecipeViewModel);
            DeleteFolderController deleteFolderController = createDeleteFolderUseCase(viewManagerModel,
                    deleteFolderViewModel, deleteFolderUserDataAccessInterface);
            CreateFolderController createFolderController = createCreateFolderUseCase(viewManagerModel, createFolderViewModel,
                    createFolderDataAccessInterface);

            return new MyFolderView(myFolderViewModel,logoutViewModel, openFolderViewModel, openFolderController, deleteFolderViewModel, deleteFolderController,
                    createFolderViewModel, createFolderController);
    }

    private static CreateFolderController createCreateFolderUseCase(ViewManagerModel viewManagerModel,
                                                                    CreateFolderViewModel createFolderViewModel,
                                                                    CreateFolderDataAccessInterface createFolderDataAccessInterface) {
        CreateFolderOutputBoundary createFolderOutputBoundary = new CreateFolderPresenter(createFolderViewModel, viewManagerModel);
        FolderFactory folderFactory = new CommonFolderFactory();

        CreateFolderInputBoundary CreateFolderInteractor = new CreateFolderInteractor(createFolderDataAccessInterface,
                createFolderOutputBoundary, folderFactory);

        return new CreateFolderController(CreateFolderInteractor);

    }

    private static DeleteFolderController createDeleteFolderUseCase(ViewManagerModel viewManagerModel,
                                                                    DeleteFolderViewModel deleteFolderViewModel,
                                                                    DeleteFolderUserDataAccessInterface deleteFolderUserDataAccessInterface) {
        DeleteFolderOutputBoundary deleteFolderOutputBoundary = new DeleteFolderPresenter(viewManagerModel, deleteFolderViewModel);
        DeleteFolderInputBoundary deleteFolderInteractor = new DeleteFolderInteractor(deleteFolderUserDataAccessInterface, deleteFolderOutputBoundary);

        return new DeleteFolderController(deleteFolderInteractor);

    }

    private static OpenFolderController createOpenFolderUseCase(ViewManagerModel viewManagerModel,
                                                                OpenFolderViewModel openFolderViewModel,
                                                                OpenFolderDataAccessInterface openFolderDataAccessInterface,
                                                                OpenedFolderViewModel openedFolderViewModel,
                                                                UploadRecipeViewModel uploadRecipeViewModel,
                                                                DefaultOpenedFolderViewModel defaultOpenedFolderViewModel,
                                                                OpenRecipeViewModel openRecipeViewModel,
                                                                RemoveViewModel removeViewModel,
                                                                DeleteRecipeViewModel deleteRecipeViewModel) {
        OpenFolderOutputBoundary OpenFolderOutputBoundary = new OpenFolderPresenter(viewManagerModel,
                openFolderViewModel, openedFolderViewModel, uploadRecipeViewModel,
                defaultOpenedFolderViewModel,openRecipeViewModel,removeViewModel,
                deleteRecipeViewModel);
        OpenFolderInputBoundary openFolderInteractor = new OpenFolderInteractor(openFolderDataAccessInterface, OpenFolderOutputBoundary);

        return new OpenFolderController(openFolderInteractor);
    }
}
