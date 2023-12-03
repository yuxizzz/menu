package use_case.create_folder;

import entity.folder.Folder;
import entity.folder.FolderFactory;

public class CreateFolderInteractor implements CreateFolderInputBoundary {
    final CreateFolderDataAccessInterface folderDataAccessObject;
    final CreateFolderOutputBoundary folderPresenter;
    final FolderFactory folderFactory;

    public CreateFolderInteractor(CreateFolderDataAccessInterface folderDataAccessObject, CreateFolderOutputBoundary folderPresenter, FolderFactory folderFactory) {
        this.folderDataAccessObject = folderDataAccessObject;
        this.folderPresenter = folderPresenter;
        this.folderFactory = folderFactory;
    }


    @Override
    public void execute(CreateFolderInputData createFolderInputData) {
        if (folderDataAccessObject.existsByName(createFolderInputData.getFoldername())) {
            folderPresenter.prepareFailView("Folder name already exists.");
        } else {
            Folder folder = folderFactory.create(createFolderInputData.getFoldername());
            String username = createFolderInputData.getUsername();
            folderDataAccessObject.save(folder, username);

            CreateFolderOutputData createFolderOutputData = new CreateFolderOutputData(folder.getName(), false);
            folderPresenter.prepareSuccessView(createFolderOutputData);
        }
    }
}
