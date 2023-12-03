package use_case.remove_recipe;

import entity.recipe.CommonRecipe;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveInteractor implements RemoveInputBoundary{

    final RemoveFolderDataAccessInterface removeDataAccessObject;
    final RemoveOutputBoundary removePresenter;
    public RemoveInteractor(RemoveFolderDataAccessInterface removeDataAccessInterface, RemoveOutputBoundary removeOutputBoundary) {
        this.removeDataAccessObject = removeDataAccessInterface;
        this.removePresenter = removeOutputBoundary;
    }

    @Override
    public void execute(RemoveInputData removeInputData) {







        Integer recipeID = removeInputData.getRemovedRecipeID();


        if (!removeDataAccessObject.existsByRecipeID(recipeID, removeInputData.getUsername())) {


            removePresenter.prepareFailView(recipeID + ": Recipe does not exist.");
        } else {
            HashMap<Integer, ArrayList> recipeMap = removeDataAccessObject.getrecipeMap(removeInputData.getFoldername());


            CommonRecipe commonRecipe = removeDataAccessObject.removeRecipe(removeInputData.getRemovedRecipeID(),
                    removeInputData.getUsername(), removeInputData.getFoldername());
            RemoveOutputData removeOutputData = new RemoveOutputData(commonRecipe .getName(),
                    commonRecipe.getRecipeID(),recipeMap,false);
            removePresenter.prepareSuccessView(removeOutputData);



        }






    }
}
