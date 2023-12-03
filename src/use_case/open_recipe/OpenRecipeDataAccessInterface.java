package use_case.open_recipe;

import entity.recipe.Recipe;

public interface OpenRecipeDataAccessInterface {
    boolean existsByName(Integer recipeID);
    void save(Recipe recipe);

    Recipe getCommonRecipe(Integer recipeID, String username);
}
