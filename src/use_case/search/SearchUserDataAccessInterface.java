package use_case.search;

import entity.search_results.SearchResults;

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
