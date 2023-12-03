package use_case.my_folder;

import data_access.InMemoryFolderDataAccessObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.add_recipe_to_folder.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

class MyFolderInteractorTest {
    @Test
    void successTest() {
        MyFolderInputData inputData = new MyFolderInputData("B", 2, "judy");
        AddRecipeToFolderDataAccessInterface userRepository = new InMemoryFolderDataAccessObject();

        // This creates a successPresenter that tests whether the test case is as we expect.
        AddRecipeToFolderOutputBoundary successPresenter = new AddRecipeToFolderOutputBoundary() {

            @Override
            public void prepareSuccessView(AddRecipeToFolderOutputData outputData) {
                String message = "Successfully added to B";
                assertEquals(message, outputData.getMessage());
                assertFalse(userRepository.addRecipeToFolder("B", 2));

            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };
        AddRecipeToFolderInputBoundary interactor = new AddRecipeToFolderInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void failureRecipeExistsTest() {
        AddRecipeToFolderInputData inputData = new AddRecipeToFolderInputData("B", 1, "judy");
        AddRecipeToFolderDataAccessInterface userRepository = new InMemoryFolderDataAccessObject();

        // Add Paul to the repo so that when we check later they already exist
        AddRecipeToFolderOutputBoundary successPresenter = new AddRecipeToFolderOutputBoundary() {

            @Override
            public void prepareSuccessView(AddRecipeToFolderOutputData outputData) {
                fail("Use case failure is unexpected.");

            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals("Recipe already existed", error);
                Assertions.assertFalse(userRepository.addRecipeToFolder("B", 1));
            }
        };
        AddRecipeToFolderInputBoundary interactor = new AddRecipeToFolderInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }


}