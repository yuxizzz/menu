package use_case.open_folder;

import entity.folder.Folder;
import entity.recipe.Recipe;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public interface OpenFolderDataAccessInterface {
    boolean existsByName(String identifier);

    Folder get(String foldername);
    HashMap<Integer, ArrayList> getrecipeMap(String foldername);

}
