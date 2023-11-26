package use_case.collect_recipe;

public class CollectRecipeInputData {
    final private String recipeID;
    final private int userID;
    public CollectRecipeInputData(String recipeID, int userID) {
        this.recipeID = recipeID;
        this.userID = userID;
    }

    String getRecipeID() {
        return recipeID;
    }

    int getUserID() {
        return userID;
    }
}
