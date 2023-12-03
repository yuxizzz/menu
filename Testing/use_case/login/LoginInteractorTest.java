package use_case.login;

import data_access.InMemoryFolderDataAccessObject;
import data_access.InMemoryUserDataAccessObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.add_recipe_to_folder.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

class LoginInteractorTest {
    @Test
    void successTest() {
        LoginInputData inputData = new LoginInputData("User1", "123");
        LoginUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // This creates a successPresenter that tests whether the test case is as we expect.
        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {

            @Override
            public void prepareSuccessView(LoginOutputData user) {
                assertEquals("User1", user.getUsername());
                assertTrue(userRepository.existsByName("User1"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };
        LoginInputBoundary interactor = new LoginInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void userNameExistsTest() {
        LoginInputData inputData = new LoginInputData("User3", "abc");
        LoginUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // Add Paul to the repo so that when we check later they already exist
        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {

            @Override
            public void prepareSuccessView(LoginOutputData user) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals("User3: Account does not exist.", error);
                Assertions.assertFalse(userRepository.existsByName("User3"));
            }
        };
        LoginInputBoundary interactor = new LoginInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void passwordIncorrectTest() {
        LoginInputData inputData = new LoginInputData("User1", "abc");
        LoginUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // Add Paul to the repo so that when we check later they already exist
        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {

            @Override
            public void prepareSuccessView(LoginOutputData user) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals("Incorrect password for User1.", error);
                Assertions.assertTrue(userRepository.existsByName("User1"));
            }
        };
        LoginInputBoundary interactor = new LoginInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

}