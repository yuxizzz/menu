package interface_adapter.upload_recipe;

import interface_adapter.ViewManagerModel;
import interface_adapter.create_folder.CreateFolderState;
import use_case.upload_recipe.UploadOuntputBoundary;
import use_case.upload_recipe.UploadOutputData;

public class UploadRecipePresenter implements UploadOuntputBoundary {
    private final UploadRecipeViewModel uploadRecipeViewModel;
    private ViewManagerModel viewManagerModel;

    public UploadRecipePresenter(UploadRecipeViewModel uploadRecipeViewModel, ViewManagerModel viewManagerModel) {
        this.uploadRecipeViewModel = uploadRecipeViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(UploadOutputData message) {
        UploadRecipeState uploadRecipeState = uploadRecipeViewModel.getState();
        uploadRecipeState.setRecipeID(message.getRecipeUploaded());
        this.uploadRecipeViewModel.setState(uploadRecipeState);
        uploadRecipeViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(uploadRecipeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();



    }

    @Override
    public void prepareFailView(String error) {
        UploadRecipeState uploadRecipeState = uploadRecipeViewModel.getState();
        uploadRecipeState.setRecipeIDError(error);
        uploadRecipeViewModel.firePropertyChanged();

    }
}
