package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonRecipe implements Recipe {
    private String name;
    private String ingredients;
    private String nutrition;
    private String instructions;
    private List<String> tag;
    private Map<String, Boolean> allergy;

    public CommonRecipe(String name, String ingredients, String nutrition, String instructions, List<String> tag) {
        this.name = name;
        this.ingredients = ingredients;
        this.nutrition = nutrition;
        this.instructions = instructions;
        this.tag = tag;
        Map<String, Boolean> allergy = new HashMap<>();
        String[] lla = {"Eggs", "Milk", "Mustard", "Peanut", "Crustacean", "Mollusc", "Fish", "Sesame", "Soy",
                "Sulphites", "Sulfites", "Nut", "Wheat"};
        for (String s : lla) {
            if (ingredients.contains(s)) {
                allergy.put(s, true);
            } else {
                allergy.put(s, false);
            }
        }
        this.allergy = allergy;
    }

    public static RecipeBuilder builder() {
        return new RecipeBuilder();
    }

    public static class RecipeBuilder {
        private String name;
        private String ingredients;
        private String nutrition;
        private String instructions;
        private List<String> tag;
        private Map<String, Boolean> allergy;

        RecipeBuilder() {
        }

        public RecipeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RecipeBuilder ingredients(String ingredients) {
            this.ingredients = ingredients;
            Map<String, Boolean> allergy = new HashMap<>();
            String[] lla = {"Eggs", "Milk", "Mustard", "Peanut", "Crustacean", "Mollusc", "Fish", "Sesame", "Soy",
                    "Sulphites", "Sulfites", "Nut", "Wheat"};
            for (String s : lla) {
                if (ingredients.contains(s)) {
                    allergy.put(s, true);
                } else {
                    allergy.put(s, false);
                }
            }
            this.allergy = allergy;
            return this;
        }

        public RecipeBuilder nutrition(String nutrition) {
            this.nutrition = nutrition;
            return this;
        }

        public RecipeBuilder instructions(String instructions) {
            this.instructions = instructions;
            return this;
        }

        public RecipeBuilder tag(List<String> tag) {
            this.tag = tag;
            return this;
        }


        public Recipe build() {
            return new CommonRecipe(name, ingredients, nutrition, instructions, tag);
        }
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", nutrition=" + nutrition + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getNutrition() {
        return nutrition;
    }

    public String getInstructions() {
        return instructions;
    }

    public List<String> getTag() {
        return tag;
    }

    public Map<String, Boolean> getAllergy() {
        return allergy;
    }
}
