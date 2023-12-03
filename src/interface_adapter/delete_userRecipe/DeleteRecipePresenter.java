package interface_adapter.delete_userRecipe;

import interface_adapter.ViewManagerModel;
import interface_adapter.default_opened_folder.DefaultOpenedFolderState;
import interface_adapter.default_opened_folder.DefaultOpenedFolderViewModel;
import use_case.delete_userRecipe.DeleteRecipeOutputBoundary;
import use_case.delete_userRecipe.DeleteRecipeOutputData;

public class DeleteRecipePresenter implements DeleteRecipeOutputBoundary {
    private final DeleteRecipeViewModel deleteRecipeViewModel;

    private final DefaultOpenedFolderViewModel defaultOpenedFolderViewModel;
    private ViewManagerModel viewManagerModel;

    public DeleteRecipePresenter(ViewManagerModel viewManagerModel,
                                 DeleteRecipeViewModel deleteRecipeViewModel, DefaultOpenedFolderViewModel defaultOpenedFolderViewModel) {
        this.deleteRecipeViewModel = deleteRecipeViewModel;
        this.viewManagerModel = viewManagerModel;
        this.defaultOpenedFolderViewModel = defaultOpenedFolderViewModel;
    }







    public void prepareSuccessView(DeleteRecipeOutputData response){
        //on success switch to defaultOpenedFolder View and delete the specific recipe






        DefaultOpenedFolderState defaultOpenedFolderState = defaultOpenedFolderViewModel.getState();
        defaultOpenedFolderState.setRecipeMap(response.getRecipeMap());

        this.defaultOpenedFolderViewModel.setState(defaultOpenedFolderState);
        defaultOpenedFolderViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(defaultOpenedFolderViewModel.getViewName());
        viewManagerModel.firePropertyChanged();



    }
    public void prepareFailView(String error){

        DeleteRecipeState deleteRecipeState = deleteRecipeViewModel.getState();

        deleteRecipeState.setMessageError(error);

        deleteRecipeViewModel.firePropertyChanged();


    }
}
