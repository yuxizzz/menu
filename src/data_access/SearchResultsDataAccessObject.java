package data_access;

import entity.SearchResult;
import use_case.search.SearchUserDataAccessInterface;

import java.io.IOException;
import java.util.HashMap;

import static api.Search.getRecipeList;

public class SearchResultsDataAccessObject implements SearchUserDataAccessInterface {

    @Override
    public boolean existsTags(String identifier) throws IOException {
        getRecipeList("egg", identifier);
        return false;
    }

    @Override
    public boolean existsIngredients(String identifier) throws IOException {
        getRecipeList(identifier, "gluten");
        return false;
    }

    @Override
    public HashMap<Object, SearchResult> getOutputRecipes(String ingredients, String tags) throws IOException {
        return getRecipeList(ingredients, tags);
    }

}

