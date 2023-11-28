package entity.recipe;

import entity.user.User;
import entity.user.UserFactory;

import java.time.LocalDateTime;

public class UserRecipeFactory implements RecipeFactory {


    public UserRecipe create(String name, String ingredients, String nutrition,
                         String instructions, String image, String recipeurl,
                         Integer recipeID, User user) {
        return new UserRecipe(name, ingredients, nutrition,
                instructions, image,recipeurl,recipeID, user);
    }

    @Override
    public Recipe create(String name, String ingredients, String nutrition, String instructions, String image, String recipeurl, Integer recipeID) {
        return null;
    }
}
