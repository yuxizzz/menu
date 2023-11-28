package use_case.edit_recipe;

import use_case.clear_users.ClearInputData;

public class EditInputData {

    final private Integer recipeID;
    public EditInputData(Integer recipeID){
        this.recipeID = recipeID;

    }

    Integer getRecipeID(){
        return recipeID;
    }
}
