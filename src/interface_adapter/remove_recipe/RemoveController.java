package interface_adapter.remove_recipe;

import use_case.remove_recipe.RemoveInputBoundary;
import use_case.remove_recipe.RemoveInputData;

public class RemoveController {
    final RemoveInputBoundary removeUseCaseInteractor;

    public RemoveController(RemoveInputBoundary removeUseCaseInteractor){
        this.removeUseCaseInteractor = removeUseCaseInteractor;

    }
    public void execute(){
        RemoveInputData removeInputData = new RemoveInputData();
        removeUseCaseInteractor.execute(removeInputData);
    }
}
