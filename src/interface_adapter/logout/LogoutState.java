package interface_adapter.logout;

public class LogoutState {
    private Integer userID;
    public LogoutState(LogoutState copy) {
        userID = copy.userID;
    }
    public LogoutState() {
    }
    public Integer getUserID() {
        return userID;
    }
    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}
