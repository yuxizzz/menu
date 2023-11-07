package use_case.open_folder;


public interface OpenFolderOutputBoundary {
    void prepareSuccessView(OpenFolderOutputData folder);

    void prepareFailView(String error);
}
