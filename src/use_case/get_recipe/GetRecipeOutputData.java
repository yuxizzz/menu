package use_case.get_recipe;

import api.Search;
import entity.recipe.Recipe;

import java.io.IOException;

public class GetRecipeOutputData {
//    private final Integer recipeID;
    private Recipe recipe;
    private boolean useCaseFailed;

    public GetRecipeOutputData(Integer recipeID, boolean useCaseFailed) throws IOException {
//        this.recipeID = recipeID;
        this.useCaseFailed = useCaseFailed;
        this.recipe = Search.getRecipe(recipeID);
    }
    public Recipe getRecipe() {
        return recipe;
    }
}
