package src.interface_adapter.clear_users;

public class ClearState {
    private String message = "";
    private String messageError = null;
    private String users = null;

    public ClearState() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserDeleted(String userDeleted) {
        this.users = userDeleted;
    }

    public String getUserDeleted() {
        return this.users;
    }

    public void setMessageError(String error) {
        this.messageError = error;
    }
}
