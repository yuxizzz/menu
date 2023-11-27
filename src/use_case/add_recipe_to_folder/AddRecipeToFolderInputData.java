package use_case.add_recipe_to_folder;

public class AddRecipeToFolderInputData {
    final private String folderName;
    final private Integer recipeID;
    private final String username;

    public AddRecipeToFolderInputData(String folderName, Integer recipeID, String username) {
        this.folderName = folderName;
        this.recipeID = recipeID;
        this.username = username;

    }

    String getFolderName() {
        return folderName;
    }

    Integer getRecipeID(){return recipeID;};
}
