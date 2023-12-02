package interface_adapter.searched;

import entity.recipe.Recipe;
import interface_adapter.edit_recipe.EditRecipeState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchedState {
    private String keywords = "";
    private String username = "";

    private

    // Because of the previous copy constructor, the default constructor must be explicit.
    SearchedState(SearchedState copy){
        keywords = copy.keywords;
        username = copy.username;}
    public SearchedState(){}

    public String getKeywords(){return keywords;}
    public void setKeywords(String keywords){this.keywords = keywords;}
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }


}
