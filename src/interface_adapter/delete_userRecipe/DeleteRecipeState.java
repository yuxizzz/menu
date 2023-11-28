package interface_adapter.delete_userRecipe;

public class DeleteRecipeState {
    private String message = "";
    private String messageError = null;

    private String recipe = null;
    public DeleteRecipeState(){
    }

    public void setMessage(String message) {

        this.message = message;
        }


    public void setMessageError(String error) {

        this.messageError = error;
        }

    public void setRecipeDeleted(String recipeDeleted) {

        this.recipe = recipeDeleted;
    }

    public String getRecipeDeleted(){
        return this.recipe;}
}
