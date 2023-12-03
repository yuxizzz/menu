package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.my_folder.MyFolderState;
import interface_adapter.my_folder.MyFolderViewModel;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import interface_adapter.login.LoginViewModel;
import view.MyFolderView;

public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private final SearchViewModel searchViewModel;
    private ViewManagerModel viewManagerModel;
    private MyFolderViewModel myFolderViewModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          LoggedInViewModel loggedInViewModel,
                          LoginViewModel loginViewModel,
                          SearchViewModel searchViewModel,
                          MyFolderViewModel myFolderViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.loginViewModel = loginViewModel;
        this.searchViewModel = searchViewModel;
        this.myFolderViewModel = myFolderViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the logged in view.
        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setUsername(response.getUsername());
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();

        SearchState searchState = searchViewModel.getState();
        searchState.setUsername(response.getUsername());
        this.searchViewModel.setState(searchState);
//        this.searchViewModel.firePropertyChanged();

        MyFolderState myFolderState = myFolderViewModel.getState();
        myFolderState.setUsername(response.getUsername());
        this.myFolderViewModel.setState(myFolderState);
//        this.myFolderViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
}
