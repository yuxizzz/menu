package api;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;

public class Demo {

    private static final String API_URL = "https://api.spoonacular.com/recipes/findByIngredients";
    // load API_TOKEN from env variable.
    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static String getApiToken() {
        return API_TOKEN;
    }

    public static JSONObject getDemo() throws IOException {
        //our code
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.spoonacular.com/recipes/guessNutrition?title=Spaghetti&apiKey=058b6a2aa4e24c0186999c82e5b1f05e")
                .method("GET", body)
                .build();

        //xx
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        Request request = new Request.Builder()
//                .url(String.format("https://grade-logging-api.chenpan.ca/grade?course=%s&utorid=%s", course, utorid))
//                .addHeader("Authorization", API_TOKEN)
//                .addHeader("Content-Type", "application/json")
//                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());
            if (responseBody.getInt("status_code") == 200) {
                JSONObject grade = responseBody.getJSONObject("grade");
                return grade;
            } else {
               throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Demo.getDemo());

    }
}
