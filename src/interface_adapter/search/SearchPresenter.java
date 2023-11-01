package interface_adapter.search;

import interface_adapter.ViewManagerModel;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;

public class SearchPresenter implements SearchOutputBoundary {
    private final SearchViewModel searchViewModel;
    private ViewManagerModel viewManagerModel;
    public SearchPresenter(ViewManagerModel viewManagerModel,
                           SearchViewModel searchViewModel){
        this.searchViewModel = searchViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareSuccessView(SearchOutputData message) {
        SearchState searchState = searchViewModel.getState();
        //searchState.setUserDeleted(response.getUserDeleted()); ???
        this.searchViewModel.setState(searchState);
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

