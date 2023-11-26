package use_case.create_folder;

import entity.folder.Folder;
import entity.recipe.Recipe;

public interface CreateFolderDataAccessInterface {
    boolean existsByName(String identifier);
    void save(Folder folder);
}
