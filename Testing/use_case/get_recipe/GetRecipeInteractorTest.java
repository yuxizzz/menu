package use_case.get_recipe;

import data_access.InMemoryFolderDataAccessObject;
import data_access.InMemoryRecipeDataAccessObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.add_recipe_to_folder.*;

import java.io.IOException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

class GetRecipeInteractorTest {
//    @Test
//    void successTest() throws IOException {
//        GetRecipeInputData inputData = new GetRecipeInputData(1);
//        GetRecipeDataAccessInterface recipeRepository = new InMemoryRecipeDataAccessObject();
//
//        // This creates a successPresenter that tests whether the test case is as we expect.
//        GetRecipeOutputBoundary successPresenter = new GetRecipeOutputBoundary() {
//            @Override
//            public void prepareSuccessView(GetRecipeOutputData recipe) {
//                Integer i = 1;
//                assertEquals(i, recipe.getRecipeID());
//                assertFalse(recipeRepository.existsByName(i));
//
//            }
//
//            @Override
//            public void prepareFailView(String error) {
//                fail("Use case failure is unexpected.");
//            }
//        };
//        GetRecipeInputBoundary interactor = new GetRecipeInteractor(recipeRepository, successPresenter);
//        interactor.execute(inputData);
//    }
//
//    @Test
//    void failureRecipeExistsTest() {
//        AddRecipeToFolderInputData inputData = new AddRecipeToFolderInputData("B", 1, "judy");
//        AddRecipeToFolderDataAccessInterface userRepository = new InMemoryFolderDataAccessObject();
//
//        // Add Paul to the repo so that when we check later they already exist
//        AddRecipeToFolderOutputBoundary successPresenter = new AddRecipeToFolderOutputBoundary() {
//
//            @Override
//            public void prepareSuccessView(AddRecipeToFolderOutputData outputData) {
//                fail("Use case failure is unexpected.");
//
//            }
//
//            @Override
//            public void prepareFailView(String error) {
//                Assertions.assertEquals("Recipe already existed", error);
//                Assertions.assertFalse(userRepository.addRecipeToFolder("B", 1));
//            }
//        };
//        AddRecipeToFolderInputBoundary interactor = new AddRecipeToFolderInteractor(userRepository, successPresenter);
//        interactor.execute(inputData);
//    }

}