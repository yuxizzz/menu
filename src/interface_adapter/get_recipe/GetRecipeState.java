package interface_adapter.get_recipe;

import entity.recipe.Recipe;

public class GetRecipeState {
    private Recipe recipe;
    private String recipeError = null;

    private String username;
//    private String recipeName = recipe.getName();
    public GetRecipeState(GetRecipeState copy) {
        recipe = copy.recipe;
        recipeError = copy.recipeError;
//        recipeName = copy.recipeName;
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
    public String getRecipeName() {
        return recipe.getName();
    }
    public String getRecipeULR() {
        return recipe.getRecipeURL();
    }
    public String getRecipeImage() {
        return recipe.getImage();
    }
    public String getRecipeIngredients() {
        return recipe.getIngredients();
    }
    public String getRecipeInstructions() {
        return recipe.getInstructions();
    }
    public String getRecipeNutrition() {
        return recipe.getNutrition();
    }
    public Integer getRecipeID() {
        return recipe.getRecipeID();
    }
    public void setUsername(String username) {this.username = username;}
    public String getUsername() {return this.username;}
}
