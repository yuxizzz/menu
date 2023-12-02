package use_case.upload_recipe;

import entity.recipe.Recipe;
import entity.recipe.RecipeFactory;
import entity.recipe.UserRecipe;
import entity.recipe.UserRecipeFactory;

public class UploadInteractor implements UploadInputBoundary{

    final UploadDataAccessInterface recipeDataAccessObject;
    final UploadOutputBoundary recipePresenter;
    final UserRecipeFactory userRecipeFactory;
    public UploadInteractor(UploadDataAccessInterface recipeDataAccessInterface,
                            UploadOutputBoundary recipeOutputBoundary,
                            UserRecipeFactory userRecipeFactory) {
        this.recipeDataAccessObject = recipeDataAccessInterface;
        this.recipePresenter = recipeOutputBoundary;
        this.userRecipeFactory = userRecipeFactory;
    }







    @Override
    public void execute(UploadInputData uploadInputData) {
        if (recipeDataAccessObject.existByReicipeID(uploadInputData.getRecipeid(),
                uploadInputData.getUsername())){
            recipePresenter.prepareFailView("Recipe ID already exists.");
        }else{
            UserRecipe userRecipe = userRecipeFactory.create(uploadInputData.getRecipename(),
                    uploadInputData.getIngredients(),
                    uploadInputData.getNutrition(), uploadInputData.getInstructions(),
                    uploadInputData.getImage(),
                    uploadInputData.getRecipeurl(), uploadInputData.getRecipeid(),
                    uploadInputData.getUsername());
            Integer recipeID = uploadInputData.getRecipeid();
            String username = uploadInputData.getUsername();
            recipeDataAccessObject.saveRecipe(recipeID, userRecipe, username);
            UploadOutputData createOutputData = new UploadOutputData(userRecipe.getRecipeID(), false);
            recipePresenter.prepareSuccessView(createOutputData);

    }
}
}
