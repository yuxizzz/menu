package use_case.open_recipe;

import entity.recipe.Recipe;

import java.io.IOException;

public class OpenRecipeOutputData {
    private Integer recipeID;
    private boolean useCaseFailed;


    private String username;

    private String foldername;

    public OpenRecipeOutputData(Integer recipeID, boolean useCaseFailed, String username, String foldername) throws IOException {
//        this.recipeID = recipeID;


        this.useCaseFailed = useCaseFailed;


        this.recipeID = recipeID;
        this.username = username;
        this.foldername = foldername;
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
