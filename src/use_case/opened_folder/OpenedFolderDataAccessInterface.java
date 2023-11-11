package use_case.opened_folder;

import entity.folder.Folder;
import entity.recipe.Recipe;

public interface OpenedFolderDataAccessInterface {
    boolean existsByName(String identifier);

    Recipe get(Integer recipeid);

    boolean existsByID(Integer recipeid);
}
