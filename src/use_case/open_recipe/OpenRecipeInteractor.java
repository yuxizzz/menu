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
        if (!openRecipeDataAccessObject.existsByName(openRecipeInputData.getRecipeID())) {
            openRecipePresenter.prepareFailView("Recipe not found.");
        } else {
            Folder folder = openRecipeInputData.getFolder();
            Recipe recipe = folder.getRecipeMap().get(openRecipeInputData.getRecipeID());
            openRecipeDataAccessObject.save(recipe);

            OpenRecipeOutputData openRecipeOutputData = new OpenRecipeOutputData(recipe, false);
            openRecipePresenter.prepareSuccessView(openRecipeOutputData);
        }
    }
}
