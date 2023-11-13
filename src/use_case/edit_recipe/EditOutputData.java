package use_case.edit_recipe;

public class EditOutputData {

    private boolean useCaseFailed;

    private String recipeRemoved;

    public EditOutputData(String recipeRemoved, boolean useCaseFailed){
        this.useCaseFailed = useCaseFailed;
        this.recipeRemoved = "Do you ensure to remove" + recipeRemoved + "?";
    }
    public String getRecipeRemoved() { return recipeRemoved;}
}
