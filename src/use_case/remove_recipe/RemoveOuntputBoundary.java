package use_case.remove_recipe;

public interface RemoveOuntputBoundary {
    void prepareSuccessView(RemoveOutputData message);

    void prepareFailView(String error);
}
