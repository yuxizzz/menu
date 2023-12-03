package use_case.delete_userRecipe;

import entity.recipe.UserRecipe;

import java.util.ArrayList;
import java.util.HashMap;

public interface DeleteRecipeDataAccessInterface {


    UserRecipe deleteRecipe(Integer recipeid, String username);

    HashMap<Integer, ArrayList> getrecipeMap(String foldername);



    boolean existsByRecipeID(Integer recipeID, String username);
}
