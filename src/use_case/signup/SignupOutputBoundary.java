<<<<<<< HEAD
package src.use_case.signup;
=======
package use_case.signup;
>>>>>>> Hong

public interface SignupOutputBoundary {
    void prepareSuccessView(SignupOutputData user);

    void prepareFailView(String error);
}