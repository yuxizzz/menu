package use_case.open_recipe;

public class OpenRecipeInputData {
    private final Integer recipeID;

    public OpenRecipeInputData(Integer recipeID) {
        this.recipeID = recipeID;
    }

    Integer getRecipeID() {
        return recipeID;
    }
}
