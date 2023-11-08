package data_access;

import entity.User;
import entity.folder.Folder;
import use_case.delete_folder.DeleteFolderUserDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryFolderDataAccessObject implements DeleteFolderUserDataAccessInterface {
    //TODO mini DAO used to test the Folder usecases
    private ArrayList<Folder> folders = new ArrayList<>();

    @Override
    public String deleteFolder(String folderName) {
        // remove 1 folder
        return null;
    }
}
