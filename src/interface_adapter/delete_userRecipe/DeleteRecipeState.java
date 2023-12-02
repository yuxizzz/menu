package interface_adapter.delete_userRecipe;

public class DeleteRecipeState {
    private String message = "";
    private String messageError = null;

    private Integer recipeID = null;

    private String recipe = null;

    private String username = "";





    public DeleteRecipeState(){
    }

    public void setMessage(String message) {

        this.message = message;
        }




    public void setRecipeDeleted(String recipeDeleted) {

        this.recipe = recipeDeleted;
    }



    public String getRecipeDeleted(){
        return this.recipe;}


    public void setRecipeID(Integer recipeID){
        this.recipeID = recipeID;
    }


    public Integer getRecipeID(){
        return this.recipeID;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }



    public void setMessageError(String error) {

        this.messageError = error;
    }
}
