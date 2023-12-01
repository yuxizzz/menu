package use_case.remove_recipe;

import entity.recipe.CommonRecipe;
import entity.recipe.UserRecipe;

public interface RemoveFolderDataAccessInterface {

    boolean existsByName(Integer identifier);








    CommonRecipe removeRecipe(Integer removedRecipeID);
}
