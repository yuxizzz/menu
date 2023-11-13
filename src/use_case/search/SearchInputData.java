package use_case.search;

public class SearchInputData {
    final private String ingredients;
    final private String tags;

    public SearchInputData(String ingredients, String tags) {
        this.ingredients = ingredients;
        this.tags = tags;

    }

    String getIngredients() {
        return ingredients;
    }

    String getTags() {
        return tags;
    }
}
