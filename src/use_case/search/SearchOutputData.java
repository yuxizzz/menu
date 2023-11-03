package use_case.search;

import java.util.ArrayList;

public class SearchOutputData {
    private boolean useCaseFailed;
    private String searchedRecipes;

    public SearchOutputData(ArrayList<String> searchedRecipes, boolean useCaseFailed){
        this.useCaseFailed = useCaseFailed;
        this.searchedRecipes = "";
        for (String s: searchedRecipes){
            this.searchedRecipes += s + "\n";
        }
    }
    public String getSearchedRecipes(){return searchedRecipes;}
}
