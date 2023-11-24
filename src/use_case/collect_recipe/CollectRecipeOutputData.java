package use_case.collect_recipe;

import java.util.ArrayList;
import java.util.HashMap;

public class CollectRecipeOutputData {
    private final ArrayList<String> folders;
    public CollectRecipeOutputData(ArrayList<String> folders) {
        this.folders = folders;
    }

    public ArrayList<String> getFolders() {
        return folders;
    }
}
