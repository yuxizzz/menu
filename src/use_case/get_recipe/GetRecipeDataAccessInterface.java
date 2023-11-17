package use_case.get_recipe;

import entity.folder.Folder;
import entity.recipe.Recipe;

public interface GetRecipeDataAccessInterface {

//    boolean existsByName(Integer recipeID);
    void save(Recipe recipe);
}
