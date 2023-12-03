package use_case.create_folder;

public class CreateFolderOutputData {
    private final String foldername;
    private final String username;
//    private final Map<Integer, Recipe> recipeMap;
    private boolean useCaseFailed;

    public CreateFolderOutputData(String foldername, String username, boolean useCaseFailed) {
        this.foldername = foldername;
        this.username = username;
//        this.recipeMap = new HashMap<Integer, Recipe>();
        this.useCaseFailed = useCaseFailed;
    }

    public String getFoldername() {
        return foldername;
    }
}
