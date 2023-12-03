package app;

import entity.folder.FolderFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_folder.CreateFolderController;
import interface_adapter.create_folder.CreateFolderPresenter;
import interface_adapter.create_folder.CreateFolderViewModel;
import interface_adapter.my_folder.MyFolderViewModel;
import use_case.create_folder.*;
import view.CreateFolderView;

import javax.swing.*;
import java.io.IOException;


public class CreateFolderUseCaseFactory {
    private CreateFolderUseCaseFactory() {}
    public static CreateFolderView create(
            ViewManagerModel viewManagerModel,
            CreateFolderViewModel createFolderViewModel,
            MyFolderViewModel myFolderViewModel,
            CreateFolderDataAccessInterface createFolderDataAccessInterface,
            FolderFactory folderFactory) {
        CreateFolderController createFolderController = createCreateFolderController(createFolderViewModel,
                myFolderViewModel, viewManagerModel, createFolderDataAccessInterface, folderFactory);

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
                                                                       MyFolderViewModel myFolderViewModel,
                                                                       ViewManagerModel viewManagerModel,
                                                                       CreateFolderDataAccessInterface createFolderDataAccessInterface,
                                                                       FolderFactory folderFactory) {
        CreateFolderOutputBoundary createFolderOutputBoundary = new CreateFolderPresenter(
              createFolderViewModel, myFolderViewModel, viewManagerModel);
        CreateFolderInputBoundary createInteractor = new CreateFolderInteractor(createFolderDataAccessInterface,
                createFolderOutputBoundary, folderFactory);
        return new CreateFolderController(createInteractor);
    }
}
