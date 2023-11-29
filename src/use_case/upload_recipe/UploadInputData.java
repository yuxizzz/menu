package use_case.upload_recipe;

import entity.user.User;

public class UploadInputData {
    final private String recipename;

    final private Integer recipeID;

    final private String ingredients;
    final private String nutrition;
    final private String instructions;
    final private String image;
    final private String recipeurl;

    final private User user;


    public UploadInputData(String recipename, String ingredients, String nutrition,
                           String instructions, String image, String recipeurl,
                           Integer recipeID, User user){

        this.recipename = recipename;
        this.recipeID = recipeID;
        this.ingredients = ingredients;
        this.nutrition = nutrition;
        this.instructions = instructions;
        this.image = image;
        this.recipeurl = recipeurl;
        this.user = user;

    }
    String getRecipename(){
        return recipename;
    }
    Integer getRecipeid(){
        return recipeID;}

    String getIngredients(){
        return ingredients;
    }
    String getNutrition(){
        return nutrition;
    }
    String getInstructions(){
        return instructions;
    }
    String getImage(){
        return image;
    }
    String getRecipeurl(){
        return recipeurl;
    }

    User getUser(){
        return user;
    }


}
