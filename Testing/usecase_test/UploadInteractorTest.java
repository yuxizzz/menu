package usecase_test;

import data_access.InMemoryFolderDataAccessObject;
import data_access.InMemoryRecipeDataAccessObject;
import entity.recipe.UserRecipeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.my_folder.MyFolderInputBoundary;
import use_case.my_folder.MyFolderInteractor;
import use_case.my_folder.MyFolderOutputBoundary;
import use_case.my_folder.MyFolderOutputData;
import use_case.upload_recipe.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

class UploadInteractorTest {
    @Test
    void successTest(){
        UploadInputData uploadInputData = new UploadInputData("cake",
                "floor,sugar,water","high",
                "add sugar and water to floor","image","url",
                5, "User1");

        UploadDataAccessInterface recipeRepository = new InMemoryRecipeDataAccessObject();

        UserRecipeFactory userRecipeFactory = new UserRecipeFactory();

        // This creates a successPresenter that tests whether the test case is as we expect.
        UploadOutputBoundary successPresenter = new UploadOutputBoundary() {


            @Override
            public void prepareSuccessView(UploadOutputData message) {
                Integer id = 5;
                assertEquals(id,message.getRecipeUploaded());

            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };
        UploadInputBoundary interactor = new UploadInteractor(recipeRepository, successPresenter,
                userRecipeFactory);
        interactor.execute(uploadInputData);
    }


    @Test
    void recipeAlreadyExistTest(){
        UploadInputData uploadInputData = new UploadInputData("cake",
                "floor,sugar,water","high",
                "add sugar and water to floor","image","url",
                1, "User1");



        UploadDataAccessInterface recipeRepository = new InMemoryRecipeDataAccessObject();

        UserRecipeFactory userRecipeFactory = new UserRecipeFactory();

        // This creates a successPresenter that tests whether the test case is as we expect.
        UploadOutputBoundary successPresenter = new UploadOutputBoundary() {


            @Override
            public void prepareSuccessView(UploadOutputData message) {
                fail("Use case failure is unexpected.");

            }

            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals("Recipe ID already exists.", error);
            }
        };
        UploadInputBoundary interactor = new UploadInteractor(recipeRepository, successPresenter,
                userRecipeFactory);
        interactor.execute(uploadInputData);


    }




}
