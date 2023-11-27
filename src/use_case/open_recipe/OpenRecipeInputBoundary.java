package use_case.open_recipe;

import java.io.IOException;

public interface OpenRecipeInputBoundary {
    void execute(OpenRecipeInputData openRecipeInputData) throws IOException;
}
