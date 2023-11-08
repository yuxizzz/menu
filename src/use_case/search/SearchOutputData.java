package use_case.search;

import entity.SearchResult;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchOutputData {
    private boolean useCaseFailed;
    private HashMap<String, ArrayList<String>> searchedRecipes;

    public SearchOutputData(HashMap<String, ArrayList<String>> searchedRecipes, boolean useCaseFailed){
        this.useCaseFailed = useCaseFailed;
        this.searchedRecipes = searchedRecipes;
    }
    public HashMap<String, ArrayList<String>> getSearchedRecipes(){return searchedRecipes;}
}
