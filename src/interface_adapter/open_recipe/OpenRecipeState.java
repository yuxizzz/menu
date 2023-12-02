package interface_adapter.open_recipe;


public class OpenRecipeState {


    private String recipename = "";

    private String recipenameError = null;

    private Integer recipeID = null;

    private String recipeIDError = null;

    private String username;
    private String ingredients = "";
    private String nutrition = "";
    private String instructions = "";
    private String image = "";
    private String recipeurl = "";


    public OpenRecipeState(OpenRecipeState copy) {
        recipename = copy.recipename;
        recipenameError = copy.recipenameError;
        recipeID = copy.recipeID;
        recipeIDError = copy.recipeIDError;
        username = copy.username;
        ingredients = copy.ingredients;
        nutrition = copy.nutrition;
        instructions = copy.instructions;
        image = copy.image;
        recipeurl = copy.recipeurl;
    }


    // Because of the previous copy constructor, the default constructor must be explicit.
    public OpenRecipeState() {}

    public String getRecipename(){
        return recipename;
    }

    public String getRecipenameError(){
        return recipenameError;
    }

    public Integer getRecipeID(){
        return recipeID;
    }


    public String getRecipeIDError(){
        return recipeIDError;
    }

    public String getUsername() {
        return username;
    }

    public void setRecipename(String recipename){
        this.recipename = recipename;
    }

    public void setRecipenameError(String recipenameError){
        this.recipenameError = recipenameError;
    }

    public void setRecipeID(Integer recipeID){
        this.recipeID = recipeID;

    }

    public void setRecipeIDError(String recipeIDError){
        this.recipeIDError = recipeIDError;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * set-recipe and get-recipe
     */
    public void setRecipeurl(String recipeurl) {
        this.recipeurl = recipeurl;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public String getRecipeurl() {
        return recipeurl;
    }
    public String getImage() {
        return image;
    }
    public String getIngredients() {
        return ingredients;
    }
    public String getInstructions() {
        return instructions;
    }
    public String getNutrition() {
        return nutrition;
    }
}











