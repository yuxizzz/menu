package interface_adapter.search;

import use_case.search.SearchInputBoundary;
import use_case.search.SearchInputData;

public class SearchController {
    final SearchInputBoundary userSearchUseCaseInteractor;
    public SearchController(SearchInputBoundary userSearchUseCaseInteractor) {
        this.userSearchUseCaseInteractor = userSearchUseCaseInteractor;
    }

    public void execute(String ingredients, String allergy) {
        SearchInputData searchInputData = new SearchInputData(ingredients, allergy);
        userSearchUseCaseInteractor.execute(searchInputData);
    }
}
