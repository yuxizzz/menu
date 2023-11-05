package use_case.clear_users;

import java.util.ArrayList;

public class ClearInteractor implements ClearInputBoundary {
    final ClearUserDataAccessInterface userDataAccessObject;
    final ClearOutputBoundary userPresenter;

    public ClearInteractor(ClearUserDataAccessInterface userDataAccessInterface, ClearOutputBoundary clearOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.userPresenter = clearOutputBoundary;
    }

    @Override
    public void execute(ClearInputData clearInputData) {

        ArrayList<String> deletedUsers = userDataAccessObject.clearAllUser();
        ClearOutputData clearOutputData = new ClearOutputData(deletedUsers, false);
        userPresenter.prepareSuccessView(clearOutputData);

    }
}
