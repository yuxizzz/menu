package interface_adapter.collect_recipe;

import use_case.collect_recipe.CollectRecipeInputBoundary;
import use_case.collect_recipe.CollectRecipeInputData;

public class CollectRecipeController {
    final CollectRecipeInputBoundary userCollectUseCaseInteractor;
    public CollectRecipeController(CollectRecipeInputBoundary userCollectUseCaseInteractor) {
        this.userCollectUseCaseInteractor = userCollectUseCaseInteractor;
    }

    public void execute(Integer recipeID, String username) {
        CollectRecipeInputData collectRecipeInputData = new CollectRecipeInputData(recipeID, username);

        userCollectUseCaseInteractor.execute(collectRecipeInputData);
    }
}
