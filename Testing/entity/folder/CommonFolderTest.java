package entity.folder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonFolderTest {

    private CommonFolder folder;
    @BeforeEach
    void init() {
        folder = new CommonFolder("Folder1");
    }

    @Test
    void getName() {
        assertEquals("Folder1", folder.getName());
    }



}