package use_case.remove_recipe;

public class RemoveInteractor implements RemoveInputBoundary{

    final RemoveFolderDataAccessInterface removeDataAccessObject;
    final RemoveOuntputBoundary removePresenter;
    public RemoveInteractor(RemoveFolderDataAccessInterface removeDataAccessInterface, RemoveOuntputBoundary removeOutputBoundary) {
        this.removeDataAccessObject = removeDataAccessInterface;
        this.removePresenter = removeOutputBoundary;
    }

    @Override
    public void execute(RemoveInputData removeInputData) {

        String removedRecipe = removeDataAccessObject.removeRecipe();
        RemoveOutputData removeOutputData = new RemoveOutputData(removedRecipe, false);
        removePresenter.prepareSuccessView(removeOutputData);

    }
}
