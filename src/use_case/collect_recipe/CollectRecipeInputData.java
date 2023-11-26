package use_case.collect_recipe;

public class CollectRecipeInputData {
    final private Integer recipeID;
    final private Integer userID;
    public CollectRecipeInputData(Integer recipeID, Integer userID) {
        this.recipeID = recipeID;
        this.userID = userID;
    }
    Integer getRecipeID() {
        return recipeID;
    }

    int getUserID() {
        return userID;
    }
}
