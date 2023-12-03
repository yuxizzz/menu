package use_case.search;

import data_access.InMemoryFolderDataAccessObject;
import data_access.InMemorySearchResultsDataAccessObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.add_recipe_to_folder.*;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

class SearchInteractorTest {
//    @Test
//    void successTest() {
//        SearchInputData inputData = new SearchInputData("tomato", "nut-free");
//        SearchUserDataAccessInterface resultsRepository = new InMemorySearchResultsDataAccessObject();
//
//        // This creates a successPresenter that tests whether the test case is as we expect.
//        AddRecipeToFolderOutputBoundary successPresenter = new AddRecipeToFolderOutputBoundary() {
//
//            @Override
//            public void prepareSuccessView(AddRecipeToFolderOutputData outputData) {
//                String message = "Successfully added to B";
//                assertEquals(message, outputData.getMessage());
//                assertFalse(userRepository.addRecipeToFolder("B", 2));
//            }
//
//            @Override
//            public void prepareFailView(String error) {
//                fail("Use case failure is unexpected.");
//            }
//        };
//        AddRecipeToFolderInputBoundary interactor = new AddRecipeToFolderInteractor(userRepository, successPresenter);
//        interactor.execute(inputData);
//    }

    @Test
    void failureIngredientExistsTest() throws IOException {
        SearchInputData inputData = new SearchInputData("", "gluten free");
        SearchUserDataAccessInterface userRepository = new InMemorySearchResultsDataAccessObject();

        // Add Paul to the repo so that when we check later they already exist
        SearchOutputBoundary successPresenter = new SearchOutputBoundary() {

            @Override
            public void prepareSuccessView(SearchOutputData message) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals("Invalid ingredients", error);
            }
        };
        SearchInputBoundary interactor = new SearchInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }
}