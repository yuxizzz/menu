<<<<<<< HEAD
package src.view;

import interface_adapter.clear_users.ClearController;
import interface_adapter.clear_users.ClearState;
import interface_adapter.clear_users.ClearViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
=======
package view;

import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.clear_users.ClearController;
import interface_adapter.clear_users.ClearState;
import interface_adapter.clear_users.ClearViewModel;

>>>>>>> Hong

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";

    private final SignupViewModel signupViewModel;
    private final ClearViewModel clearViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final SignupController signupController;
<<<<<<< HEAD

=======
>>>>>>> Hong
    private final ClearController clearController;

    private final JButton signUp;
    private final JButton cancel;
<<<<<<< HEAD
    private final JButton clear;

    public SignupView(SignupController controller, SignupViewModel signupViewModel,
                      ClearController clearController, ClearViewModel clearViewModel) {

        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        this.clearViewModel = clearViewModel;
        this.clearController = clearController;
        signupViewModel.addPropertyChangeListener(this);
        clearViewModel.addPropertyChangeListener(this);
=======


    private final JButton clear;

    public SignupView(SignupController controller, SignupViewModel signupViewModel,ClearController clearController, ClearViewModel clearViewModel) {

        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        this.clearController = clearController;
        this.clearViewModel = clearViewModel;

        signupViewModel.addPropertyChangeListener(this);
>>>>>>> Hong

        JLabel title = new JLabel(SignupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.PASSWORD_LABEL), passwordInputField);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);

        JPanel buttons = new JPanel();
        signUp = new JButton(SignupViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);
        cancel = new JButton(SignupViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);
<<<<<<< HEAD
=======

>>>>>>> Hong
        clear = new JButton(SignupViewModel.CLEAR_BUTTON_LABEL);
        buttons.add(clear);

        signUp.addActionListener(
<<<<<<< HEAD
                // This creates an anonymous subclass of ActionListener and instantiates it.
=======

>>>>>>> Hong
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(signUp)) {
                            SignupState currentState = signupViewModel.getState();

                            signupController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword(),
                                    currentState.getRepeatPassword()
                            );
                        }
                    }
                }
        );

<<<<<<< HEAD
=======

>>>>>>> Hong
        clear.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(clear)) {
<<<<<<< HEAD
                            ClearState currentState = clearViewModel.getState();
                            clearController.execute();
                        }

=======
                            ClearState clearState = clearViewModel.getState();

                            clearController.execute();

                            String deletedUserNames = clearState.getclearedUserNames();

                            JOptionPane.showMessageDialog(SignupView.this, deletedUserNames.replaceAll(" ", "\n"));
                        }
>>>>>>> Hong
                    }
                }
        );

        cancel.addActionListener(this);

<<<<<<< HEAD
        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the usernameInputField.
        //
        // Notice how it has access to instance variables in the enclosing class!
=======
>>>>>>> Hong
        usernameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        String text = usernameInputField.getText() + e.getKeyChar();
                        currentState.setUsername(text);
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
<<<<<<< HEAD
                        currentState.setPassword(String.valueOf(passwordInputField.getPassword()) + e.getKeyChar());
=======
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
>>>>>>> Hong
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        repeatPasswordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
<<<<<<< HEAD
                        currentState.setRepeatPassword(String.valueOf(repeatPasswordInputField.getPassword()) + e.getKeyChar());
=======
                        currentState.setRepeatPassword(repeatPasswordInputField.getText() + e.getKeyChar());
>>>>>>> Hong
                        signupViewModel.setState(currentState); // Hmm, is this necessary?
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(buttons);
    }

<<<<<<< HEAD
=======


>>>>>>> Hong
    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
<<<<<<< HEAD
        if (evt.getNewValue() instanceof SignupState) {
            SignupState state = (SignupState) evt.getNewValue();
            if (state.getUsernameError() != null) {
                JOptionPane.showMessageDialog(this, state.getUsernameError());
            }
        } else if (evt.getNewValue() instanceof ClearState) {
            ClearState clearState = (ClearState) evt.getNewValue();
            if (clearState.getUserDeleted() != null) {
                JOptionPane.showMessageDialog(this, clearState.getUserDeleted());
            }
        }
    }

=======
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }
>>>>>>> Hong
}