package interface_adapter.delete_userRecipe;

import interface_adapter.ViewManagerModel;
import use_case.delete_userRecipe.DeleteRecipeOutputBoundary;
import use_case.delete_userRecipe.DeleteRecipeOutputData;

public class DeleteRecipePresenter implements DeleteRecipeOutputBoundary {
    private final DeleteRecipeViewModel deleteRecipeViewModel;
    private ViewManagerModel viewManagerModel;

    public DeleteRecipePresenter(ViewManagerModel viewManagerModel,
                                 DeleteRecipeViewModel deleteRecipeViewModel) {
        this.deleteRecipeViewModel = deleteRecipeViewModel;




        this.viewManagerModel = viewManagerModel;
    }







    public void prepareSuccessView(DeleteRecipeOutputData response){
        //on success keep in the same view and delete the specific recipe

        DeleteRecipeState deleteRecipeState = deleteRecipeViewModel.getState();



        deleteRecipeState.setRecipeDeleted(response.getRecipeDeleted());
    }
    public void prepareFailView(String error){




        DeleteRecipeState deleteRecipeState = deleteRecipeViewModel.getState();



        deleteRecipeState.setMessageError(error);



        deleteRecipeViewModel.firePropertyChanged();


    }
}
