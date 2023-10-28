<<<<<<< HEAD
package src.entity;
=======
package entity;
>>>>>>> Hong

import java.time.LocalDateTime;

public interface UserFactory {
    /** Requires: password is valid. */
    User create(String name, String password, LocalDateTime ltd);
}
