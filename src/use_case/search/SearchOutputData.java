package use_case.search;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchOutputData {
    private boolean useCaseFailed;
    private HashMap<Integer, ArrayList> searchedRecipes;

    public SearchOutputData(HashMap<Integer, ArrayList> searchedRecipes, boolean useCaseFailed){
        this.useCaseFailed = useCaseFailed;
        this.searchedRecipes = searchedRecipes;
    }
    public HashMap<Integer, ArrayList> getSearchedRecipes(){return searchedRecipes;}
}
