package use_case.search;

public class SearchInputData {
    final private String ingredients;
    final private String allergy;

    public SearchInputData(String ingredients, String allergy) {
        this.ingredients = ingredients;
        this.allergy = allergy;

    }

    String getIngredients() {
        return ingredients;
    }

    String getAllergy() {
        return allergy;
    }
}
