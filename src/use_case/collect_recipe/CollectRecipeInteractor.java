package use_case.collect_recipe;

import entity.folder.Folder;


import java.util.ArrayList;
import java.util.HashMap;

public class CollectRecipeInteractor implements CollectRecipeInputBoundary {
    final CollectRecipeDataAccessInterface recipeDataAccessObject;
    final CollectRecipeOutputBoundary userPresenter;

    public CollectRecipeInteractor(CollectRecipeDataAccessInterface collectRecipeDataAccessInterface,
                                   CollectRecipeOutputBoundary collectRecipeOutputBoundary) {
        this.recipeDataAccessObject = collectRecipeDataAccessInterface;
        this.userPresenter = collectRecipeOutputBoundary;
    }
    @Override
    public void execute(CollectRecipeInputData collectRecipeInputData) {
        if (recipeDataAccessObject.existsAllFolders(collectRecipeInputData.getRecipeID())) {
            userPresenter.prepareFailView("Recipe already existed in all folders");
        } else {
            ArrayList<Folder> folderLists = recipeDataAccessObject.getAllFolders(collectRecipeInputData.getUserID());
            ArrayList<String> folders = new ArrayList<>();
            for (Folder f: folderLists) {
                folders.add(f.getName());
            }
            CollectRecipeOutputData collectRecipeOutputData = new CollectRecipeOutputData(folders);
            userPresenter.prepareSuccessView(collectRecipeOutputData);

        }

    }
}
