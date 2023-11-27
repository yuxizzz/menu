package use_case.upload_recipe;

import entity.recipe.Recipe;

public interface UploadDataAccessInterface {
    boolean existByName(String identifier);
    //To Do: do I need to impelment a method to save the recipeid to the default folder.
    //String createRecipe();
    void saveRecipe(Recipe recipe);
}
