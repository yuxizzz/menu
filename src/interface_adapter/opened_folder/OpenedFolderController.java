package interface_adapter.opened_folder;

import use_case.opened_folder.OpenedFolderInputBoundary;
import use_case.opened_folder.OpenedFolderInputData;

public class OpenedFolderController {
    final OpenedFolderInputBoundary openedFolderUseCaseInteractor;

    public OpenedFolderController(OpenedFolderInputBoundary openedFolderUseCaseInteractor) {
        this.openedFolderUseCaseInteractor = openedFolderUseCaseInteractor;
    }


    public void execute(String foldername) {
        OpenedFolderInputData openedFolderInputData = new OpenedFolderInputData(foldername, remove);

        openedFolderUseCaseInteractor.execute(openedFolderInputData);
    }
}
