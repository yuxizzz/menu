package entity.user;

import entity.folder.DefaultFolder;
import entity.folder.Folder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

class CommonUser implements User {

    private final String name;
    private final String password;
    private final LocalDateTime creationTime;
    private ArrayList<Folder> userFolders;
    private DefaultFolder defaultFolder;




    /**
     * Requires: password is valid.
     * @param name
     * @param password
     */
    CommonUser(String name, String password, LocalDateTime creationTime) {
        this.name = name;
        this.password = password;
        this.creationTime = creationTime;
        this.defaultFolder = new DefaultFolder();
        this.userFolders = new ArrayList<>();
        userFolders.add(defaultFolder);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public ArrayList<Folder> getUserFolders() {
        return userFolders;
    }

    public DefaultFolder getDefaultFolder(){return defaultFolder;}

    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    @Override
    public void removeFolder(String folderName) {
        Folder folder = null;
        for (Folder f: userFolders) {
            if (f.getName() == folderName) {
                folder = f;
            }
        }
        userFolders.remove(folder);
  
    @Override
    public void addFolder(Folder folder) {
        userFolders.add(folder);
    }
}
