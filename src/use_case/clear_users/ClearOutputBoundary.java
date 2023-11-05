package use_case.clear_users;


public interface ClearOutputBoundary {
    void prepareSuccessView(ClearOutputData message);

    void prepareFailView(String error);
}
