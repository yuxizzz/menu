package use_case.logout;

public class LogoutInteractor implements LogoutInputBoundary{
    final LogoutDataAccessInterface logoutDataAccessInterface;
    final LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutDataAccessInterface logoutDataAccessInterface, LogoutOutputBoundary logoutPresenter) {
        this.logoutDataAccessInterface = logoutDataAccessInterface;
        this.logoutPresenter = logoutPresenter;
    }

    @Override
    public void execute(LogoutInputData logoutInputData) {
        LogoutOutputData logoutOutputData = new LogoutOutputData();
        logoutPresenter.prepareSuccessView(logoutOutputData);
    }
}
