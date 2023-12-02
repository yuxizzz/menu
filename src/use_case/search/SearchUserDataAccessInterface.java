package use_case.search;

import entity.search_results.SearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface SearchUserDataAccessInterface {

    boolean existsIngredients(String ingredient, String tags) throws IOException;



    HashMap<Integer, ArrayList> getOutputRecipes(String ingredients, String allergy) throws IOException;



    //give the list of recipes to presenter and prepareSuccessView
    // -> show recipes to SearchedView
}
