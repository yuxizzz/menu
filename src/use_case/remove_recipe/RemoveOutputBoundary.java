package use_case.remove_recipe;

public interface RemoveOutputBoundary {
    void prepareSuccessView(RemoveOutputData message);

    void prepareFailView(String error);
}
