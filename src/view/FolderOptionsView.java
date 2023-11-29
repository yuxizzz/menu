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
    private HashMap<JButton, String> folderButtons;

    public FolderOptionsView(AddRecipeToFolderViewModel addRecipeToFolderViewModel, AddRecipeToFolderController addRecipeToFolderController) {
        this.addRecipeToFolderController = addRecipeToFolderController;
        this.addRecipeToFolderViewModel = addRecipeToFolderViewModel;
        this.addRecipeToFolderViewModel.addPropertyChangeListener(this);

        //TODO: where do I know about the folderNames?
        JPanel buttons = new JPanel();
        for (String folder: folders) {
            JButton folderButton = new JButton(folder);
            buttons.add(folderButton);
            folderButtons.put(folderButton, folder);
        }
        for (JButton b: folderButtons.keySet()) {
            b.addActionListener(

                    // This creates an anonymous subclass of ActionListener and instantiates it.
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(b)) {
                                AddRecipeToFolderState currentState = addRecipeToFolderViewModel.getState();

                                addRecipeToFolderController.execute(folderButtons.get(b), currentState.getRecipeID(), currentState.getUsername());
                            }
                        }
                    }
            );
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
