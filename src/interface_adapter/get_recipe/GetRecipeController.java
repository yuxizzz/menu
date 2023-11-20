package interface_adapter.get_recipe;

import use_case.get_recipe.GetRecipeInputBoundary;
import use_case.get_recipe.GetRecipeInputData;

import java.io.IOException;

public class GetRecipeController {
    final GetRecipeInputBoundary getRecipeInteractor;

    public GetRecipeController(GetRecipeInputBoundary getRecipeInteractor) {
        this.getRecipeInteractor = getRecipeInteractor;
    }
    public void execute(Integer recipeID) throws IOException {
        GetRecipeInputData getRecipeInputData = new GetRecipeInputData(recipeID);
        getRecipeInteractor.execute(getRecipeInputData);
    }
}
