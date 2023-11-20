package entity.recipe;

public interface RecipeFactory {
    Recipe create(String name, String ingredients, String nutrition, String instructions,
                 String image, String recipeurl, String recipeID);
}
