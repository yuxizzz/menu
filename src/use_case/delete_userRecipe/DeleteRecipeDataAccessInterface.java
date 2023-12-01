package use_case.delete_userRecipe;

import entity.recipe.UserRecipe;

public interface DeleteRecipeDataAccessInterface {

//TO DO: need to be implemented
    UserRecipe deleteRecipe(Integer recipeid);

    boolean existsByName(Integer recipeID);
}
