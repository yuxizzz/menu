package use_case.collect_recipe;



import java.util.ArrayList;

public class CollectRecipeInteractor implements CollectRecipeInputBoundary {
    final CollectRecipeDataAccessInterface recipeDataAccessObject;
    final CollectRecipeOutputBoundary userPresenter;

    public CollectRecipeInteractor(CollectRecipeDataAccessInterface collectRecipeDataAccessInterface,
                                   CollectRecipeOutputBoundary collectRecipeOutputBoundary) {
        this.recipeDataAccessObject = collectRecipeDataAccessInterface;
        this.userPresenter = collectRecipeOutputBoundary;
    }
    @Override
    public void execute(CollectRecipeInputData collectRecipeInputData) {
//        if (recipeDataAccessObject.existsAllFolders(collectRecipeInputData.getRecipeID())) {
//            userPresenter.prepareFailView("Recipe already existed in all folders");
//        } else {
            ArrayList<String> foldernames= recipeDataAccessObject.getAllFolders(collectRecipeInputData.getUsername());
            CollectRecipeOutputData collectRecipeOutputData = new CollectRecipeOutputData(foldernames, collectRecipeInputData.getRecipeID(),collectRecipeInputData.getUsername());
            userPresenter.prepareSuccessView(collectRecipeOutputData);
        }

    }
