package use_case.open_recipe;

import entity.folder.Folder;

public class OpenRecipeInputData {
    private final Integer recipeID;

    final private String username;

    final private String foldername;

    public OpenRecipeInputData(Integer recipeID,
                               String username, String foldername) {
        this.recipeID = recipeID;
        this.username = username;
        this.foldername = foldername;
    }

    Integer getRecipeID() {
        return recipeID;
    }
    String getFoldername() {
        return foldername;
    }

    String getUsername(){return  username;}
}
