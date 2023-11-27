package interface_adapter.remove_recipe;

import interface_adapter.edit_recipe.EditRecipeState;

public class RemoveState {

    private String removeMessage = "";
    private String removeMessageError = null;

    private String recipes = null;
    private String username = "";

    public RemoveState(RemoveState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.

    public RemoveState(){
    }
    public void setRemoveMessage(String removeMessage){this.removeMessage = removeMessage;}

    public void setRecipeRemoved(String recipeRemoved){this.recipes = recipeRemoved;}
    public String getRecipeRemoved() {return this.recipes;}
    public void setMessageError(String error){this.removeMessageError = error;}
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
