package use_case.search;

import entity.AllResults;

import java.io.IOException;

public interface SearchUserDataAccessInterface {
    boolean existsTags(String identifier) throws IOException;
    //to confirm if allergy is valid
    //if not，give it to presenter & prepareFailview

    boolean existsIngredients(String identifier) throws IOException;
    //same as above

    AllResults getOutputRecipes(String ingredients, String allergy) throws IOException;

    //give the list of recipes to presenter and prepareSuccessView
    // -> show recipes to SearchedView
}
