package use_case.add_recipe_to_folder;

import data_access.InMemoryFolderDataAccessObject;

import static org.junit.jupiter.api.Assertions.*;

class AddRecipeToFolderInteractorTest {

    void successTest() {
        AddRecipeToFolderInputData inputData = new AddRecipeToFolderInputData("A", 1, "judy");
        AddRecipeToFolderDataAccessInterface userRepository = new InMemoryFolderDataAccessObject();
    }
}

