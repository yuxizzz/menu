package interface_adapter.remove_recipe;

public class RemoveState {

    private String removeMessage = "";
    private String removeMessageError = null;

    private String recipes = null;
    public RemoveState(){
    }
    public void setRemoveMessage(String removeMessage){this.removeMessage = removeMessage;}

    public void setRecipeRemoved(String recipeRemoved){this.recipes = recipeRemoved;}
    public String getRecipeRemoved() {return this.recipes;}
    public void setMessageError(String error){this.removeMessageError = error;}
}
