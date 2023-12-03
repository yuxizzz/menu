package use_case.edit_recipe;

import entity.recipe.UserRecipe;

public interface EditDataAccessInterface {
    void editRecipe(Integer recipeID, UserRecipe userRecipe);

    boolean existsByRecipeID(Integer recipeID,String username);

    UserRecipe getRecipe(Integer recipeID, String username);
}
