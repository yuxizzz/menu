package entity.user;

import entity.folder.Folder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonUserTest {

    private CommonUser user;

    @BeforeEach
    void init() {
        user = new CommonUser(
                "User1", "password", LocalDateTime.now());
    }

    @Test
    void getName() {
        assertEquals("User1", user.getName());
    }

    @Test
    void getPassword() {
        assertEquals("password", user.getPassword());
    }

    @Test
    void getUserFoldxers() {
        ArrayList<String> foldernames = new ArrayList<>();
        for (Folder folder: user.getUserFolders()){
            foldernames.add(folder.getName());
        }
        ArrayList<String> foldernames2 = new ArrayList<>();
        foldernames2.add("My Recipes");

        assertEquals(foldernames2, foldernames);
    }
}