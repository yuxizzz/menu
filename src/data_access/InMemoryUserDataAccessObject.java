
package data_access;
import entity.folder.Folder;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import use_case.create_folder.CreateFolderDataAccessInterface;
import use_case.delete_folder.DeleteFolderUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutDataAccessInterface;
import use_case.my_folder.MyFolderDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDataAccessObject implements SignupUserDataAccessInterface, MyFolderDataAccessInterface,
        DeleteFolderUserDataAccessInterface, CreateFolderDataAccessInterface, LoginUserDataAccessInterface,
        LogoutDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();
    private final UserFactory userFactory;

    public InMemoryUserDataAccessObject() {
        this.userFactory = new CommonUserFactory();
        LocalDateTime now = LocalDateTime.now();
        User user1 = userFactory.create("User1", "123", now);
        User user2 = userFactory.create("User2", "321", now);

        users.put(user1.getName(), user1);
        users.put(user2.getName(), user2);

    }

    public int userNum() {
        return users.size();
    }

    /**
     * @param identifier the user's username
     * @return whether the user exists
     */
    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    @Override
    public User get(String username) {
        return users.get(username);
    }

    @Override
    public ArrayList<String> getFolderList(String username) {
        User user = users.get(username);
        ArrayList<String> foldernames = new ArrayList<>();
        for (Folder f : user.getUserFolders()) {
            foldernames.add(f.getName());
        }
        return foldernames;
    }

    /**
     * @param user the data to save
     */
    @Override
    public void save(User user) {
        users.put(user.getName(), user);
    }


    @Override
    public String deleteFolder(String folderName, String username) {
        User user = users.get(username);
        user.removeFolder(folderName);
        return folderName;
    }

    @Override
    public boolean existsByFolder(String identifier, String username) {
        for (Folder f : users.get(username).getUserFolders()) {
            if (identifier == f.getName()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void save(Folder folder, String username) {
        User user = users.get(username);
        user.addFolder(folder);
    }


    @Override
    public void saveData() {

    }

}
