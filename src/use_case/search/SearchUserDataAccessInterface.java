package use_case.search;

public interface SearchUserDataAccessInterface {
    boolean existsIntolerance(String identifier);
    //to confirm if allergy is valid
    //if not，give it to presenter & prepareFailview

    boolean existsIngredients(String identifier);
    //same as above

    ArrayList<Recipe> getOutputRecipes(String ingredients, String allergy);
    //give the list of recipes to presenter and prepareSuccessView
    // -> show recipes to SearchedView
}
