package app;

import entity.folder.CommonFolderFactory;
import entity.folder.FolderFactory;
import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_folder.CreateFolderController;
import interface_adapter.create_folder.CreateFolderPresenter;
import interface_adapter.create_folder.CreateFolderViewModel;
import interface_adapter.delete_folder.DeleteFolderController;
import interface_adapter.delete_folder.DeleteFolderPresenter;
import interface_adapter.delete_folder.DeleteFolderViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.logout.LogoutViewModel;
import interface_adapter.my_folder.MyFolderController;
import interface_adapter.my_folder.MyFolderPresenter;
import interface_adapter.my_folder.MyFolderViewModel;
import interface_adapter.open_folder.OpenFolderController;
import interface_adapter.open_folder.OpenFolderPresenter;
import interface_adapter.open_folder.OpenFolderViewModel;
import interface_adapter.open_recipe.OpenRecipeViewModel;
import interface_adapter.opened_folder.OpenedFolderViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchViewModel;
import interface_adapter.searched.SearchedViewModel;
import use_case.create_folder.CreateFolderDataAccessInterface;
import use_case.create_folder.CreateFolderInputBoundary;
import use_case.create_folder.CreateFolderInteractor;
import use_case.create_folder.CreateFolderOutputBoundary;
import use_case.delete_folder.DeleteFolderInputBoundary;
import use_case.delete_folder.DeleteFolderInteractor;
import use_case.delete_folder.DeleteFolderOutputBoundary;
import use_case.delete_folder.DeleteFolderUserDataAccessInterface;
import use_case.logout.LogoutDataAccessInterface;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.my_folder.MyFolderDataAccessInterface;
import use_case.my_folder.MyFolderInputBoundary;
import use_case.my_folder.MyFolderInteractor;
import use_case.my_folder.MyFolderOutputBoundary;
import use_case.open_folder.OpenFolderDataAccessInterface;
import use_case.open_folder.OpenFolderInputBoundary;
import use_case.open_folder.OpenFolderInteractor;
import use_case.open_folder.OpenFolderOutputBoundary;
import use_case.search.SearchUserDataAccessInterface;
import view.MyFolderView;

import javax.swing.*;
import java.io.IOException;

/**
 * Search, OpenedFolder
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
            OpenRecipeViewModel openRecipeViewModel,
            OpenFolderDataAccessInterface openFolderDataAccessInterface,
            DeleteFolderUserDataAccessInterface deleteFolderUserDataAccessInterface,
            CreateFolderDataAccessInterface createFolderDataAccessInterface) {

            OpenFolderController openFolderController = createOpenFolderUseCase(viewManagerModel,
                    openFolderViewModel, openFolderDataAccessInterface, openRecipeViewModel);
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
                                                                OpenRecipeViewModel openRecipeViewModel) {
        OpenFolderOutputBoundary OpenFolderOutputBoundary = new OpenFolderPresenter(viewManagerModel,
                openFolderViewModel, openRecipeViewModel);
        OpenFolderInputBoundary openFolderInteractor = new OpenFolderInteractor(openFolderDataAccessInterface, OpenFolderOutputBoundary);

        return new OpenFolderController(openFolderInteractor);

    }
}
