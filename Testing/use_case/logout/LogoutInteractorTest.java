package use_case.logout;

import data_access.InMemoryFolderDataAccessObject;
import data_access.InMemoryUserDataAccessObject;
import org.junit.jupiter.api.Test;
import use_case.open_folder.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

//class LogoutInteractorTest {
//    @Test
//    void successTest() {
//        LogoutInputData inputData = new LogoutInputData();
//        LogoutDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
//
//        // This creates a successPresenter that tests whether the test case is as we expect.
//        LogoutOutputBoundary successPresenter = new LogoutOutputBoundary() {
//
//            @Override
//            public void prepareSuccessView() {
//
//            }
//
//            @Override
//            public void prepareFailView(String error) {
//                fail("Use case failure is unexpected.");
//            }
//        };
//        OpenFolderInputBoundary interactor = new OpenFolderInteractor(userRepository, successPresenter);
//        interactor.execute(inputData);
//    }
//
//}