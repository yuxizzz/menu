package data_access;

import use_case.search.SearchUserDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class InMemorySearchResultsDataAccessObject implements SearchUserDataAccessInterface {
    @Override
    public boolean existsIngredients(String ingredient, String tags) throws IOException {
        if (Objects.equals(ingredient, "")) {
            return false;
        }
        return true;
    }

    @Override
    public HashMap<Integer, ArrayList> getOutputRecipes(String ingredients, String allergy) throws IOException {
        return null;
    }
}
