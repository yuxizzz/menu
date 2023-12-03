package use_case.delete_folder;

import data_access.InMemoryFolderDataAccessObject;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


class DeleteFolderInteractorTest {

    @Test
    void successTest() {
        DeleteFolderInputData inputData = new DeleteFolderInputData("B");
        DeleteFolderUserDataAccessInterface folderRepository = new InMemoryFolderDataAccessObject();

        // This creates a successPresenter that tests whether the test case is as we expect.
        DeleteFolderOutputBoundary successPresenter = new DeleteFolderOutputBoundary() {

            @Override
            public void prepareSuccessView(DeleteFolderOutputData message) {
                assertEquals(message.getFolderDeleted(), "B is removed");
            }
        };
        DeleteFolderInputBoundary interactor = new DeleteFolderInteractor(folderRepository, successPresenter);
        interactor.execute(inputData);
    }


}