package api;

import okhttp3.*;
import entity.Recipe;
import org.json.JSONObject;

import java.io.IOException;

public class Search {

    private static final String API_URL = "https://api.spoonacular.com/recipes/complexSearch";
    // load API_TOKEN from env variable.
    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static String getApiToken() {
        return API_TOKEN;
    }

    public static Response getRecipe() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "0=i&1=n&2=g&3=r&4=e&5=d&6=i&7=e&8=n&9=t&10=L&11=i&12=s&13=t&14==&15=3&16= &17=o&18=z&19= &20=f&21=l&22=o&23=u&24=r&25=%26&26=s&27=e&28=r&29=v&30=i&31=n&32=g&33=s&34==&35=2");
        Request request = new Request.Builder()
                .url("https://api.spoonacular.com/recipes/complexSearch?query=burger&cuisine=italian&excludeCuisine=greek&diet=vegetarian&intolerances=gluten&equipment=pan&includeIngredients=tomato,cheese&excludeIngredients=eggs&type=main course&instructionsRequired=true&fillIngredients=false&addRecipeInformation=false&addRecipeNutrition=false&author=coffeebean&tags=ipsum ea proident amet occaecat&recipeBoxId=2468&titleMatch=Crock Pot&maxReadyTime=20&ignorePantry=false&sort=calories&sortDirection=asc&minCarbs=10&maxCarbs=100&minProtein=10&maxProtein=100&minCalories=50&maxCalories=800&minFat=1&maxFat=100&minAlcohol=0&maxAlcohol=100&minCaffeine=0&maxCaffeine=100&minCopper=0&maxCopper=100&minCalcium=0&maxCalcium=100&minCholine=0&maxCholine=100&minCholesterol=0&maxCholesterol=100&minFluoride=0&maxFluoride=100&minSaturatedFat=0&maxSaturatedFat=100&minVitaminA=0&maxVitaminA=100&minVitaminC=0&maxVitaminC=100&minVitaminD=0&maxVitaminD=100&minVitaminE=0&maxVitaminE=100&minVitaminK=0&maxVitaminK=100&minVitaminB1=0&maxVitaminB1=100&minVitaminB2=0&maxVitaminB2=100&minVitaminB5=0&maxVitaminB5=100&minVitaminB3=0&maxVitaminB3=100&minVitaminB6=0&maxVitaminB6=100&minVitaminB12=0&maxVitaminB12=100&minFiber=0&maxFiber=100&minFolate=0&maxFolate=100&minFolicAcid=0&maxFolicAcid=100&minIodine=0&maxIodine=100&minIron=0&maxIron=100&minMagnesium=0&maxMagnesium=100&minManganese=0&maxManganese=100&minPhosphorus=0&maxPhosphorus=100&minPotassium=0&maxPotassium=100&minSelenium=0&maxSelenium=100&minSodium=0&maxSodium=100&minSugar=0&maxSugar=100&minZinc=0&maxZinc=100&offset=606&number=10&limitLicense=true&apiKey=33e759b1978e4ecb9cc584a2bf0ba675")
                .addHeader("Content-Type", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            assert response.body() != null;
            JSONObject responseBody = new JSONObject(response.body().string());
            if (responseBody.getInt("status_code") == 200) {
                return Recipe.builder()
                        .name(recipe.getString("name"))
                        .ingredients(recipe.getString("ingredients"))
                        .nutrition(recipe.getString("nutrition"))
                        .instructions(recipe.getString("instructions"))
                        .tag(recipe.getList("tag"))
                        .allergy(recipe.getMap("allergy"))
                        .build();
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Search.getRecipe());
    }
}
