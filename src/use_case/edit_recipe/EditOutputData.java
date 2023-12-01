package use_case.edit_recipe;

public class EditOutputData {

    private boolean useCaseFailed;

    private String recipeEdited;

    public EditOutputData(String recipeEdited, boolean useCaseFailed){



        this.useCaseFailed = useCaseFailed;



        this.recipeEdited = "Do you ensure to edit" + recipeEdited + "?";
    }


    public String getRecipeEdited() {
        return recipeEdited;
    }
}
