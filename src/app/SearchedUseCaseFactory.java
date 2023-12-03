package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import interface_adapter.get_recipe.GetRecipeController;
import interface_adapter.get_recipe.GetRecipePresenter;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchPresenter;
import interface_adapter.search.SearchViewModel;
import interface_adapter.searched.SearchedViewModel;
import use_case.get_recipe.GetRecipeDataAccessInterface;
import use_case.get_recipe.GetRecipeInputBoundary;
import use_case.get_recipe.GetRecipeInteractor;
import use_case.get_recipe.GetRecipeOutputBoundary;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchUserDataAccessInterface;
import view.SearchView;
import view.SearchedView;

public class SearchedUseCaseFactory {
    private SearchedUseCaseFactory() {}

    public static SearchedView create(ViewManagerModel viewManagerModel,
                                      GetRecipeViewModel getRecipeViewModel,
                                      SearchedViewModel searchedViewModel,
                                      GetRecipeDataAccessInterface recipeDataAccessObject,
                                      CollectRecipeViewModel collectRecipeViewModel) {

        GetRecipeController getRecipeController = createUserSearchedUseCase(viewManagerModel,
                getRecipeViewModel, collectRecipeViewModel, recipeDataAccessObject);
        return new SearchedView(searchedViewModel, getRecipeViewModel, getRecipeController);
    }

    private static GetRecipeController createUserSearchedUseCase(ViewManagerModel viewManagerModel,
                                                            GetRecipeViewModel getRecipeViewModel,
                                                            CollectRecipeViewModel collectRecipeViewModel,
                                                            GetRecipeDataAccessInterface recipeDataAccessObject) {
        GetRecipeOutputBoundary getRecipeOutputBoundary = new GetRecipePresenter(getRecipeViewModel,
                collectRecipeViewModel, viewManagerModel);

        GetRecipeInputBoundary getRecipeInteractor = new GetRecipeInteractor(recipeDataAccessObject,
                getRecipeOutputBoundary);

        return new GetRecipeController(getRecipeInteractor);
    }
}
