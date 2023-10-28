<<<<<<< HEAD
package src.use_case.login;
=======
package use_case.login;
>>>>>>> Hong

import entity.User;

public interface LoginUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

    User get(String username);
}
