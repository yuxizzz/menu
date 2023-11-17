package use_case.create_recipe;

public interface CreateRecipeDataAccessInterface {
    void createUserRecipe(String recipeName, String ingredients,
                          String nutrition, String instructions, String image, String recipeUrl, String recipeID);

//    csvFile = new File(csvPath);
//        headers.put("recipe_name", 0);
//        headers.put("ingredients", 1);
//        headers.put("nutrition", 2);
//        headers.put("instructions", 3);
//        headers.put("image", 4);
//        headers.put("recipeurl", 5);
//        headers.put("recipeid", 6);
}
