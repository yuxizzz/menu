package interface_adapter.open_recipe;


public class OpenRecipeState {


    private String recipename = "";

    private String recipenameError = null;

    private Integer recipeID = null;

    private String recipeIDError = null;

    private String username = "";

    private String foldername = "";


    public OpenRecipeState(OpenRecipeState copy) {

        recipename = copy.recipename;

        recipenameError = copy.recipenameError;

        recipeID = copy.recipeID;

        recipeIDError = copy.recipeIDError;

        username = copy.username;

        foldername = copy.foldername;

    }


    // Because of the previous copy constructor, the default constructor must be explicit.
    public OpenRecipeState() {}

    public String getRecipename(){
        return recipename;
    }
    public void setRecipename(String recipename){
        this.recipename = recipename;
    }

    public String getRecipenameError(){
        return recipenameError;
    }

    public Integer getRecipeID(){
        return recipeID;
    }

    public void setRecipeID(Integer recipeID){
        this.recipeID = recipeID;

    }


    public String getRecipeIDError(){
        return recipeIDError;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username){this.username = username;}




    public String getFoldername() {
        return foldername;
    }

    public void setFoldername(String foldername) {
        this.foldername = foldername;
    }





    public void setRecipenameError(String recipenameError){
        this.recipenameError = recipenameError;
    }



    public void setRecipeIDError(String recipeIDError){
        this.recipeIDError = recipeIDError;
    }

}











