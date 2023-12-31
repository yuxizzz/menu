package interface_adapter.create_folder;

import use_case.create_folder.CreateFolderInputBoundary;
import use_case.create_folder.CreateFolderInputData;

public class CreateFolderController {
    final CreateFolderInputBoundary createFolderUseCaseInteractor;

    public CreateFolderController(CreateFolderInputBoundary createFolderUseCaseInteractor) {
        this.createFolderUseCaseInteractor = createFolderUseCaseInteractor;
    }
    public void execute(String foldername, String username) {
        CreateFolderInputData createFolderInputData = new CreateFolderInputData(foldername, username);
        createFolderUseCaseInteractor.execute(createFolderInputData);
    }
}
