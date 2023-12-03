package data_access;
import entity.folder.Folder;
import entity.recipe.Recipe;
import entity.user.User;
import entity.user.UserFactory;
import use_case.delete_folder.DeleteFolderUserDataAccessInterface;
import use_case.create_folder.CreateFolderDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutDataAccessInterface;
import use_case.my_folder.MyFolderDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;
import use_case.clear_users.ClearUserDataAccessInterface;
import use_case.upload_recipe.UploadDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;

public class FileUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface,
        ClearUserDataAccessInterface,
        LogoutDataAccessInterface, MyFolderDataAccessInterface, DeleteFolderUserDataAccessInterface,
        CreateFolderDataAccessInterface{

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private static final Map<String, User> accounts = new HashMap<>();

    private UserFactory userFactory;

    public FileUserDataAccessObject(String csvPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;

        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("creation_time", 2);

        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // TODO For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("username,password,creation_time");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    String creationTimeText = String.valueOf(col[headers.get("creation_time")]);
                    LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                    User user = userFactory.create(username, password, ldt);
                    accounts.put(username, user);
                }
            }
        }
    }

    @Override
    public void save(User user) {
        accounts.put(user.getName(), user);
        this.save();
    }

    @Override
    public User get(String username) {
        return accounts.get(username);
    }

    @Override
    public ArrayList<String> getFolderList(String username) {
        User user = accounts.get(username);
        ArrayList<String> folders = new ArrayList<>();
        for (Folder f: user.getUserFolders()) {
            folders.add(f.getName());
        }
        return folders;
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s,%s,%s",
                        user.getName(), user.getPassword(), user.getCreationTime());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Return whether a user exists with username identifier.
     * @param identifier the username to check.
     * @return whether a user exists with username identifier
     */
    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    @Override
    public void save(Folder folder, String username) {
        User user = accounts.get(username);
        user.addFolder(folder);
//        folders.put(folder.getName(), folder);
//        saveToCSV();
    }

    @Override
    public ArrayList<String> clearAllUser() {
        ArrayList<String> users = new ArrayList<>();
        users.addAll(accounts.keySet());
        accounts.clear();
        this.save();
        return users;
    }

    public ArrayList<Folder> getFolders(String username) {
        User user = accounts.get(username);
        return user.getUserFolders();
    }

    public static Map<String, User> getAccounts(){
        return accounts;
    }

    @Override
    public String deleteFolder(String folderName, String username) {
        User user = accounts.get(username);
        user.removeFolder(folderName);
        return folderName;

    }


//    public void saveRecipe(Integer recipeID, Recipe recipe, String username) {
//        User user = accounts.get(username);
//        ArrayList<Folder> folders = user.getUserFolders();
//        folders.get(0).addRecipe(recipeID, recipe);
//
//        }



//    public boolean existByReicipeID(Integer recipeID, String username) {
//        User user = accounts.get(username);
//        ArrayList<Folder> folders = user.getUserFolders();
//        HashMap<Integer, Recipe> recipes = folders.get(0).getRecipeMap();
//        return recipes.containsKey(recipeID);
//
//    }
}