package interface_adapter.collect_recipe;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderState;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderViewModel;
import use_case.collect_recipe.CollectRecipeOutputBoundary;
import use_case.collect_recipe.CollectRecipeOutputData;

public class CollectRecipePresenter implements CollectRecipeOutputBoundary {
    private final CollectRecipeViewModel collectRecipeViewModel;
    private final AddRecipeToFolderViewModel addRecipeToFolderViewModel;
    private ViewManagerModel viewManagerModel;

    public CollectRecipePresenter(ViewManagerModel viewManagerModel, CollectRecipeViewModel collectRecipeViewModel, AddRecipeToFolderViewModel addRecipeToFolderViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.collectRecipeViewModel = collectRecipeViewModel;
        this.addRecipeToFolderViewModel = addRecipeToFolderViewModel;
    }

    @Override
    public void prepareSuccessView(CollectRecipeOutputData collectRecipeOutputData) {
        //On success, switch to folderOption View
        AddRecipeToFolderState addRecipeToFolderState = addRecipeToFolderViewModel.getState();
        addRecipeToFolderState.setFolderNames(collectRecipeOutputData.getFolders());
        addRecipeToFolderState.setRecipeID(collectRecipeOutputData.getRecipeID());
        addRecipeToFolderState.setUserID(collectRecipeOutputData.getUserID());
        this.addRecipeToFolderViewModel.setState(addRecipeToFolderState);
        addRecipeToFolderViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(addRecipeToFolderViewModel.getViewName());
        viewManagerModel.firePropertyChanged();


    }

    @Override
    public void prepareFailView(String error) {
        CollectRecipeState collectRecipeState = collectRecipeViewModel.getState();
        collectRecipeState.setNoFolderError(error);
        collectRecipeViewModel.firePropertyChanged();

    }
}
