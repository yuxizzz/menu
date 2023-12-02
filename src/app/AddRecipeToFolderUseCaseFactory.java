package app;


import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderController;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderPresenter;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import use_case.add_recipe_to_folder.AddRecipeToFolderDataAccessInterface;
import use_case.add_recipe_to_folder.AddRecipeToFolderInputBoundary;
import use_case.add_recipe_to_folder.AddRecipeToFolderInteractor;
import use_case.add_recipe_to_folder.AddRecipeToFolderOutputBoundary;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginUserDataAccessInterface;
import view.FolderOptionsView;
import view.LoginView;

import javax.swing.*;
import java.io.IOException;

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