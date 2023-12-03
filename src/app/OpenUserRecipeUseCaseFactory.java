package app;

import interface_adapter.collect_recipe.CollectRecipeViewModel;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.open_recipe.OpenRecipeController;
import interface_adapter.open_recipe.OpenRecipeViewModel;
import interface_adapter.remove_recipe.RemoveController;
import use_case.open_recipe.OpenRecipeDataAccessInterface;
import view.OpenedFolderView;
import view.UserRecipeView;

import javax.swing.*;
import java.io.IOException;

public class OpenUserRecipeUseCaseFactory {
    private  OpenUserRecipeUseCaseFactory() {}

    public static UserRecipeView create (
            OpenRecipeViewModel openRecipeViewModel,
            EditRecipeViewModel editRecipeViewModel,
            CollectRecipeViewModel collectRecipeViewModel,
            OpenRecipeDataAccessInterface openRecipeDataAccessObject) {
        try {
            RemoveController removeController = createRemoveUseCase(viewManagerModel,
                    openedFolderViewModel, removeViewModel, removeDataAccessObject);
            OpenRecipeController openRecipeController = createOpenRecipeUseCase(viewManagerModel,
                    openRecipeViewModel,editRecipeViewModel, collectRecipeViewModel,openRecipeDataAccessObject);

            return new OpenedFolderView(openedFolderViewModel, removeController,
                    openRecipeViewModel, openRecipeController,
                    removeViewModel);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }
    }
}
