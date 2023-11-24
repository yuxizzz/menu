package interface_adapter.logout;

import interface_adapter.signup.SignupState;
import view.MyFolderView;

public class LogoutViewModel {

    private LogoutState state = new LogoutState();
    public void addPropertyChangeListener(MyFolderView myFolderView) {
    }

    public LogoutState getState() {
        return state;
    }
}
