package data_access;

import entity.folder.Folder;
import entity.folder.FolderFactory;
import entity.recipe.CommonRecipe;
import entity.recipe.Recipe;
import use_case.add_recipe_to_folder.AddRecipeToFolderDataAccessInterface;
import use_case.collect_recipe.CollectRecipeDataAccessInterface;
import use_case.delete_folder.DeleteFolderUserDataAccessInterface;
import use_case.my_folder.MyFolderDataAccessInterface;
import use_case.open_folder.OpenFolderDataAccessInterface;

import java.io.*;
import java.util.*;

//TODO recipeDAO & folderDAO
public class FileFolderDataAccessObject implements DeleteFolderUserDataAccessInterface,
        OpenFolderDataAccessInterface, AddRecipeToFolderDataAccessInterface, MyFolderDataAccessInterface, CollectRecipeDataAccessInterface {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, Folder> folders = new HashMap<>();

    private FolderFactory folderFactory;
    private FileRecipeDataAccessObject recipeDataAccessObject;
    private FileUserDataAccessObject fileUserDataAccessObject;

    /**
     * @param csvPath
     * @param folderFactory
     * @param recipeDataAccessObject
     * @throws IOException
     */
    public FileFolderDataAccessObject(String csvPath, FolderFactory folderFactory,
                                      FileRecipeDataAccessObject recipeDataAccessObject,
                                      FileUserDataAccessObject fileUserDataAccessObject) throws IOException {
        this.folderFactory = folderFactory;
        this.recipeDataAccessObject = recipeDataAccessObject;
        this.fileUserDataAccessObject = fileUserDataAccessObject;

        csvFile = new File(csvPath);
        headers.put("folder_name", 0);
        headers.put("recipe_id", 1);

        if (csvFile.length() == 0) {
            saveToCSV();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("folder_name,recipe_id");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String folderName = String.valueOf(col[headers.get("folder_name")]);
                    String[] recipeIDs = col[headers.get("recipe_id")].split(" ");
                    HashMap<Integer, Recipe> recipes = new HashMap<>();
                    for (String id : recipeIDs) {
                        Integer recipeID = Integer.parseInt(id);
                        Recipe recipe = recipeDataAccessObject.getRecipeFromFile(recipeID);
                        recipes.put(recipeID, recipe);
                    }
                    Folder folder = folderFactory.create(folderName, recipes);
                    folders.put(folderName, folder);
                }
            }
        }
    }

    /**
     * @param folder
     */
    public void save(Folder folder) {
        folders.put(folder.getName(), folder);
    }

    ;

    private void saveToCSV() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Folder f : folders.values()) {
                String line = String.format("%s,%s,%s",
                        f.getName(), f.getRecipeMap().keySet());
                recipeDataAccessObject.saveFolderRecipes(f.getRecipeMap());
                writer.write(line);
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param folderName
     * @return
     */
    @Override
    public String deleteFolder(String folderName) {
        folders.remove(folderName);
        return folderName + "is removed";
    }

    /**
     * @param identifier
     * @return
     */
    @Override
    public boolean existsByName(String identifier) {
        return folders.containsKey(identifier);

    }

    /**
     * @param folderName
     * @return
     */
    public Folder get(String folderName) {
        return folders.get(folderName);
    }

    public ArrayList<String> getFolderList() {
        ArrayList<String> list1 = new ArrayList<>(folders.keySet());
        return list1;
    }

    /**
     * @param foldername
     * @return
     */

// TODO change it to integer list<recipe information> use java doc to explain
//    list[imageurl, title]
    public HashMap<Integer, ArrayList> getrecipeMap(String foldername) {
        HashMap<Integer, ArrayList> recipeMap = new HashMap<Integer, ArrayList>();
        for (Map.Entry<Integer, Recipe> entry : folders.get(foldername).getRecipeMap().entrySet()) {
            Integer key = entry.getKey();
            Recipe value = entry.getValue();
            ArrayList list1 = new ArrayList();
            list1.add(value.getImage());
            list1.add(value.getName());
            recipeMap.put(key, list1);
        }
        return recipeMap;
    }


    @Override
    public String addRecipeToFolder(String folderName, Integer recipeID) {
//
        Recipe r = recipeDataAccessObject.getRecipeFromFile(recipeID);

        for (String s : folders.keySet()) {
            if (s.equals(folderName)) {
                Folder f = folders.get(s);
                for (Recipe recipe: f) {
                    if (Objects.equals(recipe.getRecipeID(), recipeID)){
                        return null;
                    }
                }
                f.addRecipe(recipeID, r);
                return "successfully added to " + folderName;
            }
        }
        return null;
    }

    @Override
    public ArrayList<String> getAllFolders(String username) {
        ArrayList<Folder> folders = fileUserDataAccessObject.getFolders(username);
        ArrayList<String> foldernames = new ArrayList<>();
        for (Folder f : folders) {
            foldernames.add(f.getName());
        }
        return foldernames;
    }
}
