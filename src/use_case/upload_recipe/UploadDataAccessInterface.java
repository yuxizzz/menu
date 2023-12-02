package use_case.upload_recipe;


import entity.recipe.Recipe;

public interface UploadDataAccessInterface  {


    void saveRecipe(Integer recipeID, Recipe recipe, String username);


    boolean existByReicipeID(Integer recipeID, String username);
}
