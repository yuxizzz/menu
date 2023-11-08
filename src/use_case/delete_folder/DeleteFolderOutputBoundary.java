package use_case.delete_folder;

public interface DeleteFolderOutputBoundary {
    void prepareSuccessView(DeleteFolderOutputData message);

    void prepareFailView(String error);
}
