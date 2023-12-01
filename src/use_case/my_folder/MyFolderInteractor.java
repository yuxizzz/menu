package use_case.my_folder;

import entity.folder.Folder;
import entity.recipe.Recipe;
import use_case.my_folder.MyFolderDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class MyFolderInteractor {
    final MyFolderDataAccessInterface folderDataAccessObject;
    final MyFolderOutputBoundary myFolderPresenter;

    public MyFolderInteractor(MyFolderDataAccessInterface folderDataAccessObject,
                                MyFolderOutputBoundary myFolderPresenter) {
        this.folderDataAccessObject = folderDataAccessObject;
        this.myFolderPresenter = myFolderPresenter;
    }

    public void execute(MyFolderInputData myFolderInputData) {
        String username = myFolderInputData.getUsername();
        if (!folderDataAccessObject.existsByName(username)) {
            myFolderPresenter.prepareFailView(username + ": User does not exist.");
        }else {
             Folder folder = folderDataAccessObject.get(myFolderInputData.getUsername());
             HashMap<Integer, ArrayList> recipeMap = folderDataAccessObject.getrecipeMap(foldername);

             MyFolderOutputData myFolderOutputData = new MyFolderOutputData(folder.getName(),
                     false,folder.getRecipeMap());
             myFolderPresenter.prepareSuccessView(myFolderOutputData);
            }
        }
}
