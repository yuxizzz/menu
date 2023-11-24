package use_case.logout;

import use_case.logout.LogoutOutputData;

public interface LogoutOutputBoundary {
    void prepareSuccessView(LogoutOutputData user);

    //void prepareFailView(String error);
}
