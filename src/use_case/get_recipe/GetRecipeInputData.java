package use_case.get_recipe;

public class GetRecipeInputData {
    final private Integer recipeID;

    public GetRecipeInputData(Integer recipeID) {
        this.recipeID = recipeID;
    }

    Integer getRecipeID() {
        return recipeID;
    }
}
