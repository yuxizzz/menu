package interface_adapter.upload_recipe;

public class UploadRecipeState {

    private String recipename = "";
    private String recipenameError = null;

    private Integer recipeID = null;
    private String recipeIDError = null;

    public UploadRecipeState(UploadRecipeState copy){
        recipeID = copy.recipeID;
        recipename = copy.recipename;
    }

    public UploadRecipeState(){

    }


    public String getRecipename(){
        return recipename;
    }

    public Integer getRecipeID(){
        return recipeID;
    }

    public String getRecipenameError(){
        return recipenameError;
    }

    public String getRecipeIDError(){
        return recipeIDError;
    }
    public void setRecipeID(Integer recipeUploaded) {
        this.recipeID = recipeUploaded;
    }

    public void setRecipeIDError(String error) {
        this.recipeIDError = error;

    }

    public void setRecipename(String recipename){
        this.recipename = recipename;
    }
    public void setRecipenameError(String error){
        this.recipenameError = recipenameError;
    }
}
