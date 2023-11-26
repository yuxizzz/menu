package interface_adapter.logout;

public class LogoutState {
    private String username;
    private String error = null;
    public LogoutState(LogoutState copy) {
        username = copy.username;
    }
    public LogoutState() {
    }
    public String getUserID() {
        return username;
    }
    public void setUserID(String username) {
        this.username = username;
    }
    public void setMessageError(String error) {
        this.error = error;
    }
}
