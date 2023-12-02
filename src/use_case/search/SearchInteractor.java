package use_case.search;

import entity.search_results.SearchResult;

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
            HashMap<Integer, ArrayList> results = searchDataAccessObject.getOutputRecipes(searchInputData.getIngredients(),
                    searchInputData.getTags());

//            HashMap<String, ArrayList<String>> recipes = new HashMap<>();
//            for (ArrayList s: results.values()) {
//                ArrayList<String> response = new ArrayList<>();
//                response.add(s.getTitle());
//                response.add(s.getImage());
//                recipes.put(s.getRecipeid(), response);
//            }
            SearchOutputData searchOutputData = new SearchOutputData(results, false);
            searchPresenter.prepareSuccessView(searchOutputData);
        }
    }
}
