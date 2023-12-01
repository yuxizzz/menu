package entity.user;
import entity.folder.Folder;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface User {

    String getName();

    String getPassword();

    ArrayList<Folder> getUserFolders();

    LocalDateTime getCreationTime();
}
