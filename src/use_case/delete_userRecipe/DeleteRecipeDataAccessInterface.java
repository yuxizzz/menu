package use_case.delete_userRecipe;

import entity.recipe.UserRecipe;

public interface DeleteRecipeDataAccessInterface {


    UserRecipe deleteRecipe(Integer recipeid, String username);



    boolean existsByRecipeID(Integer recipeID, String username);
}
