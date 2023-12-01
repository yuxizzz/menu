package use_case.collect_recipe;

public interface CollectRecipeOutputBoundary {

    void prepareSuccessView(CollectRecipeOutputData collectRecipeOutputData);
    void prepareFailView(String message);
}
