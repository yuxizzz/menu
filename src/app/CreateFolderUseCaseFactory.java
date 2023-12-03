package app;

import entity.folder.FolderFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import interface_adapter.create_folder.CreateFolderController;
import interface_adapter.create_folder.CreateFolderPresenter;
import interface_adapter.create_folder.CreateFolderViewModel;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.open_recipe.OpenRecipeController;
import interface_adapter.open_recipe.OpenRecipeViewModel;
import interface_adapter.remove_recipe.RemoveController;
import interface_adapter.remove_recipe.RemoveViewModel;
import use_case.create_folder.*;
import use_case.open_recipe.OpenRecipeDataAccessInterface;
import use_case.remove_recipe.RemoveFolderDataAccessInterface;
import view.CreateFolderView;
import view.OpenedFolderView;

import javax.swing.*;
import java.io.IOException;

public class CreateFolderUseCaseFactory {
    private CreateFolderUseCaseFactory() {}
    public static CreateFolderView creat(
            ViewManagerModel viewManagerModel,
            CreateFolderViewModel createFolderViewModel,
            CreateFolderDataAccessInterface createFolderDataAccessInterface,
            FolderFactory folderFactory) {
        CreateFolderController createFolderController = createCreateFolderController(createFolderViewModel,
                viewManagerModel, createFolderDataAccessInterface, folderFactory);

        return new CreateFolderView(createFolderViewModel, createFolderController);

    }

//    public static CreateFolderView creat(
//            ViewManagerModel viewManagerModel,
//            CreateFolderViewModel createFolderViewModel,
//            CreateFolderDataAccessInterface createFolderDataAccessInterface,
//            FolderFactory folderFactory) {
//        try {
//            CreateFolderController createFolderController = createCreateFolderController(createFolderViewModel,
//                    viewManagerModel, createFolderDataAccessInterface, folderFactory);
//
//            return new CreateFolderView(createFolderViewModel, createFolderController);
//
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Could not open user data file.");
//        }
//
//        return null;
//    }

    private static CreateFolderController createCreateFolderController(CreateFolderViewModel createFolderViewModel,
                                                                       ViewManagerModel viewManagerModel,
                                                                       CreateFolderDataAccessInterface createFolderDataAccessInterface,
                                                                       FolderFactory folderFactory) {
        CreateFolderOutputBoundary createFolderOutputBoundary = new CreateFolderPresenter(
              createFolderViewModel, viewManagerModel);
        CreateFolderInputBoundary createInteractor = new CreateFolderInteractor(createFolderDataAccessInterface,
                createFolderOutputBoundary, folderFactory);
    }
}
