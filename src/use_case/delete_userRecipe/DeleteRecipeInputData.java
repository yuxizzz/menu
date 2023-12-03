package use_case.delete_userRecipe;

public class DeleteRecipeInputData {
    final private Integer recipeID;

    final private String username;


    public DeleteRecipeInputData(Integer recipeID, String username){

        this.recipeID = recipeID;


        this.username = username;
    }

    Integer getDeletedRecipeID(){

        return recipeID;

    }

    String getUsername(){
        return  username;
    }

}
