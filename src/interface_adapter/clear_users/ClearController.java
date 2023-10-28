<<<<<<< HEAD
package src.interface_adapter.clear_users;

import use_case.clear_users.ClearInputBoundary;
import use_case.clear_users.ClearInputData;

public class ClearController {
    final ClearInputBoundary clearUseCaseInteractor;

    public ClearController(ClearInputBoundary clearUseCaseInteractor) {
        this.clearUseCaseInteractor = clearUseCaseInteractor;
    }

    public void execute() {
        ClearInputData clearInputData = new ClearInputData();
        clearUseCaseInteractor.execute(clearInputData);
=======
package interface_adapter.clear_users;

import data_access.FileUserDataAccessObject;
import use_case.clear_users.ClearInputBoundary;
import use_case.clear_users.ClearUserDataAccessInterface;

// TODO Complete me
public class ClearController {
    final ClearInputBoundary clearUsersInteractor;
    public ClearController(ClearInputBoundary clearUsersInteractor) {
        this.clearUsersInteractor = clearUsersInteractor;
    }
    public void execute() {
        clearUsersInteractor.execute();
>>>>>>> Hong
    }
}
