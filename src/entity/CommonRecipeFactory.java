package entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class CommonRecipeFactory {

    public Recipe create(String name, String ingredients, String nutrition, String instructions, List<String> tag, Map<String, Boolean> allergy) {
        return new CommonRecipe(name, ingredients, nutrition, instructions, tag, allergy);
    }
}

