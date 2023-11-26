package interface_adapter.collect_recipe;

import interface_adapter.signup.SignupState;

public class CollectRecipeState {
    private String folderNames = "";
    private String noFolderError = null;

    public CollectRecipeState(CollectRecipeState copy) {
        folderNames = copy.folderNames;
        noFolderError = copy.noFolderError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public CollectRecipeState() {
    }

    public String getFolderNames(){ return folderNames;
    }

    public String getNoFolderError() {return noFolderError;}

    @Override
    public String toString() {
        return "CollectRecipeState{" +
                "foldernames='" + folderNames + '\'' +
                '}';
    }

    public void setNoFolderError(String error) {
        noFolderError = error;
    }
}
