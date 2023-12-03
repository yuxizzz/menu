package data_access;

import entity.folder.Folder;
import entity.recipe.Recipe;
import entity.recipe.RecipeFactory;
import entity.recipe.UserRecipe;
import entity.user.User;
import use_case.delete_userRecipe.DeleteRecipeDataAccessInterface;
import use_case.edit_recipe.EditDataAccessInterface;
import use_case.get_recipe.GetRecipeDataAccessInterface;
import use_case.open_recipe.OpenRecipeDataAccessInterface;
import use_case.upload_recipe.UploadDataAccessInterface;

import java.io.*;

import java.util.*;

/**
 * The DataAccessObject class for Recipe objects, where they are stored in csv file. The usecases
 * can get access to the Recipe objects data through the DAO.
 */
public class FileRecipeDataAccessObject implements UploadDataAccessInterface, EditDataAccessInterface, OpenRecipeDataAccessInterface, GetRecipeDataAccessInterface {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<Integer, Recipe> recipeList = new HashMap<>();

    private RecipeFactory recipeFactory;

    private FileUserDataAccessObject fileUserDataAccessObject;

    /**
     * @param csvPath
     * @param recipeFactory
     * @throws IOException
     */
    public FileRecipeDataAccessObject(String csvPath, RecipeFactory recipeFactory, FileUserDataAccessObject fileUserDataAccessObject) throws IOException {
        this.recipeFactory = recipeFactory;
        this.fileUserDataAccessObject = fileUserDataAccessObject;

        csvFile = new File(csvPath);
        headers.put("recipe_name", 0);
        headers.put("ingredients", 1);
        headers.put("nutrition", 2);
        headers.put("instructions", 3);
        headers.put("image", 4);
        headers.put("recipeurl", 5);
        headers.put("recipeid", 6);

        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // TODO: For later: clean this up by creating a new Exception subclass and handling it in the UI.
//                assert header.equals("recipe_name,ingredients,nutrition,instructions,image,recipeurl,recipeid");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String recipeName = String.valueOf(col[headers.get("recipe_name")]);
                    String ingredients = String.valueOf(col[headers.get("ingredients")]);
                    String nutrition = String.valueOf(col[headers.get("nutrition")]);
                    String instruction = String.valueOf(col[headers.get("instructions")]);
                    String image = String.valueOf(col[headers.get("image")]);
                    String recipeUrl = String.valueOf(col[headers.get("recipeurl")]);
                    Integer recipeId = Integer.valueOf(col[headers.get("recipeid")]);
                    Recipe recipe = recipeFactory.create(recipeName, ingredients, nutrition, instruction, image, recipeUrl, recipeId);
                    recipeList.put(recipeId, recipe);
                }
            }
        }
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Recipe recipe: recipeList.values()) {
                String line = String.format("%s,%s,%s,%s,%s",
                        recipe.getName(), recipe.getIngredients(), recipe.getNutrition(), recipe.getInstructions(), recipe.getImage(), recipe.getRecipeURL(), recipe.getRecipeID().toString());
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param recipeHashMap
     */
    public void saveFolderRecipes(HashMap<Integer, Recipe> recipeHashMap) {
        for (Integer id: recipeHashMap.keySet()) {
            if (!recipeList.containsKey(id)) {
                recipeList.put(id, recipeHashMap.get(id));
            }
        }
    }



    /**
     * @param recipeID
     * @return
     */
    public Recipe getRecipeFromFile(Integer recipeID) {
        return recipeList.get(recipeID);
    }

    public boolean existsByName(Integer recipeID) {
        return recipeList.containsKey(recipeID);
    }

    @Override
    public void save(Recipe recipe) {
        recipeList.put(recipe.getRecipeID(), recipe);
    }


    public UserRecipe deleteRecipe(Integer deletedRecipeID){

        UserRecipe userRecipe = (UserRecipe) recipeList.get(deletedRecipeID);

        recipeList.remove(deletedRecipeID);
        this.save();

        return userRecipe;
    }






    @Override
    public void editRecipe(Integer recipeID, UserRecipe userRecipe) {
        recipeList.replace(recipeID,userRecipe);

    }


    @Override
    public UserRecipe getRecipe(Integer recipeID, String username) {
        Map<String, User> accounts = fileUserDataAccessObject.getAccounts();
        User user = accounts.get(username);
        ArrayList<Folder> folders = user.getUserFolders();
        UserRecipe userRecipe = null;
        for (Folder f : folders) {
            if(f.getRecipeMap().containsKey(recipeID)){
                userRecipe = (UserRecipe) f.getRecipeMap().get(recipeID);

            }
        }
        return userRecipe;


    }

    public Recipe getCommonRecipe(Integer recipeID, String username) {
        Map<String, User> accounts = fileUserDataAccessObject.getAccounts();
        User user = accounts.get(username);
        ArrayList<Folder> folders = user.getUserFolders();
        Recipe Recipe = null;
        for (Folder f : folders) {
            if(f.getRecipeMap().containsKey(recipeID)){
                Recipe = f.getRecipeMap().get(recipeID);

            }
        }
        return Recipe;


    }








    @Override
    public void saveRecipe(Integer recipeID, Recipe recipe, String username) {
        Map<String, User> accounts = fileUserDataAccessObject.getAccounts();
        User user = accounts.get(username);
        ArrayList<Folder> folders = user.getUserFolders();
        folders.get(0).addRecipe(recipeID, recipe);
        recipeList.put(recipeID, recipe);
        save();
    }



    @Override
    public boolean existsByRecipeID(Integer recipeID, String username) {
        Map<String, User> accounts = fileUserDataAccessObject.getAccounts();
        User user = accounts.get(username);
        ArrayList<Folder> folders = user.getUserFolders();
        HashMap<Integer, Recipe> recipes = folders.get(0).getRecipeMap();
        return recipes.containsKey(recipeID);
    }


}
