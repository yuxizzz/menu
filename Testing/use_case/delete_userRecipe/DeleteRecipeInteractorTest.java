package use_case.delete_userRecipe;

import data_access.InMemoryFolderDataAccessObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.add_recipe_to_folder.*;
import use_case.collect_recipe.*;
import use_case.delete_userRecipe.DeleteRecipeDataAccessInterface;
import use_case.delete_userRecipe.DeleteRecipeInputData;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

class DeleteRecipeInteractorTest {
    @Test
    void successTest() {
        DeleteRecipeInputData inputData = new DeleteRecipeInputData(2, "judy");
        DeleteRecipeDataAccessInterface folderRepository = new InMemoryFolderDataAccessObject();
        // This creates a successPresenter that tests whether the test case is as we expect.
        DeleteRecipeOutputBoundary successPresenter = new DeleteRecipeOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteRecipeOutputData output) {
                // 2 things to check: the output data is correct,
                // and the user has been created in the DAO.assertEquals("judy", output.getUserID());
                // any creation time is fine.
                assertTrue(output.getRecipeMap() instanceof HashMap<Integer, ArrayList>);
                assertEquals(2, output.getRecipeID());
                assertEquals("2",output.getRecipeDeleted());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }

        };

        DeleteRecipeInputBoundary interactor = new DeleteRecipeInteractor(folderRepository, successPresenter);
        interactor.execute(inputData);
    }





    @Test
    void failureRecipeExistsTest() {
        DeleteRecipeInputData inputData = new DeleteRecipeInputData( 10, "Jessica");
        DeleteRecipeDataAccessInterface folderRepository = new InMemoryFolderDataAccessObject();

        // Add Paul to the repo so that when we check later they already exist
        DeleteRecipeOutputBoundary successPresenter = new DeleteRecipeOutputBoundary() {

            @Override
            public void prepareSuccessView(DeleteRecipeOutputData outputData) {
                fail("Use case failure is unexpected.");

            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals(10 + ": Recipe does not exist.", error);
            }
        };
        DeleteRecipeInputBoundary interactor = new DeleteRecipeInteractor(folderRepository, successPresenter);
        interactor.execute(inputData);
    }





}
