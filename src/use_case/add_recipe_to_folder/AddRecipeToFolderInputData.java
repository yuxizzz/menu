package use_case.add_recipe_to_folder;

public class AddRecipeToFolderInputData {
    final private String folderName;
    final private String recipeID;

    public AddRecipeToFolderInputData(String folderName, String recipeID) {
        this.folderName = folderName;
        this.recipeID = recipeID;
    }

    String getFolderName() {
        return folderName;
    }

    String getRecipeID(){return recipeID;};
}
