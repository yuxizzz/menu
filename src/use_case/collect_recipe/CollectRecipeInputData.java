package use_case.collect_recipe;

public class CollectRecipeInputData {
    final private Integer recipeID;
    final private String username;
    public CollectRecipeInputData(Integer recipeID, String username) {
        this.recipeID = recipeID;
        this.username = username;
    }
    Integer getRecipeID() {
        return recipeID;
    }

    String getUsername() {
        return username;
    }
}
