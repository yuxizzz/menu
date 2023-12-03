package interface_adapter.add_recipe_to_folder;
import interface_adapter.ViewManagerModel;
import interface_adapter.collect_recipe.CollectRecipeState;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import use_case.add_recipe_to_folder.AddRecipeToFolderOutputBoundary;
import use_case.add_recipe_to_folder.AddRecipeToFolderOutputData;

public class AddRecipeToFolderPresenter implements AddRecipeToFolderOutputBoundary {
    private final AddRecipeToFolderViewModel addRecipeToFolderViewModel;
    private final CollectRecipeViewModel collectRecipeViewModel;
    private ViewManagerModel viewManagerModel;

    public AddRecipeToFolderPresenter(ViewManagerModel viewManagerModel,
                                      AddRecipeToFolderViewModel addRecipeToFolderViewModel,
                                      CollectRecipeViewModel collectRecipeViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addRecipeToFolderViewModel = addRecipeToFolderViewModel;
        this.collectRecipeViewModel = collectRecipeViewModel;
    }
    @Override
    public void prepareSuccessView(AddRecipeToFolderOutputData response) {
        // On success switch to reicpeView
        CollectRecipeState collectRecipeState = collectRecipeViewModel.getState();
        collectRecipeState.setMessage(response.getMessage());
        this.collectRecipeViewModel.setState(collectRecipeState);
        collectRecipeViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(collectRecipeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String recipeAlreadyExisted) {
        AddRecipeToFolderState addRecipeToFolderState = addRecipeToFolderViewModel.getState();
        addRecipeToFolderState.setMessageError(recipeAlreadyExisted);
        this.addRecipeToFolderViewModel.setState(addRecipeToFolderState);
        addRecipeToFolderViewModel.firePropertyChanged();
    }
}
