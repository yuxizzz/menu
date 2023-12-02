package app;

import entity.recipe.CommonRecipeFactory;
import entity.recipe.RecipeFactory;
import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.logout.LogoutViewModel;
import interface_adapter.my_folder.MyFolderController;
import interface_adapter.my_folder.MyFolderPresenter;
import interface_adapter.my_folder.MyFolderViewModel;
import interface_adapter.open_folder.OpenFolderViewModel;
import interface_adapter.open_recipe.OpenRecipeController;
import interface_adapter.open_recipe.OpenRecipePresenter;
import interface_adapter.open_recipe.OpenRecipeViewModel;
import interface_adapter.opened_folder.OpenedFolderViewModel;
import interface_adapter.remove_recipe.RemoveController;
import interface_adapter.remove_recipe.RemovePresenter;
import interface_adapter.remove_recipe.RemoveViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchPresenter;
import interface_adapter.search.SearchViewModel;
import interface_adapter.searched.SearchedViewModel;
import use_case.logout.LogoutDataAccessInterface;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.my_folder.MyFolderDataAccessInterface;
import use_case.my_folder.MyFolderInputBoundary;
import use_case.my_folder.MyFolderInteractor;
import use_case.my_folder.MyFolderOutputBoundary;
import use_case.open_recipe.OpenRecipeDataAccessInterface;
import use_case.open_recipe.OpenRecipeInputBoundary;
import use_case.open_recipe.OpenRecipeInteractor;
import use_case.open_recipe.OpenRecipeOutputBoundary;
import use_case.remove_recipe.RemoveFolderDataAccessInterface;
import use_case.remove_recipe.RemoveInputBoundary;
import use_case.remove_recipe.RemoveInteractor;
import use_case.remove_recipe.RemoveOutputBoundary;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchUserDataAccessInterface;
import view.LoggedInView;
import view.OpenedFolderView;

import javax.swing.*;
import java.io.IOException;

public class OpenedFolderUseCaseFactory {
    private OpenedFolderUseCaseFactory() {}

    public static OpenedFolderView create(
            ViewManagerModel viewManagerModel,
            OpenedFolderViewModel openedFolderViewModel,
            OpenFolderViewModel openFolderViewModel,
            OpenRecipeViewModel openRecipeViewModel,
            RemoveViewModel removeViewModel,
            RemoveFolderDataAccessInterface removeDataAccessObject,
            OpenRecipeDataAccessInterface openRecipeDataAccessObject) {

        try {
            RemoveController removeController = createRemoveUseCase(viewManagerModel,
                    openedFolderViewModel, removeViewModel, removeDataAccessObject);
            OpenRecipeController openRecipeController = createOpenRecipeUseCase(viewManagerModel,
                    openRecipeViewModel,openRecipeDataAccessObject);

            return new OpenedFolderView(openFolderViewModel, removeController,
                    openRecipeViewModel, openRecipeController,
                    removeViewModel);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static RemoveController createRemoveUseCase(ViewManagerModel viewManagerModel,
                                                        OpenedFolderViewModel openedFolderViewModel,
                                                        RemoveViewModel removeViewModel,
                                                        RemoveFolderDataAccessInterface removeDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        RemoveOutputBoundary removeOutputBoundary = new RemovePresenter(viewManagerModel,
                openedFolderViewModel, removeViewModel);

//        SearchResult searchResult = new SearchResult();
//        userFactory = new CommonUserFactory();

        RemoveInputBoundary removeInteractor = new RemoveInteractor(
                removeDataAccessObject, removeOutputBoundary);
        return new RemoveController(removeInteractor);
    }


    private static OpenRecipeController createOpenRecipeUseCase(
            ViewManagerModel viewManagerModel, OpenRecipeViewModel openRecipeViewModel,
            OpenRecipeDataAccessInterface openRecipeDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        OpenRecipeOutputBoundary openRecipeOutputBoundary = new OpenRecipePresenter(openRecipeViewModel,
                viewManagerModel);

        RecipeFactory recipeFactory = new CommonRecipeFactory();

        OpenRecipeInputBoundary openRecipeController = new OpenRecipeInteractor(
                openRecipeDataAccessObject, openRecipeOutputBoundary);

        return new OpenRecipeController(openRecipeController);
    }
}
