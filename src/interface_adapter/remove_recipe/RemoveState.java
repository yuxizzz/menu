package interface_adapter.remove_recipe;


public class RemoveState {

    private String removeMessage = "";
    private String removeMessageError = null;

    private Integer recipeID = null;

    private String recipes = null;
    private String username = "";

    private String foldername = "";



    public RemoveState(){
    }
    public void setRemoveMessage(String removeMessage){
        this.removeMessage = removeMessage;
    }

    public void setRecipeRemoved(String recipeRemoved){
        this.recipes = recipeRemoved;
    }
    public String getRecipeRemoved() {
        return this.recipes;
    }

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

    public String getFoldername() {
        return foldername;
    }
    public void setFoldername(String username) {
        this.foldername = foldername;
    }

    public void setMessageError(String error){
        this.removeMessageError = error;
    }

}
