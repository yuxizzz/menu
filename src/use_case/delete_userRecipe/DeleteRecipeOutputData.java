package use_case.delete_userRecipe;

public class DeleteRecipeOutputData {
    private boolean deleteRecipeFailed;

    private String recipeDeleted;
    //Need to be implemented or used if we need to output some information after delete.
    public DeleteRecipeOutputData(String recipeDeleted, boolean useCaseFailed){
        this.deleteRecipeFailed = deleteRecipeFailed;
        this.recipeDeleted = recipeDeleted;

    }

    public String getRecipeDeleted(){return recipeDeleted;}
}
