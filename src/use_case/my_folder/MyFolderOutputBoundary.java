package use_case.my_folder;


import entity.recipe.Recipe;

import java.util.HashMap;

public interface MyFolderOutputBoundary {
    void prepareSuccessView(MyFolderOutputData folder);

    void prepareFailView(String error);

}
