package use_case.delete_foler;

import data_access.InMemoryFolderDataAccessObject;
import data_access.InMemoryUserDataAccessObject;
import org.junit.jupiter.api.Test;
import use_case.delete_folder.*;

import static org.junit.Assert.assertEquals;


class DeleteFolderInteractorTest {

    @Test
    void successTest() {
        DeleteFolderInputData inputData = new DeleteFolderInputData("Folder1", "User1");
        DeleteFolderUserDataAccessInterface folderRepository = new InMemoryUserDataAccessObject();

        // This creates a successPresenter that tests whether the test case is as we expect.
        DeleteFolderOutputBoundary successPresenter = new DeleteFolderOutputBoundary() {

            @Override
            public void prepareSuccessView(DeleteFolderOutputData message) {
                assertEquals(message.getFolderDeleted(), "Folder1 is removed");
            }
        };
        DeleteFolderInputBoundary interactor = new DeleteFolderInteractor(folderRepository, successPresenter);
        interactor.execute(inputData);
    }


}