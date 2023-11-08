package use_case.open_folder;

import entity.User;

public interface OpenFolderDataAccessInterface {
    boolean existsByName(String identifier);

    // Folder get(String foldername);
}
