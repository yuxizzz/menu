package use_case.open_recipe;

import entity.folder.Folder;
import entity.recipe.Recipe;

import java.io.IOException;

public class OpenRecipeInteractor implements OpenRecipeInputBoundary {
    final OpenRecipeDataAccessInterface openRecipeDataAccessObject;
    final OpenRecipeOutputBoundary openRecipePresenter;

    public OpenRecipeInteractor(OpenRecipeDataAccessInterface openRecipeDataAccessObject,
                                OpenRecipeOutputBoundary openRecipePresenter) {
        this.openRecipeDataAccessObject = openRecipeDataAccessObject;
        this.openRecipePresenter = openRecipePresenter;
    }

    @Override
    public void execute(OpenRecipeInputData openRecipeInputData) throws IOException {
        //TODO: Add the foldername/username to the existsByName.
        if (!openRecipeDataAccessObject.existsByName(openRecipeInputData.getRecipeID())) {
            openRecipePresenter.prepareFailView("Recipe not found.");

        } else {
            Integer recipeID = openRecipeInputData.getRecipeID();
            String foldername = openRecipeInputData.getFoldername();
            String username = openRecipeInputData.getUsername();

            Recipe recipe = openRecipeDataAccessObject.getCommonRecipe(recipeID, username);

            String ingredients = recipe.getIngredients();
            String nutrition = recipe.getNutrition();
            String instructions = recipe.getInstructions();
            String image = recipe.getImage();
            String recipeurl = recipe.getRecipeURL();


            OpenRecipeOutputData openRecipeOutputData = new OpenRecipeOutputData(recipeID, false, ingredients,
                    nutrition, instructions, image, username, foldername);
            openRecipePresenter.prepareSuccessView(openRecipeOutputData);
        }
    }
}
