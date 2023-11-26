package interface_adapter.delete_userRecipe;

import use_case.delete_userRecipe.DeleteRecipeInputBoundary;

public class DeleteRecipeController {
    final DeleteRecipeInputBoundary deleteUserRecipeInteractor;

    public DeleteRecipeController(DeleteRecipeInputBoundary deleteUserRecipeInteractor) {
        this.deleteUserRecipeInteractor = deleteUserRecipeInteractor;
    }

    public void execute(){

    }
}
