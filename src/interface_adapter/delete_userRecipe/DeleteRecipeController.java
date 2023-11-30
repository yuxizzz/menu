package interface_adapter.delete_userRecipe;

import use_case.delete_userRecipe.DeleteRecipeInputBoundary;
import use_case.delete_userRecipe.DeleteRecipeInputData;
import use_case.remove_recipe.RemoveInputData;

public class DeleteRecipeController {
    final DeleteRecipeInputBoundary deleteUserRecipeInteractor;






    public DeleteRecipeController(DeleteRecipeInputBoundary deleteUserRecipeInteractor) {
        this.deleteUserRecipeInteractor = deleteUserRecipeInteractor;



    }

    public void execute(Integer recipeID){
        DeleteRecipeInputData deleteRecipeInputData = new DeleteRecipeInputData(recipeID);
        deleteUserRecipeInteractor.execute(deleteRecipeInputData);


    }
}
