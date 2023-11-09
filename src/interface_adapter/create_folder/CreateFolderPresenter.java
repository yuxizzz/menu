package interface_adapter.create_folder;

import interface_adapter.ViewManagerModel;
import use_case.create_folder.CreateFolderOutputBoundary;
import use_case.create_folder.CreateFolderOutputData;

public class CreateFolderPresenter implements CreateFolderOutputBoundary {
    private final CreateFolderViewModel createFolderViewModel;
    private ViewManagerModel viewManagerModel;

    public CreateFolderPresenter(CreateFolderViewModel createFolderViewModel, ViewManagerModel viewManagerModel) {
        this.createFolderViewModel = createFolderViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(CreateFolderOutputData folder) {
        CreateFolderState createFolderState = createFolderViewModel.getState();
        createFolderState.setFoldername(folder.getFoldername());
        this.createFolderViewModel.setState(createFolderState);
        createFolderViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(createFolderViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        CreateFolderState createFolderState = createFolderViewModel.getState();
        createFolderState.setFoldernameError(error);
        createFolderViewModel.firePropertyChanged();
    }
}
