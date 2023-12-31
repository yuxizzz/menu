package interface_adapter.open_folder;


import use_case.open_folder.OpenFolderInputBoundary;
import use_case.open_folder.OpenFolderInputData;

public class OpenFolderController {

    final OpenFolderInputBoundary openFolderUseCaseInteractor;
    public OpenFolderController(OpenFolderInputBoundary openFolderUseCaseInteractor) {
        this.openFolderUseCaseInteractor = openFolderUseCaseInteractor;
    }


    public void execute(String foldername, String username) {
        OpenFolderInputData openFolderInputData = new OpenFolderInputData(foldername, username);

        openFolderUseCaseInteractor.execute(openFolderInputData);
    }
}
