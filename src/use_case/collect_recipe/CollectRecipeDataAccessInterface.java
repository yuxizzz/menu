package use_case.collect_recipe;

import entity.folder.Folder;

import java.util.ArrayList;

public interface CollectRecipeDataAccessInterface {

    ArrayList<String>  getAllFolders(String username);
}
