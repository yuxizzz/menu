package use_case.upload_recipe;

public class UploadInteractor implements UploadInputBoundary{

    final UploadDataAccessInterface removeDataAccessObject;
    final UploadOuntputBoundary removePresenter;
    public UploadInteractor(UploadDataAccessInterface removeDataAccessInterface, UploadOuntputBoundary removeOutputBoundary) {
        this.removeDataAccessObject = removeDataAccessInterface;
        this.removePresenter = removeOutputBoundary;
    }

    @Override
    public void execute(UploadInputData removeInputData) {

        String removedRecipe = removeDataAccessObject.removeRecipe();
        UploadOutputData removeOutputData = new UploadOutputData(removedRecipe, false);
        removePresenter.prepareSuccessView(removeOutputData);

    }
}
