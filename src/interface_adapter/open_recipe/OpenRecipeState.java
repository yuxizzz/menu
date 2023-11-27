package interface_adapter.open_recipe;

import interface_adapter.edit_recipe.EditRecipeState;

public class OpenRecipeState {
    private String username = "";

    public OpenRecipeState(OpenRecipeState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public OpenRecipeState() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
