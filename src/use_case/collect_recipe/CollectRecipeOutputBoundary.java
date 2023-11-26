package use_case.collect_recipe;

public interface CollectRecipeOutputBoundary {
    void prepareFailView(String error);

    void prepareSuccessView(CollectRecipeOutputData collectRecipeOutputData);
}
