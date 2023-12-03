package use_case.signup;

import data_access.InMemoryFolderDataAccessObject;
import data_access.InMemoryUserDataAccessObject;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.add_recipe_to_folder.*;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

class SignupInteractorTest {
    @Test
    void successTest() {
        SignupInputData inputData = new SignupInputData("B", "123", "123");
        SignupUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        UserFactory userFactory = new CommonUserFactory();

        // This creates a successPresenter that tests whether the test case is as we expect.
        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {

            @Override
            public void prepareSuccessView(SignupOutputData user) {
                assertEquals("B", user.getUsername());
                assertTrue(userRepository.existsByName("B"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };
        SignupInputBoundary interactor = new SignupInteractor(userRepository, successPresenter, userFactory);
        interactor.execute(inputData);
    }

    @Test
    void failureUserExistsTest() {
        SignupInputData inputData = new SignupInputData("User1", "123", "123");
        SignupUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        UserFactory userFactory = new CommonUserFactory();

        // This creates a successPresenter that tests whether the test case is as we expect.
        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {

            @Override
            public void prepareSuccessView(SignupOutputData user) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("User already exists.", error);
            }
        };
        SignupInputBoundary interactor = new SignupInteractor(userRepository, successPresenter, userFactory);
        interactor.execute(inputData);
    }

    @Test
    void failurPasswordNotMatchTest() {
        SignupInputData inputData = new SignupInputData("UB", "121", "123");
        SignupUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        UserFactory userFactory = new CommonUserFactory();

        // This creates a successPresenter that tests whether the test case is as we expect.
        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {

            @Override
            public void prepareSuccessView(SignupOutputData user) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Passwords don't match.", error);
            }
        };
        SignupInputBoundary interactor = new SignupInteractor(userRepository, successPresenter, userFactory);
        interactor.execute(inputData);
    }
}