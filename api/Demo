package api;

import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.*;
import org.json.JSONArray;
import org.w3c.dom.Text;

import javax.swing.text.html.HTML;
import java.io.IOException;
import java.util.Arrays;

public class Demo {

    private static final String API_URL = "https://api.spoonacular.com/recipes/visualizeNutrition";
    // load API_TOKEN from env variable.
    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static String getApiToken() {
        return API_TOKEN;
    }

    public static String getDemo() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "0=i&1=n&2=g&3=r&4=e&5=d&6=i&7=e&8=n&9=t&10=L&11=i&12=s&13=t&14==&15=3&16= &17=o&18=z&19= &20=f&21=l&22=o&23=u&24=r&25=%26&26=s&27=e&28=r&29=v&30=i&31=n&32=g&33=s&34==&35=2");
        Request request = new Request.Builder()
                .url("https://api.spoonacular.com/recipes/visualizeNutrition?language=en&apiKey=33e759b1978e4ecb9cc584a2bf0ba675")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
//        Response response = client.newCall(request).execute();

        //our code
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        MediaType mediaType = MediaType.parse("text/plain");
//        RequestBody body = RequestBody.create(mediaType, "");
//        Request request = new Request.Builder()
//                .url("https://api.spoonacular.com/recipes/findByIngredients?ingredients=carrots,tomatoes&number=10&limitLicense=true&ranking=1&ignorePantry=false&apiKey=058b6a2aa4e24c0186999c82e5b1f05e")
//                .post(body)
//                .addHeader("Content-Type", "application/json")
//                .build();
//
//
//        //xx
////        OkHttpClient client = new OkHttpClient().newBuilder()
////                .build();
////        Request request = new Request.Builder()
////                .url(String.format("https://grade-logging-api.chenpan.ca/grade?course=%s&utorid=%s", course, utorid))
////                .addHeader("Authorization", API_TOKEN)
////                .addHeader("Content-Type", "application/json")
////                .build();
//
        try {
            Response response = client.newCall(request).execute();
            // System.out.println(response);
            assert response.body() != null;
            String responseBody = response.body().string();
            return responseBody;
//            if (responseBody.getInt("status_code") == 200) {
//                return null;
//            } else {
//                throw new RuntimeException(responseBody.getString("message"));
//            }
            // return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws IOException {
        System.out.println(Demo.getDemo());

    }
}
