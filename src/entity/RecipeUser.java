package entity;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RecipeUser extends CommonRecipe {
    public RecipeUser(String name, String ingredients, String nutrition, String instructions, List<String> tag) {
        super(name, ingredients, nutrition, instructions, tag);
    }

    // a multiset always starts empty, so we can directly instantiate our private attribute
    // here; no need to explicitly write a new constructor.

//    private final int userID;
//    private final String password;
//
//    public RecipeUser(String name, String ingredients, String nutrition, String instructions, List<String> tag,
//                      Map<String, Boolean> allergy, int userID, String password) {
//        super(name, ingredients, nutrition, instructions, tag, allergy);
//        this.userID = userID;
//        this.password = password;
//    }
//
//    public String editName(String edit, RecipeUser recipeUser, int userID, String password){
//        if (recipeUser.userID == userID && Objects.equals(recipeUser.password, password)){
//            recipeUser.name = edit;
//            return "Edit Successfully";
//        } else {
//            return "Fail to Edit";
//        }
//        }
//
//    public String editIngredients(String edit, RecipeUser recipeUser, int userID, String password){
//        if (recipeUser.userID == userID && Objects.equals(recipeUser.password, password)){
//            recipeUser.ingredients = edit;
//            return "Edit Successfully";
//        } else {
//            return "Fail to Edit";
//        }
//    }
//
//    public String editNutrition(String edit, RecipeUser recipeUser, int userID, String password){
//        if (recipeUser.userID == userID && Objects.equals(recipeUser.password, password)){
//            recipeUser.nutrition = edit;
//            return "Edit Successfully";
//        } else {
//            return "Fail to Edit";
//        }
//    }
//
//    public String editInstructions(String edit, RecipeUser recipeUser, int userID, String password){
//        if (recipeUser.userID == userID && Objects.equals(recipeUser.password, password)){
//            recipeUser.instructions = edit;
//            return "Edit Successfully";
//        } else {
//            return "Fail to Edit";
//        }
//    }
//
//
//    public String editTag(List<String> edit, RecipeUser recipeUser, int userID, String password){
//        if (recipeUser.userID == userID && Objects.equals(recipeUser.password, password)){
//            recipeUser.tag = edit;
//            return "Edit Successfully";
//        } else {
//            return "Fail to Edit";
//        }
//    }
//
//
//    public String editAllergy(Map<String, Boolean>  edit, RecipeUser recipeUser, int userID, String password){
//        if (recipeUser.userID == userID && Objects.equals(recipeUser.password, password)){
//            recipeUser.allergy = edit;
//            return "Edit Successfully";
//        } else {
//            return "Fail to Edit";
//        }
//    }
//
//    public RecipeUser uploadRecipe(String name, String ingredients, String nutrition, String instructions, List<String> tag,
//                               Map<String, Boolean> allergy, int userID, String password){
//        return new RecipeUser(name, ingredients, nutrition, instructions, tag, allergy, userID, password);
//    }
//}
}