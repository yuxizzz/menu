package use_case.remove_recipe;

import entity.recipe.CommonRecipe;
import entity.recipe.UserRecipe;

public interface RemoveDataAccessInterface {

    boolean existsByRecipeID(Integer identifier, String username);





    CommonRecipe removeRecipe(Integer removedRecipeID,
                              String username, String foldername);
}
