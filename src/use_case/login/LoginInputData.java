<<<<<<< HEAD
package src.use_case.login;
=======
package use_case.login;
>>>>>>> Hong

public class LoginInputData {

    final private String username;
    final private String password;

    public LoginInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

}
