package use_case.delete_userRecipe;

import java.util.ArrayList;
import java.util.HashMap;

public class DeleteRecipeOutputData {
    private boolean deleteRecipeFailed;

    private String recipeDeleted;

    private Integer recipeID;

    private HashMap<Integer, ArrayList> recipeMap;

    //Need to be implemented or used if we need to output some information after delete.
    public DeleteRecipeOutputData(String recipeDeleted,  Integer recipeID, HashMap<Integer, ArrayList> recipeMap, boolean deleteRecipeFailed){
        this.recipeID = recipeID;
        this.deleteRecipeFailed = deleteRecipeFailed;
        this.recipeDeleted = recipeDeleted;
        this.recipeMap = recipeMap;

    }

    public String getRecipeDeleted(){
        return recipeDeleted;
    }

    public Integer getRecipeID(){
        return recipeID;
    }

    public HashMap<Integer, ArrayList> getRecipeMap(){return recipeMap;}
}
