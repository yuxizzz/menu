package entity.recipe;

import entity.recipe.Recipe;

import java.util.List;

public interface RecipeFactory {
    Recipe creat(String name, String ingredients, String nutrition, String instructions, List<String> tag);
}
