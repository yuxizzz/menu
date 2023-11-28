package interface_adapter.edit_recipe;

import use_case.edit_recipe.EditInputBoundary;
import use_case.edit_recipe.EditInputData;

public class EditRecipeController {

    final EditInputBoundary editRecipeUseCaseInteractor;

    public EditRecipeController(EditInputBoundary editRecipeUseCaseInteractor) {
        this.editRecipeUseCaseInteractor = editRecipeUseCaseInteractor;
    }

    public void execute(Integer recipeID){
        EditInputData editInputData = new EditInputData(recipeID);

        editRecipeUseCaseInteractor.execute(editInputData);
    }
}
