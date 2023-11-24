package use_case.add_recipe_to_folder;

public class AddRecipeToFolderInputData {
    final private String folderName;
    final private Integer recipeID;
    private final int userID;

    public AddRecipeToFolderInputData(String folderName, Integer recipeID, int userID) {
        this.folderName = folderName;
        this.recipeID = recipeID;
        this.userID = userID;

    }

    String getFolderName() {
        return folderName;
    }

    Integer getRecipeID(){return recipeID;};
}
