package interface_adapter.edit_recipe;

import interface_adapter.logged_in.LoggedInState;

public class EditRecipeState {



    private String recipename = null;

    private String ingredients = null;

    private String nutrition = null;
    private String instructions = null;
    private String image = null;
    private String recipeurl = null;

    private Integer recipeID = null;

    private String recipeIDError = null;


    public EditRecipeState(EditRecipeState copy) {

        recipename = copy.recipename;
        recipeID = copy.recipeID;
        ingredients = copy.ingredients;
        nutrition = copy.nutrition;
        instructions = copy.instructions;
        image = copy.image;
        recipeurl = copy.recipeurl;
    }


    // Because of the previous copy constructor, the default constructor must be explicit.
    public EditRecipeState() {}


    public Integer getRecipeID(){

        return recipeID;
    }
    public void setRecipeID(Integer recipeID){

        this.recipeID = recipeID;
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


    public void setRecipeIDError(String recipeIDError){
        this.recipeIDError = recipeIDError;

    }

    public String getRecipeIDError(){

        return recipeIDError;
    }
    public String getRecipename() {

        return recipename;
    }
    public void setRecipename(String recipename) {

        this.recipename = recipename;
    }
}
