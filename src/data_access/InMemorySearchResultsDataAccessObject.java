package data_access;

import use_case.search.SearchUserDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class InMemorySearchResultsDataAccessObject implements SearchUserDataAccessInterface {
    @Override
    public boolean existsIngredients(String ingredient, String tags) throws IOException {
        return false;
    }

    @Override
    public HashMap<Integer, ArrayList> getOutputRecipes(String ingredients, String allergy) throws IOException {
        return null;
    }
}
