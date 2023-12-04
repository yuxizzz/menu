package interface_adapter.my_folder;

import use_case.my_folder.MyFolderInputBoundary;
import use_case.my_folder.MyFolderInputData;
import use_case.open_folder.OpenFolderInputBoundary;
import use_case.open_folder.OpenFolderInputData;

public class MyFolderController {
    final MyFolderInputBoundary myFolderUseCaseInteractor;
    public MyFolderController(MyFolderInputBoundary myFolderUseCaseInteractor) {
        this.myFolderUseCaseInteractor = myFolderUseCaseInteractor;
    }


    public void execute(String username) {
        MyFolderInputData myFolderInputData = new MyFolderInputData(username);

        myFolderUseCaseInteractor.execute(myFolderInputData);
    }
}
