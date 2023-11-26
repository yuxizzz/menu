package interface_adapter.collect_recipe;

import use_case.collect_recipe.CollectRecipeInputBoundary;
import use_case.collect_recipe.CollectRecipeInputData;

public class CollectRecipeController {
    final CollectRecipeInputBoundary userCollectUseCaseInteractor;
    public CollectRecipeController(CollectRecipeInputBoundary userCollectUseCaseInteractor) {
        this.userCollectUseCaseInteractor = userCollectUseCaseInteractor;
    }

    public void execute(Integer recipeID, Integer userID) {
        CollectRecipeInputData collectRecipeInputData = new CollectRecipeInputData(recipeID, userID);

        userCollectUseCaseInteractor.execute(collectRecipeInputData);
    }
}
