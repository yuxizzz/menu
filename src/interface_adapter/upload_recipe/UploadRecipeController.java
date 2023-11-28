package interface_adapter.upload_recipe;

import entity.user.User;
import use_case.upload_recipe.UploadInputBoundary;
import use_case.upload_recipe.UploadInputData;

public class UploadRecipeController {
    final UploadInputBoundary uploadRecipeUseCaseInteractor;

    public UploadRecipeController(UploadInputBoundary uploadRecipeUseCaseInteractor) {
        this.uploadRecipeUseCaseInteractor = uploadRecipeUseCaseInteractor;
    }
    public void execute(String recipename, String ingredients, String nutrition,
                        String instructions, String image,
                        String recipeurl, Integer recipeID, User user){
        UploadInputData uploadInputData = new UploadInputData(recipename,
                ingredients, nutrition,
                instructions, image, recipeurl, recipeID, user);
        uploadRecipeUseCaseInteractor.execute(uploadInputData);
    }
}
