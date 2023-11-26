package use_case.add_recipe_to_folder;

public class AddRecipeToFolderOutputData {
    private final String message;
    private boolean useCaseFailed;

    public AddRecipeToFolderOutputData(String message, boolean useCaseFailed) {
        this.message = message;
        this.useCaseFailed = useCaseFailed;
    }

    public String getMessage() {return message;}


}
