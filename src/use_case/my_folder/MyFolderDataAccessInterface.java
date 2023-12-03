package use_case.my_folder;

import entity.folder.Folder;
import entity.recipe.Recipe;
import entity.user.User;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public interface MyFolderDataAccessInterface {
    boolean existsByName(String identifier);

    User get(String username);

    ArrayList<String> getFolderList(String username);

}
