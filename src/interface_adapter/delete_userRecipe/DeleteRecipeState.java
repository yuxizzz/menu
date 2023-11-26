package interface_adapter.delete_userRecipe;

public class DeleteRecipeState {
    private String message = "";
    private String messageError = null;
    public DeleteRecipeState(){
    }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setMessageError(String error) {
            this.messageError = error;
        }
    }
