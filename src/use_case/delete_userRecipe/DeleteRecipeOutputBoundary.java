package use_case.delete_userRecipe;

public interface DeleteRecipeOutputBoundary {
    void prepareSuccessView(DeleteRecipeOutputData deleteRecipeOutputData);

    void prepareFailView(String error);
}
