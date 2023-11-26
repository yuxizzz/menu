package data_access;

import entity.folder.Folder;
import use_case.delete_folder.DeleteFolderUserDataAccessInterface;

import java.util.ArrayList;

public class InMemoryFolderDataAccessObject implements DeleteFolderUserDataAccessInterface {
    //TODO mini DAO used to test the Folder usecases
    private ArrayList<Folder> folders = new ArrayList<>();

    @Override
    public String deleteFolder(String folderName) {
        // remove 1 folder
        return null;
    }

    @Override
    public boolean existsByName(String identifier) {
        return false;
    }
}
