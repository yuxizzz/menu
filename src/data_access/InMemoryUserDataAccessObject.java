
package data_access;
import entity.User;
import use_case.search.SearchUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;
import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDataAccessObject {

    private final Map<String, User> users = new HashMap<>();
    //implements SignupUserDataAccessInterface, SearchUserDataAccessInterface
    /**
     * @param identifier the user's username
     * @return whether the user exists
     */

    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    /**
     * @param user the data to save
     */

    public void save(User user) {
        users.put(user.getName(), user);
    }


}
