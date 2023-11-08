package api;

import entity.*;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Search {

    private static final String API_URL = "https://api.spoonacular.com/recipes/complexSearch";
    // load API_TOKEN from env variable.
    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static String getApiToken() {
        return API_TOKEN;
    }

    public static AllResults getRecipeList(String includeIngredients, String tags) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        // MediaType mediaType = MediaType.parse("application/json");
        // RequestBody body = RequestBody.create(mediaType, "0=i&1=n&2=g&3=r&4=e&5=d&6=i&7=e&8=n&9=t&10=L&11=i&12=s&13=t&14==&15=3&16= &17=o&18=z&19= &20=f&21=l&22=o&23=u&24=r&25=%26&26=s&27=e&28=r&29=v&30=i&31=n&32=g&33=s&34==&35=2");
        Request request = new Request.Builder()
                .url(String.format("https://api.spoonacular.com/recipes/complexSearch?includeIngredients=%s&tags=%s&number=10&apiKey=33e759b1978e4ecb9cc584a2bf0ba675", includeIngredients, tags))
                .addHeader("Content-Type", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            JSONObject responseBody = new JSONObject(response.body().string());
            JSONArray results = responseBody.getJSONArray("results");
            if (response.code() == 200) {
//                return results;
                HashMap<Object, SearchResult> searchresult = new HashMap<Object, SearchResult>();
                for (Object item: results) {
                    if (item.getClass().equals(JSONObject.class)) {
                        SearchResult value = CommonSearchResult.builder()
                                .image(((JSONObject) item).getString("image"))
                                .recipeid(String.valueOf(((JSONObject) item).getInt("id")))
                                .title(((JSONObject) item).getString("title"))
                                .imageType(((JSONObject) item).getString("imageType"))
                                .build();
                        searchresult.put(value.getRecipeid(), value);
                    }
                }
                return CommonAllResults.builder().results(searchresult).build();
            } else {
                throw new RuntimeException(response.message());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//     get recipe api
    public static Recipe getRecipe(Integer id) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        // MediaType mediaType = MediaType.parse("application/json");
        // RequestBody body = RequestBody.create(mediaType, "0=i&1=n&2=g&3=r&4=e&5=d&6=i&7=e&8=n&9=t&10=L&11=i&12=s&13=t&14==&15=3&16= &17=o&18=z&19= &20=f&21=l&22=o&23=u&24=r&25=%26&26=s&27=e&28=r&29=v&30=i&31=n&32=g&33=s&34==&35=2");
        Request request = new Request.Builder()
                .url(String.format("https://api.spoonacular.com/recipes/informationBulk?id=%s&includeNutrition=true&apiKey=33e759b1978e4ecb9cc584a2bf0ba675", id))
                .addHeader("Content-Type", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            JSONObject recipe = new JSONObject(response.body().string());
            if (response.code() == 200) {
                System.out.println(recipe);
                return CommonRecipe.builder()
                        .name(recipe.getString("name"))
                        .image(recipe.getString("image"))
                        .recipeurl(recipe.getString("url"))
                        .recipeid(Integer.valueOf(recipe.getString("id")))
                        .ingredients(recipe.getString("ingredients"))
                        .nutrition(recipe.getString("nutrition"))
                        .instructions(recipe.getString("instructions"))
                        .build();
            } else {
                throw new RuntimeException(response.message());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        String includeIngredients = "tomato,cheese";
        String tags = "ipsum ea proident amet occaecat";
        System.out.println(Search.getRecipeList(includeIngredients, tags));
    }


}

