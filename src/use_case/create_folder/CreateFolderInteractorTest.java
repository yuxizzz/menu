package use_case.create_folder;

import data_access.InMemoryFolderDataAccessObject;
import data_access.InMemoryUserDataAccessObject;
import entity.folder.CommonFolderFactory;
import entity.folder.FolderFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.add_recipe_to_folder.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

class CreateFolderInteractorTest {
    @Test
    void successTest() {
        CreateFolderInputData inputData = new CreateFolderInputData("folder4", "User1");
        CreateFolderDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        FolderFactory folderFactory = new CommonFolderFactory();
        // This creates a successPresenter that tests whether the test case is as we expect.
        CreateFolderOutputBoundary successPresenter = new CreateFolderOutputBoundary() {


            @Override
            public void prepareSuccessView(CreateFolderOutputData folder) {
                assertEquals("folder4", folder.getFoldername());
                assertEquals("User1", folder.getUsername());
                assertTrue(userRepository.existsByFolder("folder4", "User1"));

            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };
        CreateFolderInputBoundary interactor = new CreateFolderInteractor(userRepository, successPresenter, folderFactory);
        interactor.execute(inputData);
    }

    @Test
    void failureFolderExistsTest() {
        CreateFolderInputData inputData = new CreateFolderInputData("My Recipes", "User1");
        CreateFolderDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        FolderFactory folderFactory = new CommonFolderFactory();

        // Add Paul to the repo so that when we check later they already exist
        CreateFolderOutputBoundary successPresenter = new CreateFolderOutputBoundary() {

            @Override
            public void prepareSuccessView(CreateFolderOutputData folder) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals("Folder name already exists.", error);
                Assertions.assertTrue(userRepository.existsByFolder("My Recipes", "User1"));
            }
        };
        CreateFolderInputBoundary interactor = new CreateFolderInteractor(userRepository, successPresenter, folderFactory);
        interactor.execute(inputData);
    }

}