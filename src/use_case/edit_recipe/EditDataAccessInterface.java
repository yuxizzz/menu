package use_case.edit_recipe;

import entity.recipe.UserRecipe;

public interface EditDataAccessInterface {
    String editRecipe();

    boolean existsByRecipeID(Integer recipeID);

    UserRecipe getRecipe();
}
