package entity.recipe;

public interface RecipeFactory {
    static Recipe create(String name, String ingredients, String nutrition, String instructions,
                         String image, String recipeurl, Integer recipeID) {
        return null;
    }
}
