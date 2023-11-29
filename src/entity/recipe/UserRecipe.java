package entity.recipe;

import entity.user.User;

public class UserRecipe extends CommonRecipe {
    private final User user;
    public UserRecipe(String name, String ingredients, String nutrition, String instructions,
                      String image, String recipeurl, Integer recipeid, User user) {
        super(name, ingredients, nutrition, instructions, image, recipeurl, recipeid);
        this.user = user;
    }


    public String editName(String edit, UserRecipe userRecipe, User user){
        if (userRecipe.user == user){
            userRecipe.name = edit;
            return "Edit Successfully";
        } else {
            return "Fail to Edit";
        }
    }

    public String editIngredients(String edit, UserRecipe userRecipe, User user){
        if (userRecipe.user == user){
            userRecipe.ingredients = edit;
            return "Edit Successfully";
        } else {
            return "Fail to Edit";
        }
    }

    public String editNutrition(String edit, UserRecipe userRecipe, User user){
        if (userRecipe.user == user){
            userRecipe.nutrition = edit;
            return "Edit Successfully";
        } else {
            return "Fail to Edit";
        }
    }
    public String editInstructions(String edit, UserRecipe userRecipe, User user){
        if (userRecipe.user == user){
            userRecipe.instructions = edit;
            return "Edit Successfully";
        } else {
            return "Fail to Edit";
        }
    }


    public String editRecipeID(Integer edit, UserRecipe userRecipe, User user){
        if (userRecipe.user == user){
            userRecipe.recipeid = edit;
            return "Edit Successfully";
        } else {
            return "Fail to Edit";
        }
    }


    public String editRecipeURL(String edit, UserRecipe userRecipe, User user){
        if (userRecipe.user == user){
            userRecipe.recipeurl = edit;
            return "Edit Successfully";
        } else {
            return "Fail to Edit";
        }
    }

    public String editImage(String edit, UserRecipe userRecipe, User user){
        if (userRecipe.user == user){
            userRecipe.image = edit;
            return "Edit Successfully";
        } else {
            return "Fail to Edit";
        }
    }

    public User getUser(){
        return this.user;
    }

//    public RecipeUser uploadRecipe(String name, String ingredients, String nutrition, String instructions, List<String> tag,
//                               Map<String, Boolean> allergy, int userID, String password){
//        return new RecipeUser(name, ingredients, nutrition, instructions, tag, allergy, userID, password);
//    }
}
