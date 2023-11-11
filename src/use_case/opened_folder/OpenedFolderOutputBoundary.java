package use_case.opened_folder;


public interface OpenedFolderOutputBoundary {
    void prepareSuccessView(OpenedFolderOutputData recipe);

    void prepareFailView(String error);
}
