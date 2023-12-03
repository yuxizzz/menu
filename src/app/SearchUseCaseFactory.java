package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchPresenter;
import interface_adapter.search.SearchViewModel;
import interface_adapter.searched.SearchedViewModel;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchUserDataAccessInterface;
import view.SearchView;


/**
 * search view
 */
public class SearchUseCaseFactory {
    private SearchUseCaseFactory() {}

    public static SearchView create(ViewManagerModel viewManagerModel,
                                    SearchViewModel searchViewModel,
                                    GetRecipeViewModel getRecipeViewModel,
                                    SearchedViewModel searchedViewModel,
                                    SearchUserDataAccessInterface userDataAccessObject) {

        SearchController searchController = createUserSearchUseCase(viewManagerModel,
                searchViewModel, getRecipeViewModel, searchedViewModel, userDataAccessObject);
        return new SearchView(searchViewModel, searchController);
    }

    private static SearchController createUserSearchUseCase(ViewManagerModel viewManagerModel,
                                                            SearchViewModel searchViewModel,
                                                            GetRecipeViewModel getRecipeViewModel,
                                                            SearchedViewModel searchedViewModel,
                                                            SearchUserDataAccessInterface userDataAccessObject) {
        SearchOutputBoundary searchOutputBoundary = new SearchPresenter(viewManagerModel, searchViewModel, searchedViewModel, getRecipeViewModel);

        SearchInputBoundary searchInteractor = new SearchInteractor(userDataAccessObject, searchOutputBoundary);

        return new SearchController(searchInteractor);
    }
}