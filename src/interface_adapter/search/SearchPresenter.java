package interface_adapter.search;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_recipe.GetRecipeState;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.searched.SearchedState;
import interface_adapter.searched.SearchedViewModel;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;

public class SearchPresenter implements SearchOutputBoundary {
    private final SearchViewModel searchViewModel;
    private final SearchedViewModel searchedViewModel;
    private final GetRecipeViewModel getRecipeViewModel;

    private  ViewManagerModel viewManagerModel;
    public SearchPresenter(ViewManagerModel viewManagerModel,
                           SearchViewModel searchViewModel,
                           SearchedViewModel searchedViewModel, GetRecipeViewModel getRecipeViewModel){
        this.searchViewModel = searchViewModel;
        this.viewManagerModel = viewManagerModel;
        this.searchedViewModel = searchedViewModel;
        this.getRecipeViewModel = getRecipeViewModel;
    }


    @Override
    public void prepareSuccessView(SearchOutputData message) {
        //On success, switch to the interface_adapter.searched view.


        SearchedState searchedState = searchedViewModel.getState();
        SearchState searchState = searchViewModel.getState();
        searchedState.setUsername(searchState.getUsername());
        GetRecipeState getRecipeState = getRecipeViewModel.getState();
        getRecipeState.setUsername(searchState.getUsername());

        searchedState.setResult(message.getSearchedRecipes());
//        System.out.println(message.getSearchedRecipes());
        this.searchedViewModel.setState(searchedState);
        searchedViewModel.firePropertyChanged();


        searchViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(searchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

    public void prepareFailView(String error){
        SearchState searchState = searchViewModel.getState();
        searchState.setIngredientsError(error);
        searchViewModel.firePropertyChanged();
    }
}

