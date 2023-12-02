package view;

import interface_adapter.create_folder.CreateFolderController;
import interface_adapter.create_folder.CreateFolderState;
import interface_adapter.create_folder.CreateFolderViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CreateFolderView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "create folder";
    private final CreateFolderViewModel createFolderViewModel;
    private final JTextField foldernameInputField = new JTextField(15);
    private final CreateFolderController createFolderController;
    private final JButton create;

    public CreateFolderView(CreateFolderViewModel createFolderViewModel, CreateFolderController createFolderController) {
        this.createFolderViewModel = createFolderViewModel;
        this.createFolderController = createFolderController;
        createFolderViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(CreateFolderViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel foldernameInfor = new LabelTextPanel(
                new JLabel(CreateFolderViewModel.FOLDERNAME_LABEL), foldernameInputField);

        JPanel buttons = new JPanel();
        create = new JButton(CreateFolderViewModel.CREATEFOLDER_BUTTON_LABEL);
        buttons.add(create);

        create.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(create)) {
                            CreateFolderState currentState = createFolderViewModel.getState();

                            createFolderController.execute(
                                    currentState.getFoldername(),
                                    currentState.getUsername()
                            );
                        }
                    }
                }
        );
        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the foldernameInputField.
        //
        // Notice how it has access to instance variables in the enclosing class!
        foldernameInputField.addKeyListener(
                new KeyListener() {

                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreateFolderState currentState = createFolderViewModel.getState();
                        String text = foldernameInputField.getText() + e.getKeyChar();
                        currentState.setFoldername(text);
                        createFolderViewModel.setState(currentState);
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
        this.add(foldernameInfor);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Create not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof CreateFolderState) {
            CreateFolderState state = (CreateFolderState) evt.getNewValue();
            if (state.getFoldernameError() != null) {
                JOptionPane.showMessageDialog(this, state.getFoldernameError());
            }

        }
    }
}
