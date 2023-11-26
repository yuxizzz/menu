package use_case.get_recipe;

import java.io.IOException;

public interface GetRecipeInputBoundary {
    void execute(GetRecipeInputData getRecipeInputData) throws IOException;
}
