package use_case.search;

import entity.SearchResult;

import java.util.ArrayList;

public class SearchOutputData {
    private boolean useCaseFailed;
    private ArrayList<SearchResult> searchedRecipes;

    public SearchOutputData(ArrayList<SearchResult> searchedRecipes, boolean useCaseFailed){
        this.useCaseFailed = useCaseFailed;
        this.searchedRecipes = searchedRecipes;
    }
    public ArrayList<SearchResult> getSearchedRecipes(){return searchedRecipes;}
}
