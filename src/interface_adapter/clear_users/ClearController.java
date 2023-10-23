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
    }
}
