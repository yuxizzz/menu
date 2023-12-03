package interface_adapter.edit_recipe;

import use_case.edit_recipe.EditInputBoundary;
import use_case.edit_recipe.EditInputData;

public class EditRecipeController {

    final EditInputBoundary editRecipeUseCaseInteractor;

    public EditRecipeController(EditInputBoundary editRecipeUseCaseInteractor) {
        this.editRecipeUseCaseInteractor = editRecipeUseCaseInteractor;
    }

    public void execute(Integer recipeID, String recipename, String ingredients,
                        String nutrition, String instructions,
                        String image, String recipeurl, String username){
        EditInputData editInputData = new EditInputData(recipeID, recipename,
                ingredients, nutrition,
                instructions, image, recipeurl, username);

        editRecipeUseCaseInteractor.execute(editInputData);
    }
}
