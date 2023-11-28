package interface_adapter.open_recipe;

import entity.folder.Folder;
import use_case.open_recipe.OpenRecipeInputBoundary;
import use_case.open_recipe.OpenRecipeInputData;

import java.io.IOException;

public class OpenRecipeController {

    final OpenRecipeInputBoundary openRecipeInteractor;

    public OpenRecipeController(OpenRecipeInputBoundary openRecipeInteractor){

        this.openRecipeInteractor = openRecipeInteractor;
    }


    public void execute(Integer recipeID, Folder folder) throws IOException {
        OpenRecipeInputData openRecipeInputData = new OpenRecipeInputData(recipeID, folder);

        openRecipeInteractor.execute(openRecipeInputData);

    }
}
