package use_case.open_recipe;

public interface OpenRecipeOutputBoundary {
    void prepareSuccessView(OpenRecipeOutputData openRecipeOutputData);
    void prepareFailView(String error);
}
