package use_case.collect_recipe;

public class CollectRecipeInputData {
    final private Integer recipeID;
    final private int userID;
    public CollectRecipeInputData(Integer recipeID, int userID) {
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
