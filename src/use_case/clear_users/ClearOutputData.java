package src.use_case.clear_users;

import java.util.ArrayList;

public class ClearOutputData {
    private boolean useCaseFailed;
    private String userDeleted;

    public ClearOutputData(ArrayList<String> userDeleted, boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
        this.userDeleted = "";
        for (String s: userDeleted) {
            this.userDeleted += s + "\n";
        }

    }

    public String getUserDeleted() {
        return userDeleted;
    }
}
