package use_case.remove_recipe;

public class RemoveOutputData {

    private boolean useCaseFailed;

    private String removedRecipe;

    public RemoveOutputData(String removedRecipe, boolean useCaseFailed){
        this.useCaseFailed = useCaseFailed;
        this.removedRecipe = removedRecipe;
    }
    public String getRemovedRecipe() { return removedRecipe;}
}
