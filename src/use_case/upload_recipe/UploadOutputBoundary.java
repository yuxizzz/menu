package use_case.upload_recipe;

public interface UploadOutputBoundary {
    void prepareSuccessView(UploadOutputData message);

    void prepareFailView(String error);
}
