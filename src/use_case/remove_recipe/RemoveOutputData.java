package use_case.remove_recipe;

public class RemoveOutputData {

    private boolean useCaseFailed;

    private String removedRecipe;

    private Integer recipeID;

    public RemoveOutputData(String removedRecipe, Integer recipeID, boolean useCaseFailed){
        this.useCaseFailed = useCaseFailed;
        this.removedRecipe = removedRecipe;
        this.recipeID = recipeID;

    }
    public String getRemovedRecipe() {
        return removedRecipe;
    }

    public Integer getRecipeID(){
        return recipeID;
    }



}
