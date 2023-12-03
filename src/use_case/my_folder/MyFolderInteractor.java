package use_case.my_folder;

import entity.folder.Folder;
import entity.recipe.Recipe;
import use_case.my_folder.MyFolderDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class MyFolderInteractor implements MyFolderInputBoundary{
    final MyFolderDataAccessInterface userDataAccessObject;
    final MyFolderOutputBoundary myFolderPresenter;

    public MyFolderInteractor(MyFolderDataAccessInterface userDataAccessObject,
                                MyFolderOutputBoundary myFolderPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.myFolderPresenter = myFolderPresenter;
    }

    public void execute(MyFolderInputData myFolderInputData) {
        String username = myFolderInputData.getUsername();
        if (!userDataAccessObject.existsByName(username)) {
            myFolderPresenter.prepareFailView(username + ": User does not exist.");
        }else {
             ArrayList<String> foldernames = userDataAccessObject.getFolderList(myFolderInputData.getUsername());

             MyFolderOutputData myFolderOutputData = new MyFolderOutputData(foldernames, false);
             myFolderPresenter.prepareSuccessView(myFolderOutputData);
            }
        }
}
