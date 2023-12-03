package interface_adapter.delete_folder;
import interface_adapter.ViewManagerModel;
import use_case.delete_folder.DeleteFolderOutputBoundary;
import use_case.delete_folder.DeleteFolderOutputData;

public class DeleteFolderPresenter implements DeleteFolderOutputBoundary {
    private final DeleteFolderViewModel deleteFolderViewModel;
    private ViewManagerModel viewManagerModel;

    public DeleteFolderPresenter(ViewManagerModel viewManagerModel,
                                 DeleteFolderViewModel deleteFolderViewModel){
        this.deleteFolderViewModel = deleteFolderViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DeleteFolderOutputData response) {
        DeleteFolderState deleteFolderState = deleteFolderViewModel.getState();
        deleteFolderState.setFolderDeleted(response.getFolderDeleted());
        this.deleteFolderViewModel.setState(deleteFolderState);
        deleteFolderViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(deleteFolderViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
