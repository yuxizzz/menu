package use_case.opened_folder;

import entity.folder.Folder;

public class OpenedFolderInteractor {
    final OpenedFolderDataAccessInterface folderDataAccessObject;
    final OpenedFolderOutputBoundary openedFolderPresenter;

    public OpenedFolderInteractor(OpenedFolderDataAccessInterface folderDataAccessInterface,
                                  OpenedFolderDataAccessInterface folderDataAccessObject,
                                  OpenedFolderOutputBoundary openedFolderPresenter) {
        this.folderDataAccessObject = folderDataAccessObject;
        this.openedFolderPresenter = openedFolderPresenter;
    }

    public void execute(OpenedFolderInputData openedFolderInputData) {
        String foldername = openedFolderInputData.getFoldername();
        if (!folderDataAccessObject.existsByName(foldername)) {
            openedFolderPresenter.prepareFailView(foldername + ": Folder does not exist.");
        }else {
             Folder folder = folderDataAccessObject.get(openedFolderInputData.getFoldername());

             OpenedFolderOutputData openFolderOutputData = new OpenedFolderOutputData(folder.getName(), false);
             openedFolderPresenter.prepareSuccessView(openFolderOutputData);
            }
        }
}
