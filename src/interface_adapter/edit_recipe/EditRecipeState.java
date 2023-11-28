package interface_adapter.edit_recipe;

import interface_adapter.logged_in.LoggedInState;

public class EditRecipeState {



    private String username = "";

    private Integer recipeID = null;

    public EditRecipeState(EditRecipeState copy) {

        username = copy.username;
        recipeID = copy.recipeID;
    }


    // Because of the previous copy constructor, the default constructor must be explicit.
    public EditRecipeState() {}


    public Integer getRecipeID(){
        return recipeID;
    }

    public void setRecipeID(Integer recipeID){
        this.recipeID = recipeID;
    }

    public void setRecipeIDError(String error){

    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
