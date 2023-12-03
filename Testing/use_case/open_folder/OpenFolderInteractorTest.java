package use_case.open_folder;

import data_access.InMemoryFolderDataAccessObject;
import entity.recipe.CommonRecipe;
import entity.recipe.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.add_recipe_to_folder.*;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

class OpenFolderInteractorTest {

    @Test
    void successTest() {
        OpenFolderInputData inputData = new OpenFolderInputData("demo", "User1");
        OpenFolderDataAccessInterface userRepository = new InMemoryFolderDataAccessObject();

        // This creates a successPresenter that tests whether the test case is as we expect.
        OpenFolderOutputBoundary successPresenter = new OpenFolderOutputBoundary() {

            @Override
            public void prepareSuccessView(OpenFolderOutputData folder) {
                assertEquals("User1", folder.getUsername());
                assertEquals("demo", folder.getFoldername());
                assertTrue(folder.getRecipeMap().containsKey(1));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };
        OpenFolderInputBoundary interactor = new OpenFolderInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void folderNotExistTest() {
        OpenFolderInputData inputData = new OpenFolderInputData("C", "User1");
        OpenFolderDataAccessInterface userRepository = new InMemoryFolderDataAccessObject();

        // This creates a successPresenter that tests whether the test case is as we expect.
        OpenFolderOutputBoundary successPresenter = new OpenFolderOutputBoundary() {

            @Override
            public void prepareSuccessView(OpenFolderOutputData folder) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("C: Folder does not exist.", error);
            }
        };
        OpenFolderInputBoundary interactor = new OpenFolderInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

}