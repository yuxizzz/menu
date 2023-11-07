package data_access;

import entity.AllResults;
import entity.SearchResult;
import use_case.search.SearchUserDataAccessInterface;

import java.io.IOException;
import java.util.HashMap;

import static api.Search.getRecipeList;

public class SearchResultsDataAccessObject implements SearchUserDataAccessInterface {
    private AllResults allResults;
    @Override
    public boolean existsIntolerance(String identifier) {
        return false;
    }

    @Override
    public boolean existsIngredients(String identifier) {
        return false;
    }

    @Override
    public AllResults getOutputRecipes(String ingredients, String tags) throws IOException {
        return getRecipeList(ingredients, tags);
    }

}

