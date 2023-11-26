package use_case.logout;

import use_case.logout.LogoutOutputData;

public interface LogoutOutputBoundary {

    void prepareSuccessView();
    void prepareFailView(String error);
}
