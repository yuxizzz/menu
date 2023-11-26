package interface_adapter.logout;

public class LogoutState {
    private String username;
    private String error = null;
    public LogoutState(LogoutState copy) {
        username = copy.username;
    }
    public LogoutState() {
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setMessageError(String error) {
        this.error = error;
    }
}
