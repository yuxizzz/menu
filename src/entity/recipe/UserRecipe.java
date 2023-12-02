package entity.recipe;

import entity.user.User;

public class UserRecipe extends CommonRecipe {
    private final String username;
    public UserRecipe(String name, String ingredients, String nutrition, String instructions,
                      String image, String recipeurl, Integer recipeid, String username) {
        super(name, ingredients, nutrition, instructions, image, recipeurl, recipeid);
        this.username = username;
    }


    public String editName(String edit, UserRecipe userRecipe, String username){
        if (userRecipe.username == username){
            userRecipe.name = edit;
            return "Edit Successfully";
        } else {
            return "Fail to Edit";
        }
    }

    public String editIngredients(String edit, UserRecipe userRecipe, String username){
        if (userRecipe.username == username){
            userRecipe.ingredients = edit;
            return "Edit Successfully";
        } else {
            return "Fail to Edit";
        }
    }

    public String editNutrition(String edit, UserRecipe userRecipe, String username){
        if (userRecipe.username == username){
            userRecipe.nutrition = edit;
            return "Edit Successfully";
        } else {
            return "Fail to Edit";
        }
    }
    public String editInstructions(String edit, UserRecipe userRecipe, String username){
        if (userRecipe.username == username){
            userRecipe.instructions = edit;
            return "Edit Successfully";
        } else {
            return "Fail to Edit";
        }
    }


    public String editRecipeID(Integer edit, UserRecipe userRecipe, String username){
        if (userRecipe.username == username){
            userRecipe.recipeid = edit;
            return "Edit Successfully";
        } else {
            return "Fail to Edit";
        }
    }


    public String editRecipeURL(String edit, UserRecipe userRecipe, String username){
        if (userRecipe.username == username){
            userRecipe.recipeurl = edit;
            return "Edit Successfully";
        } else {
            return "Fail to Edit";
        }
    }

    public String editImage(String edit, UserRecipe userRecipe, String username){
        if (userRecipe.username == username){
            userRecipe.image = edit;
            return "Edit Successfully";
        } else {
            return "Fail to Edit";
        }
    }

    public String getUsername(){
        return this.username;
    }

//    public RecipeUser uploadRecipe(String name, String ingredients, String nutrition, String instructions, List<String> tag,
//                               Map<String, Boolean> allergy, int userID, String password){
//        return new RecipeUser(name, ingredients, nutrition, instructions, tag, allergy, userID, password);
//    }
}
