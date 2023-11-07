package entity;

import java.util.List;
import java.util.Map;

public class RecipeData extends CommonRecipe {
    public RecipeData(String name, String ingredients, String nutrition, String instructions, List<String> tag) {
        super(name, ingredients, nutrition, instructions, tag);
    }
//    public RecipeData(String name, String ingredients, String nutrition, String instructions, List<String> tag, Map<String, Boolean> allergy) {
//        super(name, ingredients, nutrition, instructions, tag, allergy);
    }

