package use_case.create_folder;

import entity.recipe.Recipe;

import java.util.HashMap;
import java.util.Map;

public class CreateFolderOutputData {
    private final String foldername;
//    private final Map<Integer, Recipe> recipeMap;
    private boolean useCaseFailed;

    public CreateFolderOutputData(String foldername, boolean useCaseFailed) {
        this.foldername = foldername;
//        this.recipeMap = new HashMap<Integer, Recipe>();
        this.useCaseFailed = useCaseFailed;
    }

    public String getFoldername() {
        return foldername;
    }
}
