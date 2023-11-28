package interface_adapter.upload_recipe;

import interface_adapter.open_recipe.OpenRecipeState;

public class UploadRecipeState {
    private String username = "";

    public UploadRecipeState(UploadRecipeState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public UploadRecipeState() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setRecipeID(Integer recipeUploaded) {
    }

    public void setRecipeIDError(String error) {
    }
}
