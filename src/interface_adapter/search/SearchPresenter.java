package interface_adapter.search;

import interface_adapter.ViewManagerModel;
import interface_adapter.searched.SearchedState;
import interface_adapter.searched.SearchedViewModel;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;

public class SearchPresenter implements SearchOutputBoundary {
    private final SearchViewModel searchViewModel;
    private final SearchedViewModel searchedViewModel;
    private ViewManagerModel viewManagerModel;
    public SearchPresenter(ViewManagerModel viewManagerModel,
                           SearchViewModel searchViewModel,
                           SearchedViewModel searchedViewModel){
        this.searchViewModel = searchViewModel;
        this.viewManagerModel = viewManagerModel;
        this.searchedViewModel = searchedViewModel;
    }


    @Override
    public void prepareSuccessView(SearchOutputData message) {
        //On success, switch to the interface_adapter.searched view.
        // TO DO:
        SearchedState searchedState = searchedViewModel.getState();
        this.searchedViewModel.setState(searchedState);
        searchViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(searchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

    public void prepareFailView(String error){
        SearchState searchState = searchViewModel.getState();
        searchState.setKeyWordsError(error);
        searchViewModel.firePropertyChanged();
    }
}

