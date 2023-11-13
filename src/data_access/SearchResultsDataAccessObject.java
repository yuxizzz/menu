package data_access;

import entity.search_results.SearchResult;
import use_case.search.SearchUserDataAccessInterface;

import java.io.IOException;
import java.util.HashMap;

import static api.Search.getRecipeList;

public class SearchResultsDataAccessObject implements SearchUserDataAccessInterface {

    @Override
    public boolean existsIngredients(String ingredient, String tags) throws IOException {
        if (getRecipeList(ingredient, tags).isEmpty()) {
            return false;
        } else {return true;}
    }

    @Override
    public HashMap<Object, SearchResult> getOutputRecipes(String ingredients, String tags) throws IOException {
        return getRecipeList(ingredients, tags);
    }

}

