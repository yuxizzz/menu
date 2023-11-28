package use_case.open_recipe;

import entity.recipe.Recipe;

import java.io.IOException;

public class OpenRecipeOutputData {
    private Recipe recipe;
    private boolean useCaseFailed;

    public OpenRecipeOutputData(Recipe recipe, boolean useCaseFailed) throws IOException {
//        this.recipeID = recipeID;
        this.useCaseFailed = useCaseFailed;
        this.recipe = recipe;
    }
    public Recipe getRecipe() {

        return recipe;
    }

    public Integer getRecipeID(){
        return recipe.getRecipeID();
    }

}
