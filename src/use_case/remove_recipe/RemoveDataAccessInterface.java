package use_case.remove_recipe;

import entity.recipe.CommonRecipe;
import entity.recipe.UserRecipe;

import java.util.ArrayList;
import java.util.HashMap;

public interface RemoveFolderDataAccessInterface {

    boolean existsByRecipeID(Integer identifier, String username);

    HashMap<Integer, ArrayList> getrecipeMap(String foldername);



    CommonRecipe removeRecipe(Integer removedRecipeID,
                              String username, String foldername);
}
