package interface_adapter.delete_userRecipe;

import use_case.delete_userRecipe.DeleteRecipeInputBoundary;
import use_case.delete_userRecipe.DeleteRecipeInputData;

public class DeleteRecipeController {
    final DeleteRecipeInputBoundary deleteUserRecipeInteractor;






    public DeleteRecipeController(DeleteRecipeInputBoundary deleteUserRecipeInteractor) {
        this.deleteUserRecipeInteractor = deleteUserRecipeInteractor;



    }

    public void execute(Integer recipeID, String username){
        DeleteRecipeInputData deleteRecipeInputData = new DeleteRecipeInputData(recipeID, username);
        deleteUserRecipeInteractor.execute(deleteRecipeInputData);


    }
}
