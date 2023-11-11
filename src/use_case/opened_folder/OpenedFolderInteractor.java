package use_case.opened_folder;

import entity.folder.Folder;
import entity.recipe.Recipe;

public class OpenedFolderInteractor {
    final OpenedFolderDataAccessInterface recipeDataAccessObject;
    final OpenedFolderOutputBoundary openedFolderPresenter;

    public OpenedFolderInteractor(OpenedFolderDataAccessInterface recipeDataAccessObject,
                                  OpenedFolderOutputBoundary openedFolderPresenter) {
        this.recipeDataAccessObject = recipeDataAccessObject;
        this.openedFolderPresenter = openedFolderPresenter;
    }

    public void execute(OpenedFolderInputData openedFolderInputData) {
        Integer recipeid = openedFolderInputData.getRecipeid();
        if (!recipeDataAccessObject.existsByID(recipeid)) {
            openedFolderPresenter.prepareFailView("Recipe does not exist.");
        }else {
             Recipe recipe = recipeDataAccessObject.get(openedFolderInputData.getRecipeid());

             OpenedFolderOutputData openedFolderOutputData = new OpenedFolderOutputData(recipe.getRecipeID(), false);
             openedFolderPresenter.prepareSuccessView(openedFolderOutputData);
            }
        }
}
