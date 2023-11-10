package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import interface_adapter.login.LoginViewModel;

public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final SearchViewModel searchViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          SearchViewModel searchViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.searchViewModel = searchViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the search view.
        SearchState searchState = searchViewModel.getState();
        searchState.setUserId(response.getUsername());
        this.searchViewModel.setState(searchState);
        this.searchViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(searchViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
}
