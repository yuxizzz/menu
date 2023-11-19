package interface_adapter.add_recipe_to_folder;
import interface_adapter.ViewManagerModel;
import use_case.add_recipe_to_folder.AddRecipeToFolderOutputBoundary;
import use_case.add_recipe_to_folder.AddRecipeToFolderOutputData;

public class AddRecipeToFolderPresenter implements AddRecipeToFolderOutputBoundary {
    private final AddRecipeToFolderViewModel addRecipeToFolderViewModel;
    private ViewManagerModel viewManagerModel;

    public AddRecipeToFolderPresenter(ViewManagerModel viewManagerModel,
                                      AddRecipeToFolderViewModel addRecipeToFolderViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addRecipeToFolderViewModel = addRecipeToFolderViewModel;
    }
    @Override
    public void prepareSuccessView(AddRecipeToFolderOutputData response) {
        AddRecipeToFolderState addRecipeToFolderState = addRecipeToFolderViewModel.getState();
        addRecipeToFolderState.setMessage(response.getMessage());
        this.addRecipeToFolderViewModel.setState(addRecipeToFolderState);
        addRecipeToFolderViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(addRecipeToFolderViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
