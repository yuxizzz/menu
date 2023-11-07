package use_case.open_folder;

import entity.User;
import use_case.login.LoginInputData;
import use_case.login.LoginOutputData;

public class OpenFolderInteractor {
    final OpenFolderDataAccessInterface folderDataAccessObject;
    final OpenFolderOutputBoundary openFolderPresenter;

    public OpenFolderInteractor(OpenFolderDataAccessInterface folderDataAccessInterface,
                                OpenFolderOutputBoundary openFolderOutputBoundary, OpenFolderDataAccessInterface folderDataAccessObject, OpenFolderOutputBoundary openFolderPresenter) {
        this.folderDataAccessObject = folderDataAccessObject;
        this.openFolderPresenter = openFolderPresenter;
    }

    public void execute(OpenFolderInputData openFolderInputData) {
        String foldername = OpenFolderInputData.getFoldername();
        if (!folderDataAccessObject.existsByName(foldername)) {
            openFolderPresenter.prepareFailView(foldername + ": Folder does not exist.");
        }else {

            Folder user = folderDataAccessObject.get(OpenFolderInputData.getFoldername());

            OpenFolderOutputData openFolderOutputData = new OpenFolderOutputData(folder.getName(), false);
            OpenFolderPresenter.prepareSuccessView(openFolderOutputData);
            }
        }
}
