package app;

import data_access.FileFolderDataAccessObject;
import data_access.FileRecipeDataAccessObject;
import data_access.FileUserDataAccessObject;
import data_access.SearchResultsDataAccessObject;
import entity.folder.CommonFolderFactory;
import entity.folder.FolderFactory;
import entity.recipe.CommonRecipeFactory;
import entity.recipe.UserRecipeFactory;
import entity.search_results.CommonSearchResultFactory;
import entity.user.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderViewModel;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import interface_adapter.create_folder.CreateFolderViewModel;
import interface_adapter.default_opened_folder.DefaultOpenedFolderViewModel;
import interface_adapter.delete_folder.DeleteFolderViewModel;
import interface_adapter.delete_userRecipe.DeleteRecipeViewModel;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutViewModel;
import interface_adapter.my_folder.MyFolderViewModel;
import interface_adapter.open_folder.OpenFolderViewModel;
import interface_adapter.open_recipe.OpenRecipeViewModel;
import interface_adapter.opened_folder.OpenedFolderViewModel;
import interface_adapter.remove_recipe.RemoveViewModel;
import interface_adapter.search.SearchViewModel;
import interface_adapter.searched.SearchedViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.upload_recipe.UploadRecipeViewModel;
import use_case.collect_recipe.CollectRecipeDataAccessInterface;
import use_case.create_folder.CreateFolderDataAccessInterface;
import use_case.delete_folder.DeleteFolderUserDataAccessInterface;
import use_case.delete_userRecipe.DeleteRecipeDataAccessInterface;
import use_case.edit_recipe.EditDataAccessInterface;
import use_case.get_recipe.GetRecipeDataAccessInterface;
import use_case.logout.LogoutDataAccessInterface;
import use_case.my_folder.MyFolderDataAccessInterface;
import use_case.open_folder.OpenFolderDataAccessInterface;
import use_case.open_recipe.OpenRecipeDataAccessInterface;
import use_case.remove_recipe.RemoveDataAccessInterface;
import use_case.search.SearchUserDataAccessInterface;
import use_case.upload_recipe.UploadDataAccessInterface;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
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

        FileRecipeDataAccessObject recipeDataAccessObject;
        try {
            recipeDataAccessObject = new FileRecipeDataAccessObject("./recipes.csv",
                    new CommonRecipeFactory(), userDataAccessObject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileFolderDataAccessObject folderDataAccessObject;
        try {
            folderDataAccessObject = new FileFolderDataAccessObject("./folders.csv",
                    new CommonFolderFactory(), recipeDataAccessObject, userDataAccessObject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel,
                signupViewModel,userDataAccessObject);
        views.add(signupView, signupView.viewName);

        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        SearchResultsDataAccessObject searchResultsDataAccessObject;
        try {
            searchResultsDataAccessObject = new SearchResultsDataAccessObject("./search.csv",
                    new CommonSearchResultFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




        MyFolderViewModel myFolderViewModel = new MyFolderViewModel();
        SearchViewModel searchViewModel = new SearchViewModel();
        SearchUserDataAccessInterface searchUserDataAccessObject = searchResultsDataAccessObject;
        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, searchViewModel, loginViewModel, loggedInViewModel,
        userDataAccessObject, myFolderViewModel);
        views.add(loginView, loginView.viewName);

        SearchedViewModel searchedViewModel = new SearchedViewModel();

        OpenedFolderViewModel openedFolderViewModel = new OpenedFolderViewModel();
        LogoutViewModel logoutViewModel = new LogoutViewModel();


        GetRecipeViewModel getRecipeViewModel = new GetRecipeViewModel();

        OpenFolderViewModel openFolderViewModel = new OpenFolderViewModel();
        CreateFolderViewModel createFolderViewModel = new CreateFolderViewModel();
        DeleteFolderViewModel deleteFolderViewModel = new DeleteFolderViewModel();
        MyFolderDataAccessInterface myFolderDataAccessObject = userDataAccessObject;
        LogoutDataAccessInterface logoutDataAccessObject = userDataAccessObject;

        LoggedInView loggedInView = LoggedinUseCaseFactory.create(viewManagerModel,
                loggedInViewModel,
                searchedViewModel,
                getRecipeViewModel,
                searchViewModel, searchUserDataAccessObject,
                openFolderViewModel,
                createFolderViewModel, deleteFolderViewModel,
                myFolderViewModel, myFolderDataAccessObject,
                loginViewModel, logoutViewModel, logoutDataAccessObject);
        views.add(loggedInView, loggedInView.viewName);


        OpenFolderDataAccessInterface openFolderDataAccessObject = folderDataAccessObject;


        UploadRecipeViewModel uploadRecipeViewModel = new UploadRecipeViewModel();
        DefaultOpenedFolderViewModel defaultOpenedFolderViewModel = new DefaultOpenedFolderViewModel("My Recipes");
        OpenRecipeViewModel openRecipeViewModel = new OpenRecipeViewModel();
        RemoveViewModel removeViewModel = new RemoveViewModel();

        DeleteRecipeViewModel deleteRecipeViewModel = new DeleteRecipeViewModel();
        DeleteFolderUserDataAccessInterface deleteFolderUserDataAccessObject = userDataAccessObject;
        CreateFolderDataAccessInterface createFolderDataAccessObject = userDataAccessObject;

        MyFolderView myFolderView = MyFolderUseCaseFactory.create(viewManagerModel,
                myFolderViewModel,
                logoutViewModel,
                openFolderViewModel,
                deleteFolderViewModel,
                createFolderViewModel,
                openedFolderViewModel,
                openFolderDataAccessObject,
                deleteFolderUserDataAccessObject,
                createFolderDataAccessObject,
                uploadRecipeViewModel,
                defaultOpenedFolderViewModel,
                openRecipeViewModel,
                removeViewModel,
                deleteRecipeViewModel
//                myFolderDataAccessObject
        );
        views.add(myFolderView, myFolderView.viewName);

        SearchView searchview = SearchUseCaseFactory.create(viewManagerModel,
                searchViewModel,
                getRecipeViewModel,
                searchedViewModel,
                searchUserDataAccessObject);
        views.add(searchview, searchview.viewName);

        CollectRecipeViewModel collectRecipeViewModel = new CollectRecipeViewModel();
        GetRecipeDataAccessInterface getRecipeDataAccessObject = recipeDataAccessObject;
        SearchedView searchedView = SearchedUseCaseFactory.create(viewManagerModel,
                getRecipeViewModel,
                searchedViewModel,
                getRecipeDataAccessObject,
                collectRecipeViewModel);
        views.add(searchedView, searchedView.viewName);

        FolderFactory folderFactory = new CommonFolderFactory();

        CreateFolderView createFolderView = CreateFolderUseCaseFactory.create(viewManagerModel,
                createFolderViewModel,
                myFolderViewModel,
                createFolderDataAccessObject,
                folderFactory);
        views.add(createFolderView, createFolderView.viewName);

        EditRecipeViewModel editRecipeViewModel = new EditRecipeViewModel();

        OpenRecipeDataAccessInterface openRecipeDataAccessObject = recipeDataAccessObject;
        UploadDataAccessInterface uploadDataAccessObject = recipeDataAccessObject;
        DeleteRecipeDataAccessInterface deleteDataAccessObject = folderDataAccessObject;

        DefaultOpenedFolderView defaultOpenedFolderView = DefaultOpenedFolderUseCaseFactory.create(viewManagerModel,
                openRecipeViewModel, editRecipeViewModel,
                collectRecipeViewModel, openRecipeDataAccessObject,
                defaultOpenedFolderViewModel, deleteRecipeViewModel,
                uploadRecipeViewModel, uploadDataAccessObject,
                deleteDataAccessObject, getRecipeViewModel);
        views.add(defaultOpenedFolderView, defaultOpenedFolderView.viewName);

        DeleteRecipeDataAccessInterface deleteRecipeDataAccessObject = folderDataAccessObject;

        DeleteUserRecipeView deleteUserRecipeView = DeleteRecipeUseCaseFactory.create(viewManagerModel,
                deleteRecipeViewModel, deleteRecipeDataAccessObject,
                defaultOpenedFolderViewModel);
        views.add(deleteUserRecipeView, deleteUserRecipeView.viewName);

        EditDataAccessInterface editDataAccessObject = recipeDataAccessObject;
        EditView editView = EditRecipeUseCaseFactory.create(viewManagerModel,
                editRecipeViewModel, editDataAccessObject,
                defaultOpenedFolderViewModel);
        views.add(editView, editView.viewName);

        AddRecipeToFolderViewModel addRecipeToFolderViewModel = new AddRecipeToFolderViewModel();
        FolderOptionsView folderOptionsView = AddRecipeToFolderUseCaseFactory.create(viewManagerModel,
                addRecipeToFolderViewModel,
                collectRecipeViewModel, folderDataAccessObject);
        views.add(folderOptionsView,folderOptionsView.viewName);

        CollectRecipeDataAccessInterface collectRecipeDataAccessObject = folderDataAccessObject;
//        RecipeView recipeView = GetRecipeUseCaseFactory.create(viewManagerModel,
//                collectRecipeViewModel,
//                addRecipeToFolderViewModel,
//                getRecipeViewModel, collectRecipeDataAccessObject);
//        views.add(recipeView, recipeView.viewName);

        RemoveViewModel removeRecipeViewModel = new RemoveViewModel();
        RemoveDataAccessInterface removeDataAccessObject = folderDataAccessObject;
        RemoveView removeView = RemoveRecipeUseCaseFactory.create(
                viewManagerModel, removeRecipeViewModel,
                removeDataAccessObject, openedFolderViewModel);
        views.add(removeView,removeView.viewName);

        SearchView searchView = SearchUseCaseFactory.create(viewManagerModel,
                searchViewModel, getRecipeViewModel,
                searchedViewModel, searchUserDataAccessObject);
        views.add(searchView,searchView.viewName);

        UploadView uploadView = UploadRecipeUseCaseFactory.create(viewManagerModel,
                uploadRecipeViewModel, recipeDataAccessObject);
        views.add(uploadView,uploadView.viewName);

        UserRecipeFactory userRecipeFactory = new UserRecipeFactory();

//        UserRecipeView userRecipeView = OpenUserRecipeUseCaseFactory.create(viewManagerModel,
//                openRecipeViewModel,
//                editRecipeViewModel,
//                collectRecipeViewModel, addRecipeToFolderViewModel,
//                collectRecipeDataAccessObject,
//                openRecipeDataAccessObject,
//                defaultOpenedFolderViewModel,
//                getRecipeViewModel,
//                editDataAccessObject,
//                userRecipeFactory);
//        views.add(userRecipeView, userRecipeView.viewName);



        application.pack();
        application.setVisible(true);
    }
}