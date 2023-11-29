package use_case.edit_recipe;

public class EditInputData {

    final private Integer recipeID;

    final private String recipename;
    final private String ingredients;
    final private String nutrition;
    final private String instructions;
    final private String image;
    final private String recipeurl;

    public EditInputData(Integer recipeID,
                         String recipename,
                         String ingredients,
                         String nutrition,
                         String instructions,
                         String image,
                         String recipeurl){


        this.recipeID = recipeID;

        this.recipename = recipename;

        this.ingredients = ingredients;

        this.nutrition = nutrition;

        this.instructions = instructions;
        this.image = image;
        this.recipeurl = recipeurl;
    }

    Integer getRecipeID(){
        return recipeID;
    }

    String getRecipename(){
        return recipename;
    }



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



    String getRrecipeurl(){
        return recipeurl;
    }

}
