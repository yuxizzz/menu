package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonRecipe implements Recipe {
    private String name;
    private String ingredients;
    private String nutrition;
    private String instructions;
    private String image;
    private String recipeurl;
    private Integer recipeid;

    public CommonRecipe(String name, String ingredients, String nutrition, String instructions,
                        String image, String recipeurl, Integer recipeid) {
        this.name = name;
        this.ingredients = ingredients;
        this.nutrition = nutrition;
        this.instructions = instructions;
        this.recipeid = recipeid;
        this.image = image;
        this.recipeurl = recipeurl;
    }

    public static RecipeBuilder builder() {
        return new RecipeBuilder();
    }

    public static class RecipeBuilder {
        private String name;
        private String ingredients;
        private String nutrition;
        private String instructions;
        private String image;
        private String recipeurl;
        private Integer recipeid;

        RecipeBuilder() {
        }

        public RecipeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RecipeBuilder ingredients(String ingredients) {
            this.ingredients = ingredients;
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

        public RecipeBuilder image(String image) {
            this.image = image;
            return this;
        }
        public RecipeBuilder recipeid(Integer recipeid) {
            this.recipeid = recipeid;
            return this;
        }

        public RecipeBuilder recipeurl(String recipeurl) {
            this.recipeurl = recipeurl;
            return this;
        }

        public Recipe build() {
            return new CommonRecipe(name, ingredients, nutrition, instructions, image, recipeurl, recipeid);
        }


    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", nutrition=" + nutrition + '\'' +
                ", instructions='" + instructions + '\'' +
                ", image='" + image + '\'' +
                ", recipeurl='" + recipeurl + '\'' +
                ", recipeid='" + recipeid + '\'' +
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
    public String getImage() {
        return image;
    }
    public Integer getRecipeID() {
        return recipeid;
    }
    public String getRecipeURL() {
        return recipeurl;
    }

}
