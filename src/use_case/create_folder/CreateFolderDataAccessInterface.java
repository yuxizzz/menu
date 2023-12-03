package use_case.create_folder;

import entity.folder.Folder;
import entity.recipe.Recipe;

public interface CreateFolderDataAccessInterface {
    boolean existsByFolder(String identifier, String username);
    void save(Folder folder, String username);
}
