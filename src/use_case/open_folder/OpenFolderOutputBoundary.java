package use_case.open_folder;


import entity.recipe.Recipe;

import java.util.HashMap;

public interface OpenFolderOutputBoundary {
    void prepareSuccessView(OpenFolderOutputData folder);

    void prepareFailView(String error);

}
