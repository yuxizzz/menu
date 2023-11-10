package interface_adapter.search;

public class SearchState {
    private String ingredients = "";
    private String ingredientsError = null;
    private String tags = "";
    private String tagsError = null;

    private String userID = "";


    public SearchState(SearchState copy) {
        ingredients = copy.ingredients;
        ingredientsError = copy.ingredientsError;
        tags = copy.tags;
        tagsError = copy.tagsError;
        userID = copy.userID;
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

    public String getTags() {
        return tags;
    }

    public String getTagsError() {
        return tagsError;
    }

    public void setIngredients(String userIngredients) {
        this.ingredients = userIngredients;
    }

    public void setIngredientsError(String userIngredientsError) {
        this.ingredientsError = userIngredientsError;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setTagsError(String TagsError) {
        this.tagsError = tagsError;
    }

    public String getUserID(String userID) {return this.userID;}

    @Override
    public String toString() {
        return "SearchState{" +
                "ingredients='" + ingredients + '\'' +
                ", allergy='" + tags + '\'' +
                '}';
    }

    public void setUserId(String username) {
        this.userID = userID;
    }
}
