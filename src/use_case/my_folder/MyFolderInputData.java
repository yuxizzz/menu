package use_case.my_folder;

import entity.recipe.Recipe;

import java.util.HashMap;

public class MyFolderInputData {

    final private String username;

    public MyFolderInputData(String username) {
        this.username = username;
    }


    String getUsername() {
        return username;
    }

}

