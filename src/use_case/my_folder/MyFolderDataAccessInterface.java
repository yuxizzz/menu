package use_case.my_folder;

import entity.folder.Folder;
import entity.recipe.Recipe;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public interface MyFolderDataAccessInterface {
    boolean existsByName(String identifier);

    Folder get(String foldername);
    HashMap<Integer, ArrayList> getrecipeMap(String foldername);

}
