package use_case.delete_userRecipe;

import entity.recipe.CommonRecipe;
import entity.recipe.UserRecipe;
import use_case.clear_users.ClearInputData;
import use_case.clear_users.ClearOutputData;
import use_case.remove_recipe.RemoveOutputData;

public class DeleteRecipeInteractor implements DeleteRecipeInputBoundary {
    final DeleteRecipeDataAccessInterface deleteRecipeDataAccessObject;
    final DeleteRecipeOutputBoundary deleteRecipePresenter;

    public DeleteRecipeInteractor(DeleteRecipeDataAccessInterface deleteRecipeDataAccessInterface, DeleteRecipeOutputBoundary deleteRecipeOutputBoundary) {
        this.deleteRecipeDataAccessObject = deleteRecipeDataAccessInterface;
        this.deleteRecipePresenter = deleteRecipeOutputBoundary;
    }





    @Override
    public void execute(DeleteRecipeInputData deleteRecipeInputData) {







        Integer recipeID = deleteRecipeInputData.getDeletedRecipeID();


        if (!deleteRecipeDataAccessObject.existsByName(recipeID)) {


            deleteRecipePresenter.prepareFailView(recipeID + ": Recipe does not exist.");
        } else {


            UserRecipe userRecipe = deleteRecipeDataAccessObject.deleteRecipe(deleteRecipeInputData.getDeletedRecipeID());


            DeleteRecipeOutputData deleteRecipeOutputData = new DeleteRecipeOutputData(userRecipe.getName(), false);
            deleteRecipePresenter.prepareSuccessView(deleteRecipeOutputData);



        }
    }

}
