package use_case.opened_folder;


public interface OpenedFolderOutputBoundary {
    void prepareSuccessView(OpenedFolderOutputData folder);

    void prepareFailView(String error);
}
