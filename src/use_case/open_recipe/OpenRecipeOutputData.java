package use_case.open_recipe;




import java.io.IOException;

public class OpenRecipeOutputData {

    private String recipename = "";
    private Integer recipeID;
    private boolean useCaseFailed;


    private String username;

    private String ingredients = "";
    private String nutrition = "";
    private String instructions = "";
    private String image = "";
    private String recipeurl = "";

    private String foldername;

    public OpenRecipeOutputData(Integer recipeID,
                                boolean useCaseFailed, String ingredients,
                                String nutrition, String instructions,
                                String image, String username,
                                 String foldername) throws IOException {


        this.useCaseFailed = useCaseFailed;


        this.ingredients = ingredients;
        this.nutrition = nutrition;
        this.instructions = instructions;
        this.image = image;
        this.recipeurl = recipeurl;


        this.recipeID = recipeID;
        this.username = username;
        this.foldername = foldername;

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


    public Integer getRecipeID() {

        return recipeID;
    }



    public String getUsername() {
        return username;
    }


    public String getFoldername(){
        return foldername;
    }
}
