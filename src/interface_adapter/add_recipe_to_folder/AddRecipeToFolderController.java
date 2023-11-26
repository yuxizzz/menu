package interface_adapter.add_recipe_to_folder;

import use_case.add_recipe_to_folder.AddRecipeToFolderInputBoundary;
import use_case.add_recipe_to_folder.AddRecipeToFolderInputData;

public class AddRecipeToFolderController {
    final AddRecipeToFolderInputBoundary addFolderUseCaseInteractor;
    public AddRecipeToFolderController(AddRecipeToFolderInputBoundary addFolderUseCaseInteractor) {
        this.addFolderUseCaseInteractor = addFolderUseCaseInteractor;
    }

    public void execute(String folderName, String recipeID) {

    }

    public void execute(String folderName, Integer recipeID, int userID) {
        AddRecipeToFolderInputData addRecipeToFolderInputData = new AddRecipeToFolderInputData(folderName, recipeID, userID);

        addFolderUseCaseInteractor.execute(addRecipeToFolderInputData);
    }
}