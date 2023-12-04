package use_case.remove_recipe;

import data_access.InMemoryFolderDataAccessObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.delete_userRecipe.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveInteractorTest {
    @Test
    void successTest() {
        RemoveInputData inputData = new RemoveInputData(1, "Irina","demo");
        RemoveDataAccessInterface folderRepository = new InMemoryFolderDataAccessObject();
        // This creates a successPresenter that tests whether the test case is as we expect.
        RemoveOutputBoundary successPresenter = new RemoveOutputBoundary() {
            @Override
            public void prepareSuccessView(RemoveOutputData output) {
                // 2 things to check: the output data is correct,
                // and the user has been created in the DAO.assertEquals("judy", output.getUserID());
                // any creation time is fine.
                assertTrue(output.getRecipeMap() instanceof HashMap<Integer, ArrayList>);
                assertEquals(1, output.getRecipeID());
                assertEquals("1",output.getRemovedRecipe());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }

        };

        RemoveInputBoundary interactor = new RemoveInteractor(folderRepository, successPresenter);
        interactor.execute(inputData);
    }





    @Test
    void failureRecipeExistsTest() {
        RemoveInputData inputData = new RemoveInputData(10, "Jessica", "demo");
        RemoveDataAccessInterface folderRepository = new InMemoryFolderDataAccessObject();

        // Add Paul to the repo so that when we check later they already exist
        RemoveOutputBoundary successPresenter = new RemoveOutputBoundary() {

            @Override
            public void prepareSuccessView(RemoveOutputData outputData) {
                fail("Use case failure is unexpected.");

            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(10 + ": Recipe does not exist.", error);
            }
        };
        RemoveInputBoundary interactor = new RemoveInteractor(folderRepository, successPresenter);
        interactor.execute(inputData);
        }



    }




