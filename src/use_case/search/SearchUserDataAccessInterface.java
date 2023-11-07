package use_case.search;

import entity.AllResults;
import entity.CommonRecipe;
import entity.SearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface SearchUserDataAccessInterface {
    boolean existsTags(String identifier);
    //to confirm if allergy is valid
    //if not，give it to presenter & prepareFailview

    boolean existsIngredients(String identifier);
    //same as above

    AllResults getOutputRecipes(String ingredients, String allergy) throws IOException;

    //give the list of recipes to presenter and prepareSuccessView
    // -> show recipes to SearchedView
}
