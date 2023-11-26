package use_case.get_recipe;

import api.Search;
import entity.recipe.Recipe;

import java.io.IOException;

public class GetRecipeInteractor implements GetRecipeInputBoundary {
    final GetRecipeDataAccessInterface recipeDataAccessObject;
    final GetRecipeOutputBoundary recipePresenter;

    public GetRecipeInteractor(GetRecipeDataAccessInterface recipeDataAccessObject, GetRecipeOutputBoundary recipePresenter) {
        this.recipeDataAccessObject = recipeDataAccessObject;
        this.recipePresenter = recipePresenter;
    }

    @Override
    public void execute(GetRecipeInputData getRecipeInputData) throws IOException {
        if (recipeDataAccessObject.existsByName(getRecipeInputData.getRecipeID())) {
            recipePresenter.prepareFailView("Recipe not found.");
        } else {
            Recipe recipe = Search.getRecipe(getRecipeInputData.getRecipeID());
            recipeDataAccessObject.save(recipe);

            GetRecipeOutputData getRecipeOutputData = new GetRecipeOutputData(recipe, false);
            recipePresenter.prepareSuccessView(getRecipeOutputData);
        }
    }
}
