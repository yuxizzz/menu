package use_case.login;


import entity.user.User;

import java.util.ArrayList;

public interface LoginUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

    User get(String username);

    ArrayList<String> getFolderList(String username);
}
