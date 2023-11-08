package use_case.search;

import entity.CommonSearchResults;
import entity.SearchResults;

import javax.xml.transform.Result;
import java.util.ArrayList;

public interface SearchUserDataAccessInterface {
    boolean existsIntolerance(String identifier);
    //to confirm if allergy is valid
    //if not，give it to presenter & prepareFailview

    boolean existsIngredients(String identifier);
    //same as above

    SearchResults getOutputRecipes(String ingredients, String allergy);
    //give the list of recipes to presenter and prepareSuccessView
    // -> show recipes to SearchedView
}
