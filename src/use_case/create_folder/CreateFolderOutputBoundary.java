package use_case.create_folder;

public interface CreateFolderOutputBoundary {
    void prepareSuccessView(CreateFolderOutputData folder);
    void prepareFailView(String error);
}
