package interface_adapter.upload_recipe;

import entity.recipe.UserRecipe;
import entity.user.User;

public class UploadRecipeState {

    private String recipename = "";


    private String recipenameError = null;

    private String ingredients = null;

    private String nutrition = null;
    private String instructions = null;
    private String image = null;
    private String recipeurl = null;

    private Integer recipeID = null;
    private String recipeIDError = null;

    private String username = null;

    public UploadRecipeState(UploadRecipeState copy){
        recipeID = copy.recipeID;
        recipename = copy.recipename;
        ingredients = copy.ingredients;
        nutrition = copy.nutrition;
        instructions = copy.instructions;
        image = copy.image;
        recipeurl = copy.recipeurl;
        recipenameError = copy.recipenameError;
        recipeIDError = copy.recipeIDError;
    }

    public UploadRecipeState(){

    }


    public String getRecipename(){
        return recipename;
    }

    public Integer getRecipeID(){
        return recipeID;
    }

    public String getRecipenameError(){
        return recipenameError;
    }

    public String getRecipeIDError(){
        return recipeIDError;
    }
    public void setRecipeID(Integer recipeUploaded) {
        this.recipeID = recipeUploaded;
    }

    public void setRecipeIDError(String error) {
        this.recipeIDError = error;

    }

    public void setRecipename(String recipename){
        this.recipename = recipename;
    }
    public void setRecipenameError(String error){
        this.recipenameError = recipenameError;
    }
    public String getIngredients(){

        return ingredients;
    }
    public void setIngredients(String ingredients){

        this.ingredients = ingredients;
    }
    public String getNutrition(){

        return nutrition;
    }
    public void setNutrition(String nutrition){

        this.nutrition = nutrition;
    }
    public String getInstructions(){

        return instructions;
    }
    public void setInstructions(String instructions){

        this.instructions = instructions;
    }
    public String getImage(){

        return image;
    }
    public void setImage(String image){

        this.image = image;
    }
    public String getRecipeurl(){

        return recipeurl;
    }
    public void setRecipeurl(String recipeurl){

        this.recipeurl = recipeurl;
    }

    public void setUsername(String username){

        this.username = username;
    }

    public String getUsername(){

        return username;


    }

}
