package use_case.upload_recipe;

public class UploadOutputData {

    private boolean useCaseFailed;

    private Integer recipeUploaded;

    public UploadOutputData(Integer recipeID, boolean useCaseFailed){
        this.useCaseFailed = useCaseFailed;
        this.recipeUploaded = recipeID;
    }
    public Integer getRecipeUploaded() { return recipeUploaded;}
}
