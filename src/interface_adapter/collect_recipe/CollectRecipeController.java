package interface_adapter.collect_recipe;

import use_case.collect_recipe.CollectRecipeInputBoundary;
import use_case.collect_recipe.CollectRecipeInputData;
import use_case.collect_recipe.CollectRecipeOutputData;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

public class CollectRecipeController {
    final CollectRecipeInputBoundary userCollectUseCaseInteractor;
    public CollectRecipeController(CollectRecipeInputBoundary userCollectUseCaseInteractor) {
        this.userCollectUseCaseInteractor = userCollectUseCaseInteractor;
    }

    public void execute(String recipeID, int userID) {
        CollectRecipeInputData collectRecipeInputData = new CollectRecipeInputData(recipeID, userID);

        userCollectUseCaseInteractor.execute(collectRecipeInputData);
    }
}
