package use_case.search;

import entity.SearchResult;

import java.io.IOException;
import java.util.HashMap;

public interface SearchUserDataAccessInterface {

    boolean existsIngredients(String ingredient, String tags) throws IOException;

    HashMap<Object, SearchResult> getOutputRecipes(String ingredients, String allergy) throws IOException;

    //give the list of recipes to presenter and prepareSuccessView
    // -> show recipes to SearchedView
}
