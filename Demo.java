
public class Demo {
    OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
    MediaType mediaType = MediaType.parse("text/plain");
    RequestBody body = RequestBody.create(mediaType, "");
    Request request = new Request.Builder()
            .url("https://api.spoonacular.com/recipes/findByIngredients?ingredients=carrots,tomatoes&number=10&limitLicense=true&ranking=1&ignorePantry=false&apiKey=058b6a2aa4e24c0186999c82e5b1f05e")
            .method("GET", body)
            .build();
    Response response = client.newCall(request).execute();
    int 0;
}
