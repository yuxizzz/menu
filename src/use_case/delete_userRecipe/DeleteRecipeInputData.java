package use_case.delete_userRecipe;

public class DeleteRecipeInputData {
    final private Integer recipeID;
    public DeleteRecipeInputData(Integer recipeID){

        this.recipeID = recipeID;


    }

    Integer getDeletedRecipeID(){

        return recipeID;

    }

}
