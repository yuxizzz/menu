package entity.recipe;

public class CommonRecipeFactory implements RecipeFactory {



    @Override
    public Recipe create(String name, String ingredients, String nutrition,
                         String instructions, String image, String recipeurl, Integer recipeID) {
        return new CommonRecipe(name, ingredients, nutrition,
                instructions, image, recipeurl, recipeID);
    }
    public UserRecipe create(String name, String ingredients, String nutrition,
                         String instructions, String image, String recipeurl, Integer recipeID, String username) {
        return new UserRecipe(name, ingredients, nutrition,
                instructions, image, recipeurl, recipeID, username);
    }


}
