package use_case.delete_folder;


public class DeleteFolderInteractor implements DeleteFolderInputBoundary {
    final DeleteFolderUserDataAccessInterface deleteFolderUserDataAccessObject;
    final DeleteFolderOutputBoundary deleteFolderPresenter;

    public DeleteFolderInteractor(DeleteFolderOutputBoundary userDataAccessInterface, DeleteFolderOutputBoundary deleteFolderOutputBoundary) {
        this.deleteFolderUserDataAccessObject = userDataAccessInterface;
        this.deleteFolderPresenter = deleteFolderOutputBoundary;
    }

    @Override
    public void execute(DeleteFolderInputData deleteFolderInputData) {
        //TODO to be implemented
    }
}
