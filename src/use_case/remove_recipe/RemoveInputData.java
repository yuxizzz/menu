package use_case.remove_recipe;

public class RemoveInputData {

    final private Integer recipeID;
    public RemoveInputData(Integer recipeID){

        this.recipeID = recipeID;
    }

    Integer getRemovedRecipeID(){


        return recipeID;


    }
}
