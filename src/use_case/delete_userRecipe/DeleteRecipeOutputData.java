package use_case.delete_userRecipe;

public class DeleteRecipeOutputData {
    private boolean deleteRecipeFailed;

    private String recipeDeleted;

    private Integer recipeID;

    //Need to be implemented or used if we need to output some information after delete.
    public DeleteRecipeOutputData(String recipeDeleted,  Integer recipeID, boolean useCaseFailed){
        this.recipeID = recipeID;
        this.deleteRecipeFailed = deleteRecipeFailed;
        this.recipeDeleted = recipeDeleted;

    }

    public String getRecipeDeleted(){
        return recipeDeleted;
    }

    public Integer getRecipeID(){
        return recipeID;
    }
}
