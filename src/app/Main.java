package app;

import data_access.FileFolderDataAccessObject;
import data_access.FileRecipeDataAccessObject;
import data_access.FileUserDataAccessObject;
import entity.folder.CommonFolderFactory;
import entity.folder.FolderFactory;
import entity.recipe.CommonRecipeFactory;
import entity.user.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.clear_users.ClearViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutViewModel;
import interface_adapter.my_folder.MyFolderController;
import interface_adapter.my_folder.MyFolderViewModel;
import interface_adapter.opened_folder.OpenedFolderViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchViewModel;
import interface_adapter.searched.SearchedViewModel;
import interface_adapter.signup.SignupViewModel;
import use_case.clear_users.ClearUserDataAccessInterface;
import use_case.logout.LogoutDataAccessInterface;
import use_case.my_folder.MyFolderDataAccessInterface;
import use_case.search.SearchUserDataAccessInterface;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Login Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        LoginViewModel loginViewModel = new LoginViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();

        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel,
                signupViewModel,userDataAccessObject);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel,
        userDataAccessObject);
        views.add(loginView, loginView.viewName);

        SearchViewModel searchViewModel = new SearchViewModel();
        SearchUserDataAccessInterface searchUserDataAccessObject = (SearchUserDataAccessInterface) userDataAccessObject;

        SearchedViewModel searchedViewModel = new SearchedViewModel();
        MyFolderViewModel myFolderViewModel = new MyFolderViewModel();
        OpenedFolderViewModel openedFolderViewModel = new OpenedFolderViewModel();
        LogoutViewModel logoutViewModel = new LogoutViewModel();


        // TODO CSV PATH
        FileRecipeDataAccessObject recipeDataAccessObject;
        try {
            recipeDataAccessObject = new FileRecipeDataAccessObject("./users.csv",
                    new CommonRecipeFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // TODO CSV PATH
        FileFolderDataAccessObject myFolderDataAccessObject;
        try {
            myFolderDataAccessObject = new FileFolderDataAccessObject("./users.csv",
                    new CommonFolderFactory(), recipeDataAccessObject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // TODO CSV PATH
        FileUserDataAccessObject logoutDataAccessObject;
        try {
            logoutDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        LoggedInView loggedInView = LoggedinUseCaseFactory.create(viewManagerModel, loggedInViewModel,
                searchedViewModel, searchViewModel, searchUserDataAccessObject, openedFolderViewModel,
                myFolderViewModel, (MyFolderDataAccessInterface) myFolderDataAccessObject, loginViewModel, logoutViewModel,
                (LogoutDataAccessInterface) logoutDataAccessObject);
        views.add(loggedInView, loggedInView.viewName);

//        MyFolderView myFolderView = MY


        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}