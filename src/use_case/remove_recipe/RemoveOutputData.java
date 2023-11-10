package use_case.remove_recipe;

public class RemoveOutputData {

    private boolean useCaseFailed;

    private String recipeRemoved;

    public RemoveOutputData(String recipeRemoved, boolean useCaseFailed){
        this.useCaseFailed = useCaseFailed;
        this.recipeRemoved = "Do you ensure to remove" + recipeRemoved + "?";
    }
    public String getRecipeRemoved() { return recipeRemoved;}
}
