package use_case.upload_recipe;

public class UploadOutputData {

    private boolean useCaseFailed;

    private String recipeRemoved;

    public UploadOutputData(String recipeRemoved, boolean useCaseFailed){
        this.useCaseFailed = useCaseFailed;
        this.recipeRemoved = "Do you ensure to remove" + recipeRemoved + "?";
    }
    public String getRecipeRemoved() { return recipeRemoved;}
}
