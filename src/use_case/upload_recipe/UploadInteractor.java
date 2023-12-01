package use_case.upload_recipe;

import entity.recipe.Recipe;
import entity.recipe.RecipeFactory;
import entity.recipe.UserRecipe;
import entity.recipe.UserRecipeFactory;

public class UploadInteractor implements UploadInputBoundary{

    final UploadDataAccessInterface recipeDataAccessObject;
    final UploadOuntputBoundary recipePresenter;
    final UserRecipeFactory userRecipeFactory;
    public UploadInteractor(UploadDataAccessInterface recipeDataAccessInterface,
                            UploadOuntputBoundary recipeOutputBoundary,
                            UserRecipeFactory userRecipeFactory) {
        this.recipeDataAccessObject = recipeDataAccessInterface;
        this.recipePresenter = recipeOutputBoundary;
        this.userRecipeFactory = userRecipeFactory;
    }







    @Override
    public void execute(UploadInputData uploadInputData) {
        if (recipeDataAccessObject.existByName(uploadInputData.getRecipename())){
            recipePresenter.prepareFailView("Recipe name already exists.");
        }else{

            UserRecipe userRecipe = userRecipeFactory.create(uploadInputData.getRecipename(),
                    uploadInputData.getIngredients(),
                    uploadInputData.getNutrition(), uploadInputData.getInstructions(),
                    uploadInputData.getImage(),
                    uploadInputData.getRecipeurl(), uploadInputData.getRecipeid(),
                    uploadInputData.getUser());
            recipeDataAccessObject.saveRecipe(userRecipe);
            UploadOutputData createOutputData = new UploadOutputData(userRecipe.getRecipeID(), false);
            recipePresenter.prepareSuccessView(createOutputData);

    }
}
}
