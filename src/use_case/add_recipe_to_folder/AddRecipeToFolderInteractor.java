package use_case.add_recipe_to_folder;


public class AddRecipeToFolderInteractor implements AddRecipeToFolderInputBoundary{

    final AddRecipeToFolderDataAccessInterface userDataAccessObject;
    final AddRecipeToFolderOutputBoundary userPresenter;

    public AddRecipeToFolderInteractor(AddRecipeToFolderDataAccessInterface addRecipeToFolderDataAccessObject,
                                       AddRecipeToFolderOutputBoundary addRecipeToFolderOutputBoundary) {
        this.userDataAccessObject = addRecipeToFolderDataAccessObject;
        this.userPresenter =  addRecipeToFolderOutputBoundary;
    }
    @Override
    public void execute(AddRecipeToFolderInputData addRecipeToFolderInputData) {
        String message = userDataAccessObject.addRecipeToFolder(addRecipeToFolderInputData.getFolderName(),
                addRecipeToFolderInputData.getRecipeID());
        AddRecipeToFolderOutputData addRecipeToFolderOutputData = new AddRecipeToFolderOutputData(message, false);
        userPresenter.prepareSuccessView(addRecipeToFolderOutputData);
    }
}
