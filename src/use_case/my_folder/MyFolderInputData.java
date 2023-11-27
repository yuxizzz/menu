package use_case.my_folder;

import entity.recipe.Recipe;

import java.util.HashMap;

public class MyFolderInputData {

    final private String foldername;

    public MyFolderInputData(String foldername) {
        this.foldername = foldername;
    }


    String getFoldername() {
        return foldername;
    }

}

