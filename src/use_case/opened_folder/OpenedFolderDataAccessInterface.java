package use_case.opened_folder;

import entity.folder.Folder;

public interface OpenedFolderDataAccessInterface {
    boolean existsByName(String identifier);

    Folder get(String foldername);

}
