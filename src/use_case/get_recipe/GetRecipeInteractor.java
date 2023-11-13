package use_case.get_recipe;

import entity.folder.Folder;
import use_case.create_folder.CreateFolderOutputData;

public class GetRecipeInteractor implements GetRecipeInputBoundary {
    final GetRecipeDataAccessInterface recipeDataAccessObject;
    final GetRecipeOutputBoundary recipePresenter;

    public GetRecipeInteractor(GetRecipeDataAccessInterface recipeDataAccessObject, GetRecipeOutputBoundary recipePresenter) {
        this.recipeDataAccessObject = recipeDataAccessObject;
        this.recipePresenter = recipePresenter;
    }

    @Override
    public void execute(GetRecipeInputData getRecipeInputData) {
//        if (!recipeDataAccessObject.existsByName(getRecipeInputData.getRecipeID())) {
//            recipePresenter.prepareFailView("Recipe not found.");
//        } else {
//            Folder folder = folderFactory.create(createFolderInputData.getFoldername());
//            folderDataAccessObject.save(folder);
//
//            CreateFolderOutputData createFolderOutputData = new CreateFolderOutputData(folder.getName(), false);
//            folderPresenter.prepareSuccessView(createFolderOutputData);
//        }
    }
}
