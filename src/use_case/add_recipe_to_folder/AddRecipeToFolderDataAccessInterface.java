package use_case.add_recipe_to_folder;

public interface AddRecipeToFolderDataAccessInterface {
    Boolean addRecipeToFolder(String folderName, Integer recipeID);
}
