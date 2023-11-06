package interface_adapter.search;

public class SearchState {
    private String ingredients = "";
    private String ingredientsError = null;
    private String allergy = "";
    private String allergyError = null;


    public SearchState(SearchState copy) {
        ingredients = copy.ingredients;
        ingredientsError = copy.ingredientsError;
        allergy = copy.allergy;
        allergyError = copy.allergyError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public SearchState() {
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getIngredientsError() {
        return ingredientsError;
    }

    public String getAllergy() {
        return allergy;
    }

    public String getAllergyError() {
        return allergyError;
    }

    public void setIngredients(String userIngredients) {
        this.ingredients = userIngredients;
    }

    public void setIngredientsError(String userIngredientsError) {
        this.ingredientsError = userIngredientsError;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public void setAllergyError(String allergyError) {
        this.allergyError = allergyError;
    }

    @Override
    public String toString() {
        return "SearchState{" +
                "ingredients='" + ingredients + '\'' +
                ", allergy='" + allergy + '\'' +
                '}';
    }
}
