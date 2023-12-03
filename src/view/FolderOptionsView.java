package view;

import interface_adapter.add_recipe_to_folder.AddRecipeToFolderController;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderState;
import interface_adapter.add_recipe_to_folder.AddRecipeToFolderViewModel;
import interface_adapter.collect_recipe.CollectRecipeState;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;

public class FolderOptionsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "folder options view";
    private final AddRecipeToFolderViewModel addRecipeToFolderViewModel;
    private final AddRecipeToFolderController addRecipeToFolderController;

    private ArrayList<String> folders;
    private JButton folderButton;

    public FolderOptionsView(AddRecipeToFolderViewModel addRecipeToFolderViewModel, AddRecipeToFolderController addRecipeToFolderController) {
        this.addRecipeToFolderController = addRecipeToFolderController;
        this.addRecipeToFolderViewModel = addRecipeToFolderViewModel;
        this.addRecipeToFolderViewModel.addPropertyChangeListener(this);

        int counts = 0;
        JPanel buttons = new JPanel();
        folders = addRecipeToFolderViewModel.getState().getFolderNames();
        for (String foldername: folders) {
            folderButton = new JButton(foldername);
            folderButton.setBounds(600, 10 + counts, 100, 40);
            buttons.add(folderButton);
            folderButton.addActionListener(
                    // This creates an anonymous subclass of ActionListener and instantiates it.
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(folderButton)) {
                                AddRecipeToFolderState currentState = addRecipeToFolderViewModel.getState();

                                addRecipeToFolderController.execute(foldername,
                                        currentState.getRecipeID(), currentState.getUsername());
                            }
                        }
                    }
            );
            counts += 50;
        }

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        CollectRecipeState state = (CollectRecipeState) evt.getNewValue();
        folders = state.getFolderNames();
    }
}
