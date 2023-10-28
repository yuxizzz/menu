<<<<<<< HEAD
package src.use_case.login;
=======
package use_case.login;
>>>>>>> Hong

public interface LoginOutputBoundary {
    void prepareSuccessView(LoginOutputData user);

    void prepareFailView(String error);
}