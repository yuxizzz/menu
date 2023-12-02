package use_case.open_folder;

import entity.folder.Folder;
import entity.recipe.Recipe;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenFolderInteractor implements OpenFolderInputBoundary {
    final OpenFolderDataAccessInterface folderDataAccessObject;
    final OpenFolderOutputBoundary openFolderPresenter;

    public OpenFolderInteractor(OpenFolderDataAccessInterface folderDataAccessObject,
                                OpenFolderOutputBoundary openFolderPresenter) {
        this.folderDataAccessObject = folderDataAccessObject;
        this.openFolderPresenter = openFolderPresenter;
    }

    public void execute(OpenFolderInputData openFolderInputData) {
        String foldername = openFolderInputData.getFoldername();
        if (!folderDataAccessObject.existsByName(foldername)) {
            openFolderPresenter.prepareFailView(foldername + ": Folder does not exist.");
        }else {
             Folder folder = folderDataAccessObject.get(openFolderInputData.getFoldername());
             HashMap<Integer, ArrayList> recipeMap = folderDataAccessObject.getrecipeMap(foldername);


             OpenFolderOutputData openFolderOutputData = new OpenFolderOutputData(folder.getName(),
                     false,folder.getRecipeMap());
             openFolderPresenter.prepareSuccessView(openFolderOutputData);
            }
        }

}
