package use_case.delete_userRecipe;

import entity.recipe.UserRecipe;

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



        if (!deleteRecipeDataAccessObject.existsByRecipeID(recipeID, deleteRecipeInputData.getUsername())) {


            deleteRecipePresenter.prepareFailView(recipeID + ": Recipe does not exist.");
        } else {


            UserRecipe userRecipe = deleteRecipeDataAccessObject.deleteRecipe(deleteRecipeInputData.getDeletedRecipeID(),
                    deleteRecipeInputData.getUsername());


            DeleteRecipeOutputData deleteRecipeOutputData = new DeleteRecipeOutputData(userRecipe.getName(),
                    userRecipe.getRecipeID(),false);
            deleteRecipePresenter.prepareSuccessView(deleteRecipeOutputData);



        }
    }

}
