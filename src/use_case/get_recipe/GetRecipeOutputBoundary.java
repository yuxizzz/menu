package use_case.get_recipe;

public interface GetRecipeOutputBoundary {
    void prepareSuccessView(GetRecipeOutputData recipe);
    void prepareFailView(String error);
}
