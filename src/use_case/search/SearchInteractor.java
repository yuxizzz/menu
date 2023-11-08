package use_case.search;

import entity.SearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SearchInteractor implements SearchInputBoundary {
    final SearchUserDataAccessInterface searchDataAccessObject;
    final SearchOutputBoundary searchPresenter;

    public SearchInteractor(SearchUserDataAccessInterface searchDataAccessInterface,
                            SearchOutputBoundary searchOutputBoundary) {
        this.searchDataAccessObject = searchDataAccessInterface;
        this.searchPresenter = searchOutputBoundary;
    }

    @Override
    public void execute(SearchInputData searchInputData) throws IOException {
        if (!searchDataAccessObject.existsIngredients(searchInputData.getIngredients(), searchInputData.getTags())) {
            searchPresenter.prepareFailView("Invalid ingredients");
        } else {
            HashMap<Object, SearchResult> results = searchDataAccessObject.getOutputRecipes(searchInputData.getIngredients(),
                    searchInputData.getTags());

            HashMap<String, ArrayList<String>> recipes = new HashMap<>();
            for (SearchResult s: results.values()) {
                ArrayList<String> response = new ArrayList<>();
                response.add(s.getTitle());
                response.add(s.getImage());
                recipes.put(s.getRecipeid(), response);
            }
            SearchOutputData searchOutputData = new SearchOutputData(recipes, false);
            searchPresenter.prepareSuccessView(searchOutputData);
        }
    }
}
