package interface_adapter.get_recipe;

import entity.recipe.Recipe;

public class GetRecipeState {
    private Recipe recipe;
    private String recipeError = null;
    public GetRecipeState(GetRecipeState copy) {
        recipe = copy.recipe;
        recipeError = copy.recipeError;
    }
    public GetRecipeState() {
    }
    public Recipe getRecipe() {
        return recipe;
    }
    public String getRecipeError() {
        return recipeError;
    }
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    public void setRecipeError(String recipeError) {
        this.recipeError = recipeError;
    }
}
