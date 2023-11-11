package use_case.open_folder;

import entity.recipe.Recipe;

import java.util.HashMap;

public class OpenFolderInputData {

    final private String foldername;

    public OpenFolderInputData(String foldername) {
        this.foldername = foldername;
    }


    String getFoldername() {
        return foldername;
    }

}

