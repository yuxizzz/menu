<<<<<<< HEAD
package src.use_case.signup;
=======
package use_case.signup;
>>>>>>> Hong

import entity.User;

public interface SignupUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);
}
