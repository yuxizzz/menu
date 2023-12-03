package data_access;

import entity.recipe.Recipe;
import entity.recipe.RecipeFactory;
import entity.search_results.SearchResult;
import use_case.search.SearchUserDataAccessInterface;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static api.Search.getRecipeList;

public class SearchResultsDataAccessObject implements SearchUserDataAccessInterface {

    private final HashMap<Object, SearchResult> headers = new LinkedHashMap<>();

    private HashMap<Object, SearchResult> resultMap = new HashMap<>();


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

