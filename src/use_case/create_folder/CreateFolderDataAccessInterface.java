package use_case.create_folder;

import entity.folder.Folder;

public interface CreateFolderDataAccessInterface {
    boolean existsByName(String identifier);
    void save(Folder folder);
}
