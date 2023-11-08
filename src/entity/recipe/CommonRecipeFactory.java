package entity.recipe;

import java.util.List;

public class CommonRecipeFactory implements RecipeFactory {
    @Override
    public Recipe creat(String name, String ingredients, String nutrition, String instructions, List<String> tag) {
        return new CommonRecipe(name, ingredients, nutrition, instructions, tag);
    }
}

