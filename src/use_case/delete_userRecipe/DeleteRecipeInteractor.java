package use_case.delete_userRecipe;

import use_case.clear_users.ClearInputData;
import use_case.clear_users.ClearOutputData;

public class DeleteRecipeInteractor implements DeleteRecipeInputBoundary {
    final DeleteRecipeDataAccessInterface deleteRecipeDataAccessObject;
    final DeleteRecipeOutputBoundary deleteRecipePresenter;

    public DeleteRecipeInteractor(DeleteRecipeDataAccessInterface deleteRecipeDataAccessInterface, DeleteRecipeOutputBoundary deleteRecipeOutputBoundary) {
        this.deleteRecipeDataAccessObject = deleteRecipeDataAccessInterface;
        this.deleteRecipePresenter = deleteRecipeOutputBoundary;
    }

    @Override
    public void execute(DeleteRecipeInputData deleteRecipeInputData) {

        Integer recipeid = null;
        //deleteRecipeDataAccessObject.deleteRecipe(Integer recipeid);
        String deletedRecipe = null;
        DeleteRecipeOutputData deleteRecipeOutputData = new DeleteRecipeOutputData(deletedRecipe, false);
        deleteRecipePresenter.prepareSuccessView(deleteRecipeOutputData);

    }

}
