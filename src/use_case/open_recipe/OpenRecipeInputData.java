package use_case.open_recipe;

import entity.folder.Folder;

public class OpenRecipeInputData {
    private final Integer recipeID;
    private final Folder folder;

    public OpenRecipeInputData(Integer recipeID, Folder folder) {
        this.recipeID = recipeID;
        this.folder = folder;
    }

    Integer getRecipeID() {
        return recipeID;
    }
    Folder getFolder() {
        return folder;
    }
}
