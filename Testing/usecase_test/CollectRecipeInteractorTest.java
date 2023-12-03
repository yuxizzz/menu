package usecase_test;

import data_access.InMemoryFolderDataAccessObject;
import org.junit.jupiter.api.Test;
import use_case.collect_recipe.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CollectRecipeInteractorTest {

    @Test
    void successTest() {
        CollectRecipeInputData inputData = new CollectRecipeInputData(1, "judy");
        CollectRecipeDataAccessInterface folderRepository = new InMemoryFolderDataAccessObject();
        // This creates a successPresenter that tests whether the test case is as we expect.
        CollectRecipeOutputBoundary successPresenter = new CollectRecipeOutputBoundary() {
            @Override
            public void prepareSuccessView(CollectRecipeOutputData output) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.assertEquals("judy", output.getUserID()); // any creation time is fine.
                assertTrue(output.getFolders() instanceof ArrayList<String>);
                assertEquals("judy", output.getUserID());
                assertEquals(1, output.getRecipeID());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }

        };

        CollectRecipeInputBoundary interactor = new CollectRecipeInteractor(folderRepository, successPresenter);
        interactor.execute(inputData);
    }
}