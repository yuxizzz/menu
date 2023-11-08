package entity.recipe;

import java.util.List;
import java.util.Map;

public interface RecipeFactory {
    Recipe creat(String name, String ingredients, String nutrition, String instructions,
                 String image, String recipeurl, Integer recipeid);
}
