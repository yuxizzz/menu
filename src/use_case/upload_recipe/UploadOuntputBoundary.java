package use_case.upload_recipe;

public interface UploadOuntputBoundary {
    void prepareSuccessView(UploadOutputData message);

    void prepareFailView(String error);
}
