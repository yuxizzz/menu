package interface_adapter.edit_recipe;

import interface_adapter.logged_in.LoggedInState;

public class EditRecipeState {
    private String username = "";

    public EditRecipeState(EditRecipeState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public EditRecipeState() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
