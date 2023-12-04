package use_case.edit_recipe;

import data_access.InMemoryRecipeDataAccessObject;
import entity.recipe.UserRecipeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.upload_recipe.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EditInteractorTest {
    @Test
    void successTest(){
        EditInputData uploadInputData = new EditInputData(4,
                "new","sugar,water","high",
                "add sugar and water to floor","image","url",
                 "Jessica");

        EditDataAccessInterface recipeRepository = new InMemoryRecipeDataAccessObject();
        UserRecipeFactory userRecipeFactory = new UserRecipeFactory();

        // This creates a successPresenter that tests whether the test case is as we expect.
        EditOutputBoundary successPresenter = new EditOutputBoundary() {


            @Override
            public void prepareSuccessView(EditOutputData message) {
                String edit = "new";
                assertEquals(edit,message.getRecipeEdited());

            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };
        EditInputBoundary interactor = new EditInteractor(recipeRepository, successPresenter,
                userRecipeFactory);
        interactor.execute(uploadInputData);
    }


    @Test
    void recipeAlreadyExistTest(){
        EditInputData editInputData = new EditInputData(4,
                "1","1","1",
                "1","1","1",
                "Jessica");



        EditDataAccessInterface recipeRepository = new InMemoryRecipeDataAccessObject();

        UserRecipeFactory userRecipeFactory = new UserRecipeFactory();

        // This creates a successPresenter that tests whether the test case is as we expect.
        EditOutputBoundary successPresenter = new EditOutputBoundary() {


            @Override
            public void prepareSuccessView(EditOutputData message) {
                fail("Use case failure is unexpected.");

            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals("The edited  is the same as before", error);
            }
        };
        EditInputBoundary interactor = new EditInteractor(recipeRepository, successPresenter,
                userRecipeFactory);
        interactor.execute(editInputData);


    }




}

