<<<<<<< HEAD
package src.use_case.clear_users;

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

=======
package use_case.clear_users;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import data_access.FileUserDataAccessObject;

// TODO Complete me

import data_access.FileUserDataAccessObject;
import use_case.signup.SignupUserDataAccessInterface;

public class ClearInteractor  implements ClearInputBoundary{

    final ClearUserDataAccessInterface userDataAccessObject;

    final ClearOutputBoundary userPresenter;

    public ClearInteractor(ClearUserDataAccessInterface clearDataAccessInterface,
                           ClearOutputBoundary clearOutputBoundary) {
        this.userDataAccessObject = clearDataAccessInterface;
        this.userPresenter = clearOutputBoundary;
    }

    public void execute() {
        String deletedUserNames = userDataAccessObject.clearUsers();
        ClearOutputData clearOutputData = new ClearOutputData(deletedUserNames);
        userPresenter.prepareSuccessView(clearOutputData);
>>>>>>> Hong
    }
}
