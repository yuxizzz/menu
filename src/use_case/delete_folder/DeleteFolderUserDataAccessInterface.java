package use_case.delete_folder;

import java.util.ArrayList;

public interface DeleteFolderUserDataAccessInterface {
    String deleteFolder(String folderName);

    boolean existsByName(String identifier);
}
