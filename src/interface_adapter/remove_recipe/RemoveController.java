package interface_adapter.remove_recipe;

import use_case.remove_recipe.RemoveInputBoundary;
import use_case.remove_recipe.RemoveInputData;

public class RemoveController {
    final RemoveInputBoundary removeUseCaseInteractor;

    public RemoveController(RemoveInputBoundary removeUseCaseInteractor){
        this.removeUseCaseInteractor = removeUseCaseInteractor;

    }



    public void execute(Integer recipeID){
        RemoveInputData removeInputData = new RemoveInputData(recipeID);


        removeUseCaseInteractor.execute(removeInputData);
    }
}
