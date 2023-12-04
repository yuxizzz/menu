package entity.folder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultFolderTest {
    private DefaultFolder folder;
    @BeforeEach
    void init() {
        folder = new DefaultFolder();

    }



    @Test
    void getName() {
        assertEquals("My Recipes", folder.getName());
    }

}