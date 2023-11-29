package use_case.edit_recipe;

import data_access.FileRecipeDataAccessObject;
import entity.recipe.UserRecipe;
import entity.recipe.UserRecipeFactory;
import entity.user.User;

import java.util.Objects;

public class EditInteractor implements EditInputBoundary{

    final EditDataAccessInterface editDataAccessObject;




    final EditOuntputBoundary editPresenter;

    final UserRecipeFactory userRecipeFactory;
    public EditInteractor(EditDataAccessInterface editDataAccessInterface, EditOuntputBoundary editOutputBoundary, UserRecipeFactory userRecipeFactory) {

        this.editDataAccessObject = editDataAccessInterface;

        this.editPresenter = editOutputBoundary;

        this.userRecipeFactory = userRecipeFactory;
    }

    @Override
    public void execute(EditInputData editInputData) {
        if (editDataAccessObject.existByRecipeID(editInputData.getRecipeID())) {
            UserRecipe userRecipe = editDataAccessObject.getRecipe();

            User user = userRecipe.getUser();

            EditOutputData editOutputData = new EditOutputData(userRecipe.getName(), false);
            editPresenter.prepareSuccessView(editOutputData);
            if (!Objects.equals(userRecipe.getImage(), editInputData.getImage())

                    && editInputData.getImage() != null) {

                userRecipe.editImage(editInputData.getImage(), userRecipe, user);

                editPresenter.prepareSuccessView(editOutputData);

            } else if (!Objects.equals(userRecipe.getIngredients(), editInputData.getIngredients())

                    && editInputData.getIngredients() != null) {

                userRecipe.editIngredients(editInputData.getIngredients(), userRecipe, user);

                editPresenter.prepareSuccessView(editOutputData);

            } else if (!Objects.equals(userRecipe.getInstructions(), editInputData.getInstructions())

                    && editInputData.getInstructions() != null) {

                userRecipe.editInstructions(editInputData.getInstructions(), userRecipe, user);

                editPresenter.prepareSuccessView(editOutputData);

            } else if (!Objects.equals(userRecipe.getName(), editInputData.getRecipename())

                    && editInputData.getRecipename() != null) {

                userRecipe.editName(editInputData.getRecipename(), userRecipe, user);

                editPresenter.prepareSuccessView(editOutputData);


            } else if (!Objects.equals(userRecipe.getNutrition(), editInputData.getNutrition())

                    && editInputData.getNutrition() != null) {

                userRecipe.editNutrition(editInputData.getNutrition(), userRecipe, user);

                editPresenter.prepareSuccessView(editOutputData);

            } else if (!Objects.equals(userRecipe.getRecipeURL(), editInputData.getRrecipeurl())

                    && editInputData.getRrecipeurl() != null) {

                userRecipe.editRecipeURL(editInputData.getRrecipeurl(), userRecipe, user);

                editPresenter.prepareSuccessView(editOutputData);


            } else if (!Objects.equals(userRecipe.getRecipeID(), editInputData.getRecipeID())

                    && editInputData.getRecipeID() != null) {

                userRecipe.editRecipeID(editInputData.getRecipeID(), userRecipe, user);

                editPresenter.prepareSuccessView(editOutputData);

            } else {
                editPresenter.prepareFailView("The edited image is the same as before");
            }


        }
    }
}
