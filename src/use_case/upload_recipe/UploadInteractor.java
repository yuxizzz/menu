package use_case.upload_recipe;

import entity.recipe.Recipe;
import entity.recipe.RecipeFactory;

public class UploadInteractor implements UploadInputBoundary{

    final UploadDataAccessInterface recipeDataAccessObject;
    final UploadOuntputBoundary recipePresenter;
    final RecipeFactory recipeFactory;
    public UploadInteractor(UploadDataAccessInterface recipeDataAccessInterface, UploadOuntputBoundary recipeOutputBoundary, RecipeFactory recipeFactory) {
        this.recipeDataAccessObject = recipeDataAccessInterface;
        this.recipePresenter = recipeOutputBoundary;
        this.recipeFactory = recipeFactory;
    }

    @Override
    public void execute(UploadInputData uploadInputData) {
        if (recipeDataAccessObject.existByName(uploadInputData.getRecipename())){
            recipePresenter.prepareFailView("Recipe name already exists.");
        }else{
            Recipe recipe = recipeFactory.create(uploadInputData.getRecipename(), uploadInputData.getIngredients(),
                    uploadInputData.getNutrition(), uploadInputData.getInstructions(), uploadInputData.getImage(),
                    uploadInputData.getRecipeurl(), uploadInputData.getRecipeid());
            recipeDataAccessObject.saveRecipe(recipe);
            UploadOutputData createOutputData = new UploadOutputData(recipe.getRecipeID(), false);
            recipePresenter.prepareSuccessView(createOutputData);

    }
}
}
