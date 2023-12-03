package use_case.remove_recipe;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveOutputData {

    private boolean useCaseFailed;

    private String removedRecipe;

    private Integer recipeID;

    private HashMap<Integer, ArrayList> recipeMap;

    public RemoveOutputData(String removedRecipe, Integer recipeID,
                            HashMap<Integer, ArrayList> recipeMap, boolean useCaseFailed ){
        this.useCaseFailed = useCaseFailed;
        this.removedRecipe = removedRecipe;
        this.recipeID = recipeID;

        this.recipeMap = recipeMap;
    }
    public String getRemovedRecipe() {
        return removedRecipe;
    }

    public Integer getRecipeID(){
        return recipeID;
    }

    public HashMap<Integer, ArrayList> getRecipeMap(){return recipeMap;}



}
