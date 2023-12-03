package data_access;

import entity.folder.Folder;
import entity.search_results.CommonSearchResultFactory;
import entity.search_results.SearchResult;
import entity.search_results.SearchResultFactory;
import entity.user.User;
import entity.user.UserFactory;
import use_case.search.SearchUserDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static api.Search.getRecipeList;

public class SearchResultsDataAccessObject implements SearchUserDataAccessInterface {

    private final HashMap<Object, SearchResult> headers = new LinkedHashMap<>();
    private final File csvFile;

    private final SearchResultFactory searchResult;

    private HashMap<Object, SearchResult> resultMap = new HashMap<>();

    private static final Map<String, User> accounts = new HashMap<>();

    public SearchResultsDataAccessObject(String csvPath,
                                         SearchResultFactory searchResult) throws IOException {
        this.searchResult = searchResult;
        csvFile = new File(csvPath);
    }
//        headers.put("results", 0);
//        headers.put("password", 1);
//        headers.put("creation_time", 2);

//        if (csvFile.length() == 0) {
//            save();
//        } else {
//
//            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
//                String header = reader.readLine();
//
//                // TODO For later: clean this up by creating a new Exception subclass and handling it in the UI.
//                assert header.equals("username,password,creation_time");
//
//                String row;
//                while ((row = reader.readLine()) != null) {
//                    String[] col = row.split(",");
//                    String username = String.valueOf(col[headers.get("username")]);
//                    String password = String.valueOf(col[headers.get("password")]);
//                    String creationTimeText = String.valueOf(col[headers.get("creation_time")]);
//                    LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
//                    User user = userFactory.create(username, password, ldt);
//                    accounts.put(username, user);
//                }
//            }
//        }
//    }

//    @Override
//    public void save(User user) {
//        accounts.put(user.getName(), user);
//        this.save();
//    }

//    @Override
//    public User get(String username) {
//        return accounts.get(username);
//    }
//
//    private void save() {
//        BufferedWriter writer;
//        try {
//            writer = new BufferedWriter(new FileWriter(csvFile));
//            writer.write(String.join(",", headers.keySet()));
//            writer.newLine();
//
//            for (User user : accounts.values()) {
//                String line = String.format("%s,%s,%s",
//                        user.getName(), user.getPassword(), user.getCreationTime());
//                writer.write(line);
//                writer.newLine();
//            }
//
//            writer.close();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * Return whether a user exists with username identifier.
//     * @param identifier the username to check.
//     * @return whether a user exists with username identifier
//     */
//    @Override
//    public boolean existsByName(String identifier) {
//        return accounts.containsKey(identifier);
//    }
//
//    @Override
//    public ArrayList<String> clearAllUser() {
//        ArrayList<String> users = new ArrayList<>();
//        users.addAll(accounts.keySet());
//        accounts.clear();
//        this.save();
//        return users;
//    }
//
//    public ArrayList<Folder> getFolders(String username) {
//        User user = accounts.get(username);
//        return user.getUserFolders();
//    }
//
//    public static Map<String, User> getAccounts(){
//        return accounts;
//    }

    @Override
    public boolean existsIngredients(String ingredient, String tags) throws IOException {
        if (getRecipeList(ingredient, "gulten free").isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean existsTags(String ingredient, String tags) throws IOException {
        if (getRecipeList("egg", tags).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public HashMap<Integer, ArrayList> getOutputRecipes(String ingredients, String tags) throws IOException {
        this.resultMap = getRecipeList(ingredients, tags);
        HashMap<Integer, ArrayList> result = new HashMap<Integer, ArrayList>();
        for (Map.Entry<Object, SearchResult> entry : resultMap.entrySet()){
            Object key = entry.getKey();
            SearchResult value = entry.getValue();
            Integer recipeID = Integer.valueOf(value.getRecipeid());
            ArrayList list1 = new ArrayList();
            list1.add(value.getImage());
            list1.add(value.getTitle());
            result.put(recipeID, list1);
        }
        return result;
}



//    public HashMap<Integer, ArrayList> getResearchMap(String foldername) {
//        HashMap<Integer, ArrayList> recipeMap = new HashMap<Integer, ArrayList>();
//        for (Map.Entry<Integer, Recipe> entry : folders.get(foldername).getRecipeMap().entrySet()) {
//            Integer key = entry.getKey();
//            Recipe value = entry.getValue();
//            ArrayList list1 = new ArrayList();
//            list1.add(value.getRecipeURL());
//            list1.add(value.getName());
//            recipeMap.put(key, list1);
//        }
//        return recipeMap;}


}

