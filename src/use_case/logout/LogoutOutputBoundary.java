package use_case.logout;

public interface LogoutOutputBoundary {
    void prepareSuccessView();
    void prepareFailView(String error);
}
