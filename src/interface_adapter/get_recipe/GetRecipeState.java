package interface_adapter.get_recipe;

import entity.recipe.Recipe;

public class GetRecipeState {
//    private Recipe recipe;
//    private String recipeError = null;

    private String ingredients;
    private String nutrition;
    private String instructions;
    private String image;
    private String recipeurl;
    private String recipename = "";
    private String recipenameError = null;
    private Integer recipeID = null;
    private String recipeIDError = null;
    private String username;

    public GetRecipeState(GetRecipeState copy) {
        recipename = copy.recipename;
        recipenameError = copy.recipenameError;
        recipeID = copy.recipeID;
        recipeIDError = copy.recipeIDError;
        username = copy.username;
        ingredients = copy.ingredients;
        nutrition = copy.nutrition;
        instructions = copy.instructions;
        image = copy.image;
        recipeurl = copy.recipeurl;
    }
    public GetRecipeState() {
    }
//    public Recipe getRecipe() {
//        return recipe;
//    }
//    public String getRecipeError() {
//        return recipeError;
//    }
//    public void setRecipe(Recipe recipe) {
//        this.recipe = recipe;
//    }
//    public void setRecipeError(String recipeError) {
//        this.recipeError = recipeError;
//    }
//
//    public String getRecipeName() {
//        return recipe.getName();
//    }
//    public String getRecipeULR() {
//        return recipe.getRecipeURL();
//    }
//    public String getRecipeImage() {
//        return recipe.getImage();
//    }
//    public String getRecipeIngredients() {
//        return recipe.getIngredients();
//    }
//    public String getRecipeInstructions() {
//        return recipe.getInstructions();
//    }
//    public String getRecipeNutrition() {
//        return recipe.getNutrition();
//    }
//    public Integer getRecipeID() {
//        return recipe.getRecipeID();
//    }

    public String getRecipename() {
        return recipename;
    }
    public String getRecipenameError() {
        return recipenameError;
    }
    public Integer getRecipeID() {
        return recipeID;
    }
    public String getRecipeIDError() {
        return recipeIDError;
    }

    public String getRecipeULR() {
        return recipeurl;
    }
    public String getImage() {
        return image;
    }
    public String getIngredients() {
        return ingredients;
    }
    public String getInstructions() {
        return instructions;
    }
    public String getNutrition() {
        return nutrition;
    }


    public void setImage(String image) {
        this.image = image;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public void setRecipeID(Integer recipeID) {
        this.recipeID = recipeID;
    }
    public void setRecipename(String recipename) {
        this.recipename = recipename;
    }
    public void setRecipenameError(String recipenameError) {
        this.recipenameError = recipenameError;
    }
    public void setRecipeIDError(String recipeIDError) {
        this.recipeIDError = recipeIDError;
    }
    public void setRecipeurl(String recipeurl) {
        this.recipeurl = recipeurl;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
