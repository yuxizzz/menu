package use_case.remove_recipe;

import entity.folder.Folder;
import entity.recipe.CommonRecipe;
import use_case.open_folder.OpenFolderOutputData;

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


        if (!removeDataAccessObject.existsByName(recipeID)) {


            removePresenter.prepareFailView(recipeID + ": Recipe does not exist.");
        } else {

            CommonRecipe commonRecipe = removeDataAccessObject.removeRecipe(removeInputData.getRemovedRecipeID());


            RemoveOutputData removeOutputData = new RemoveOutputData(commonRecipe .getName(),
                    commonRecipe.getRecipeID(),false);
            removePresenter.prepareSuccessView(removeOutputData);



        }






    }
}
