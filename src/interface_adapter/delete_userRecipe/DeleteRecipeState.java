package interface_adapter.delete_userRecipe;

import interface_adapter.logged_in.LoggedInState;

public class DeleteRecipeState {
    private String message = "";
    private String messageError = null;
    private String username = "";

    public DeleteRecipeState(DeleteRecipeState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.

    public DeleteRecipeState(){
    }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setMessageError(String error) {
            this.messageError = error;
        }
        public String getUsername() {
        return username;
    }
        public void setUsername(String username) {
        this.username = username;
    }
    }
