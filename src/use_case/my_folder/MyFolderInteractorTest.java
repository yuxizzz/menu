package use_case.my_folder;

import data_access.InMemoryFolderDataAccessObject;
import data_access.InMemoryUserDataAccessObject;
import entity.folder.Folder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.add_recipe_to_folder.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

class MyFolderInteractorTest {
    @Test
    void successTest() {
        MyFolderInputData inputData = new MyFolderInputData("User1");
        MyFolderDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // This creates a successPresenter that tests whether the test case is as we expect.
        MyFolderOutputBoundary successPresenter = new MyFolderOutputBoundary() {

            @Override
            public void prepareSuccessView(MyFolderOutputData folder) {
                ArrayList<String> folders = new ArrayList<>();
                folders.add("My Recipes");
                assertEquals(folders, folder.getFoldernames());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };
        MyFolderInputBoundary interactor = new MyFolderInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void userNotExistTest() {
        MyFolderInputData inputData = new MyFolderInputData("User3");
        MyFolderDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // Add Paul to the repo so that when we check later they already exist
        MyFolderOutputBoundary successPresenter = new MyFolderOutputBoundary() {

            @Override
            public void prepareSuccessView(MyFolderOutputData folder) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals("User3: User does not exist.", error);
            }
        };
        MyFolderInputBoundary interactor = new MyFolderInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

}