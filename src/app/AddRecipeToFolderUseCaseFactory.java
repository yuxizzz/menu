package app;

import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import use_case.add_recipe_to_folder.AddRecipeToFolderInputData;
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
}
