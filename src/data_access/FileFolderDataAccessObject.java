package data_access;

import entity.folder.Folder;
import entity.folder.FolderFactory;
import entity.recipe.Recipe;
import use_case.create_folder.CreateFolderDataAccessInterface;
import use_case.delete_folder.DeleteFolderUserDataAccessInterface;
import use_case.open_folder.OpenFolderDataAccessInterface;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


//TODO recipeDAO & folderDAO
public class FileFolderDataAccessObject implements DeleteFolderUserDataAccessInterface, OpenFolderDataAccessInterface, CreateFolderDataAccessInterface {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, Folder> folders = new HashMap<>();

    private FolderFactory folderFactory;
    private FileRecipeDataAccessObject recipeDataAccessObject;

    /**
     * @param csvPath
     * @param folderFactory
     * @param recipeDataAccessObject
     * @throws IOException
     */
    public FileFolderDataAccessObject(String csvPath, FolderFactory folderFactory, FileRecipeDataAccessObject recipeDataAccessObject) throws IOException {
        this.folderFactory = folderFactory;
        this.recipeDataAccessObject = recipeDataAccessObject;

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


    /**
     * @param foldername
     * @return
     */
    public HashMap<Integer, Recipe> getrecipeMap(String foldername) {
        return folders.get(foldername).getRecipeMap();
    }
}
