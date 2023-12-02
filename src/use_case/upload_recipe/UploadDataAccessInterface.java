package use_case.upload_recipe;

import data_access.FileRecipeDataAccessObject;
import data_access.FileUserDataAccessObject;
import entity.recipe.Recipe;

public interface UploadDataAccessInterface  {
    boolean existByName(String identifier);
    //TODO: do I need to impelment a method to save the recipeid to the default folder.
    //String createRecipe();
    void saveRecipe(Recipe recipe);
}
