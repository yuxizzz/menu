package entity.user;
import entity.folder.Folder;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface User {

    String getName();

    String getPassword();

    ArrayList<Folder> getUserFolders();

    LocalDateTime getCreationTime();

    void removeFolder(String folderName);

    void addFolder(Folder folder);

}
