<<<<<<< HEAD
package src.use_case.clear_users;
=======
package use_case.clear_users;

// TODO Complete me
>>>>>>> Hong

import java.util.ArrayList;

public class ClearOutputData {
<<<<<<< HEAD
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
=======
    private final String clearedUserNames;

    public ClearOutputData(String clearedUserNames) {
        this.clearedUserNames = clearedUserNames;
    }

    public String getclearedUserNames() {
        return clearedUserNames;
>>>>>>> Hong
    }
}
