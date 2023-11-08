package entity;

import entity.folder.DefaultFolder;
import entity.folder.Folder;

import java.time.LocalDateTime;
import java.util.ArrayList;

class CommonUser implements User {

    private final String name;
    private final String password;
    private final LocalDateTime creationTime;
    private ArrayList<Folder> userFolders;



    /**
     * Requires: password is valid.
     * @param name
     * @param password
     */
    CommonUser(String name, String password, LocalDateTime creationTime) {
        this.name = name;
        this.password = password;
        this.creationTime = creationTime;
        DefaultFolder defaultFolder = new DefaultFolder();
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
    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
