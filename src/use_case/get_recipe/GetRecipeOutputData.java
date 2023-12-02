package use_case.get_recipe;

import api.Search;
import entity.recipe.Recipe;

import java.io.IOException;

public class GetRecipeOutputData {
//    private final Integer recipeID;
//    private Recipe recipe;
    private boolean useCaseFailed;

    private String ingredients;
    private String nutrition;
    private String instructions;
    private String image;
    private String recipeurl;
    private String recipename;
    private Integer recipeID;

    public GetRecipeOutputData(String recipename, Integer recipeID, String ingredients,
                               String nutrition, String instructions, String image,
                               String recipeurl, boolean useCaseFailed) throws IOException {

        this.useCaseFailed = useCaseFailed;
        this.recipename = recipename;
        this.recipeID = recipeID;
        this.ingredients = ingredients;
        this.nutrition = nutrition;
        this.instructions = instructions;
        this.image = image;
        this.recipeurl = recipeurl;
    }

    public String getRecipename() {
        return recipename;
    }
    public Integer getRecipeID() {
        return recipeID;
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

//    public Recipe getRecipe() {
//        return recipe;
//    }
}
