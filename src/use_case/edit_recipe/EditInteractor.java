package use_case.edit_recipe;

public class EditInteractor implements EditInputBoundary{

    final EditDataAccessInterface removeDataAccessObject;
    final EditOuntputBoundary removePresenter;
    public EditInteractor(EditDataAccessInterface removeDataAccessInterface, EditOuntputBoundary removeOutputBoundary) {
        this.removeDataAccessObject = removeDataAccessInterface;
        this.removePresenter = removeOutputBoundary;
    }

    @Override
    public void execute(EditInputData removeInputData) {

        String removedRecipe = removeDataAccessObject.editRecipe();
        EditOutputData removeOutputData = new EditOutputData(removedRecipe, false);
        removePresenter.prepareSuccessView(removeOutputData);

    }
}
