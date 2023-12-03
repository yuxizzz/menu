package use_case.edit_recipe;

import entity.recipe.UserRecipe;
import entity.recipe.UserRecipeFactory;

import java.util.Objects;

public class EditInteractor implements EditInputBoundary{

    final EditDataAccessInterface editDataAccessObject;




    final EditOutputBoundary editPresenter;

    final UserRecipeFactory userRecipeFactory;
    public EditInteractor(EditDataAccessInterface editDataAccessInterface, EditOutputBoundary editOutputBoundary, UserRecipeFactory userRecipeFactory) {

        this.editDataAccessObject = editDataAccessInterface;

        this.editPresenter = editOutputBoundary;

        this.userRecipeFactory = userRecipeFactory;
    }

    @Override
    public void execute(EditInputData editInputData) {
        if (editDataAccessObject.existsByRecipeID(editInputData.getRecipeID(), editInputData.getUsername())) {
            UserRecipe userRecipe = editDataAccessObject.getRecipe(editInputData.getRecipeID(), editInputData.getUsername());

            String username = userRecipe.getUsername();

            EditOutputData editOutputData = new EditOutputData(userRecipe.getName(), false);
            editPresenter.prepareSuccessView(editOutputData);
            Integer recipeID = editInputData.getRecipeID();


            if (!Objects.equals(userRecipe.getImage(), editInputData.getImage())

                    && editInputData.getImage() != null) {

                userRecipe.editImage(editInputData.getImage(), userRecipe, username);

                editDataAccessObject.editRecipe(recipeID, userRecipe);

                editPresenter.prepareSuccessView(editOutputData);

            } else if (!Objects.equals(userRecipe.getIngredients(), editInputData.getIngredients())

                    && editInputData.getIngredients() != null) {

                userRecipe.editIngredients(editInputData.getIngredients(), userRecipe, username);

                editDataAccessObject.editRecipe(recipeID, userRecipe);

                editPresenter.prepareSuccessView(editOutputData);

            } else if (!Objects.equals(userRecipe.getInstructions(), editInputData.getInstructions())

                    && editInputData.getInstructions() != null) {

                userRecipe.editInstructions(editInputData.getInstructions(), userRecipe, username);

                editDataAccessObject.editRecipe(recipeID, userRecipe);

                editPresenter.prepareSuccessView(editOutputData);

            } else if (!Objects.equals(userRecipe.getName(), editInputData.getRecipename())

                    && editInputData.getRecipename() != null) {

                userRecipe.editName(editInputData.getRecipename(), userRecipe, username);

                editDataAccessObject.editRecipe(recipeID, userRecipe);

                editPresenter.prepareSuccessView(editOutputData);


            } else if (!Objects.equals(userRecipe.getNutrition(), editInputData.getNutrition())

                    && editInputData.getNutrition() != null) {

                userRecipe.editNutrition(editInputData.getNutrition(), userRecipe, username);

                editDataAccessObject.editRecipe(recipeID, userRecipe);

                editPresenter.prepareSuccessView(editOutputData);

            } else if (!Objects.equals(userRecipe.getRecipeURL(), editInputData.getRrecipeurl())

                    && editInputData.getRrecipeurl() != null) {

                userRecipe.editRecipeURL(editInputData.getRrecipeurl(), userRecipe, username);

                editDataAccessObject.editRecipe(recipeID, userRecipe);

                editPresenter.prepareSuccessView(editOutputData);


            } else if (!Objects.equals(userRecipe.getRecipeID(), editInputData.getRecipeID())

                    && editInputData.getRecipeID() != null) {

                userRecipe.editRecipeID(editInputData.getRecipeID(), userRecipe, username);

                editDataAccessObject.editRecipe(recipeID, userRecipe);

                editPresenter.prepareSuccessView(editOutputData);

            } else {
                editPresenter.prepareFailView("The edited image is the same as before");
            }


        }
    }
}
