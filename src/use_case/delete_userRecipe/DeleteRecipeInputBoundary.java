package use_case.delete_userRecipe;

import use_case.clear_users.ClearInputData;

public interface DeleteRecipeInputBoundary {
    void execute(ClearInputData clearInputData);
}
