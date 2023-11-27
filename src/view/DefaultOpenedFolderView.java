package view;

import default_opened_folder.DefaultOpenedFolderState;
import default_opened_folder.DefaultOpenedFolderViewModel;
import interface_adapter.delete_userRecipe.DeleteRecipeController;
import interface_adapter.delete_userRecipe.DeleteRecipeState;
import interface_adapter.delete_userRecipe.DeleteRecipeViewModel;
import interface_adapter.edit_recipe.EditRecipeController;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.open_recipe.OpenRecipeController;
import interface_adapter.open_recipe.OpenRecipeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DefaultOpenedFolderView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "opened default folder";
    private final DefaultOpenedFolderView defaultOpenedFolderView;
    private final OpenRecipeViewModel openRecipeViewModel;
    private final OpenRecipeController openRecipeController;

    private final DeleteRecipeViewModel deleteRecipeViewModel;

    private final DeleteRecipeController deleteRecipeController;

    private final EditRecipeViewModel editRecipeViewModel;

    private final EditRecipeController editRecipeController;

    JLabel defaultfolder;
    final JButton delete;
    final JButton get;
    final JButton edit;

    public DefaultOpenedFolderView(DefaultOpenedFolderView defaultOpenedFolderView,
                                   OpenRecipeViewModel openRecipeViewModel, OpenRecipeController openRecipeController,
                                   DeleteRecipeViewModel deleteRecipeViewModel, DeleteRecipeController deleteRecipeController,
                                   EditRecipeViewModel editRecipeViewModel, EditRecipeController editRecipeController ) {
        this.defaultOpenedFolderView = defaultOpenedFolderView;
        this.openRecipeViewModel = openRecipeViewModel;
        this.openRecipeController = openRecipeController;
        this.deleteRecipeViewModel = deleteRecipeViewModel;
        this.deleteRecipeController = deleteRecipeController;
        this.editRecipeViewModel = editRecipeViewModel;
        this.editRecipeController = editRecipeController;

        JButton delete = new JButton(DefaultOpenedFolderViewModel.DELETE_BUTTON_LABEL);
        JButton get = new JButton(DefaultOpenedFolderViewModel.GET_BUTTON_LABEL);
        JButton edit = new JButton(DefaultOpenedFolderViewModel.EDIT_BUTTON_LABEL);

        this.delete = delete;
        this.get = get;
        this.edit = edit;
        this.defaultOpenedFolderView.addPropertyChangeListener(this);
        JLabel title = new JLabel("Opened Default Folder Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        buttons.add(get);
        buttons.add(delete);
        buttons.add(edit);

        JButton buttonGet = new JButton(DefaultOpenedFolderViewModel.GET_BUTTON_LABEL);
        JButton buttonDelete = new JButton(DefaultOpenedFolderViewModel.DELETE_BUTTON_LABEL);
        JButton buttonEdit = new JButton(DefaultOpenedFolderViewModel.EDIT_BUTTON_LABEL);

        get.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(get)) {
//                            OpenRecipeState currentState = openRecipeViewModel.getState();
//
//                            openRecipeController.execute(
//                                    currentState.getRecipeID()
//
//                            );
                        }
                    }
                });
        delete.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(delete)) {
                            DeleteRecipeState currentState = deleteRecipeViewModel.getState();
                            deleteRecipeController.execute();
                        }
                    }
                });
        edit.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(edit)) {
//                            EditRecipeState currentState = editRecipeViewModel.getState();
//
//                            editRecipeController.execute(
//                                  );
                        }
                    }
                });

    }

    /**
     * React to a button click that results in evt.
     */
    @Override
    public void actionPerformed(ActionEvent evt) {System.out.println("Click " + evt.getActionCommand());

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        DefaultOpenedFolderState state = (DefaultOpenedFolderState) evt.getNewValue();

    }
}
