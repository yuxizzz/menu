package app;

import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.logout.LogoutViewModel;
import interface_adapter.my_folder.MyFolderController;
import interface_adapter.my_folder.MyFolderPresenter;
import interface_adapter.my_folder.MyFolderViewModel;
import interface_adapter.opened_folder.OpenedFolderViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchPresenter;
import interface_adapter.search.SearchViewModel;
import interface_adapter.searched.SearchedViewModel;
import use_case.logout.LogoutDataAccessInterface;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.my_folder.MyFolderDataAccessInterface;
import use_case.my_folder.MyFolderInputBoundary;
import use_case.my_folder.MyFolderInteractor;
import use_case.my_folder.MyFolderOutputBoundary;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchUserDataAccessInterface;
import view.LoggedInView;
import view.MyFolderView;

import javax.swing.*;
import java.io.IOException;

public class MyFolderUseCaseFactory {
    private MyFolderUseCaseFactory() {}

    public static MyFolderView create(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            SearchedViewModel searchedViewModel,
            SearchViewModel searchViewModel, SearchUserDataAccessInterface searchUserDataAccessObject,
            OpenedFolderViewModel openedFolderViewModel,
            MyFolderViewModel myFolderViewModel, MyFolderDataAccessInterface myFolderDataAccessObject,
            LoginViewModel loginViewModel,
            LogoutViewModel logoutViewModel, LogoutDataAccessInterface logoutDataAccessObject) {

        try {
            SearchController searchController = createSearchUseCase(viewManagerModel,
                    searchedViewModel, searchViewModel,
                    searchUserDataAccessObject);
            MyFolderController myFolderController = createMyFolderUseCase(viewManagerModel,
                    openedFolderViewModel, myFolderViewModel,
                    myFolderDataAccessObject);
            LogoutController logoutController = createLogoutUseCase(viewManagerModel, loginViewModel,
                    logoutViewModel, logoutDataAccessObject);
//            return new MyFolderView(loggedInViewModel,searchViewModel,searchController,
//                    myFolderViewModel, myFolderController, logoutViewModel, logoutController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SearchController createSearchUseCase(
            ViewManagerModel viewManagerModel,
            SearchedViewModel searchedViewModel,
            SearchViewModel searchViewModel,
            SearchUserDataAccessInterface searchUserDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
//        SearchOutputBoundary searchOutputBoundary = new SearchPresenter(viewManagerModel,
//                searchViewModel,searchedViewModel);

//        SearchResult searchResult = new SearchResult();
//        userFactory = new CommonUserFactory();

//        SearchInputBoundary searchInteractor = new SearchInteractor(
//                searchUserDataAccessObject, searchOutputBoundary);

//        return new SearchController(searchInteractor);
        return null;
    }
    private static MyFolderController createMyFolderUseCase(
            ViewManagerModel viewManagerModel, OpenedFolderViewModel openedFolderViewModel,
            MyFolderViewModel myFolderViewModel, MyFolderDataAccessInterface myFolderDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        MyFolderOutputBoundary myFolderOutputBoundary = new MyFolderPresenter(viewManagerModel,
                myFolderViewModel, openedFolderViewModel);

        UserFactory userFactory = new CommonUserFactory();

        MyFolderInputBoundary myFolderInteractor = (MyFolderInputBoundary) new MyFolderInteractor(
                myFolderDataAccessObject, myFolderOutputBoundary);

        return new MyFolderController(myFolderInteractor);
    }
    private static LogoutController createLogoutUseCase(
            ViewManagerModel viewManagerModel, LoginViewModel loginViewModel,
            LogoutViewModel logoutViewModel, LogoutDataAccessInterface logoutDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(logoutViewModel,
                loginViewModel, viewManagerModel);

        UserFactory userFactory = new CommonUserFactory();

        LogoutInputBoundary logoutInteractor = new LogoutInteractor(
                logoutDataAccessObject, logoutOutputBoundary);

        return new LogoutController(logoutInteractor);
    }
}
