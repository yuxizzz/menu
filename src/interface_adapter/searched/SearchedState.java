package interface_adapter.searched;

import interface_adapter.edit_recipe.EditRecipeState;

public class SearchedState {
    private String keywords = "";
    private String username = "";

    // Because of the previous copy constructor, the default constructor must be explicit.

    public SearchedState(SearchedState copy){
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
