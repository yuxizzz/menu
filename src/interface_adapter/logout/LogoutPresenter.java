package interface_adapter.logout;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import use_case.logout.LogoutOutputBoundary;

public class LogoutPresenter implements LogoutOutputBoundary {
    private final LogoutViewModel logoutViewModel;
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;

    public LogoutPresenter(LogoutViewModel logoutViewModel, LoginViewModel loginViewModel, ViewManagerModel viewManagerModel) {
        this.logoutViewModel = logoutViewModel;
        this.loginViewModel = loginViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView() {
//        LogoutState logoutState = logoutViewModel.getState();
//        LoginState loginState = loginViewModel.getState();
//        this.loginViewModel.setState(loginState);

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LogoutState logoutState = logoutViewModel.getState();
        logoutState.setMessageError(error);
        logoutViewModel.firePropertyChanged();
    }
}
