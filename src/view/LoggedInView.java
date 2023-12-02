package view;

import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutState;
import interface_adapter.logout.LogoutViewModel;
import interface_adapter.my_folder.MyFolderController;
import interface_adapter.my_folder.MyFolderState;
//import interface_adapter.my_folder.MyFolderViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final SearchViewModel searchViewModel;
    private final SearchController searchController;
//    private final MyFolderViewModel myFolderViewModel;
    private final MyFolderController myFolderController;

    private final LogoutViewModel logoutViewModel;
    private final LogoutController logoutController;

    JLabel username;

    final JButton logOut;
    final JButton search;
    final JButton myFolder;

    /**
     * A window with a title and a JButton.
     */
    public LoggedInView(LoggedInViewModel loggedInViewModel,
                        SearchViewModel searchViewModel,
                        SearchController searchController,
//                         MyFolderViewModel myFolderViewModel,
                        MyFolderController myFolderController,
                        LogoutViewModel logoutViewModel,
                        LogoutController logoutController) {
        this.loggedInViewModel = loggedInViewModel;
        this.searchViewModel = searchViewModel;
        this.searchController = searchController;
        // this.myFolderViewModel = myFolderViewModel;
        this.myFolderController = myFolderController;
        this.logoutViewModel = logoutViewModel;
        this.logoutController = logoutController;

        this.loggedInViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Logged In Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Currently logged in: ");
        JLabel username = new JLabel();
        this.username = username;

        JPanel buttons = new JPanel();
        JButton search = new JButton(loggedInViewModel.SEARCH_BUTTON_LABEL);
        JButton myFolder = new JButton(loggedInViewModel.MYFOLDER_BUTTON_LABEL);
        JButton logOut = new JButton(loggedInViewModel.LOGOUT_BUTTON_LABEL);

        this.search = search;
        this.myFolder = myFolder;
        this.logOut = logOut;

        buttons.add(search);
        buttons.add(myFolder);
        buttons.add(logOut);


        search.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(search)){
                            SearchState currentState = searchViewModel.getState();

                            try {
                                searchController.execute(
                                        currentState.getIngredients(),
                                        currentState.getTags()
                                );
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }
        );

//        myFolder.addActionListener(
//                new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(myFolder)){
//                            MyFolderState currentState = myFolderViewModel.getState();
//                            myFolderController.execute(currentState.getUsername());
//                        }
//                    }
//                }
//        );

        logOut.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logOut)){
                            LogoutState currentState = logoutViewModel.getState();
                            logoutController.execute(currentState.getUsername());
                        }
                    }
                }
        );


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(username);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoggedInState state = (LoggedInState) evt.getNewValue();
        username.setText(state.getUsername());
    }
}