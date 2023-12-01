package view;

import interface_adapter.delete_userRecipe.DeleteRecipeState;
import interface_adapter.get_recipe.GetRecipeController;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.open_recipe.OpenRecipeController;
import interface_adapter.open_recipe.OpenRecipeViewModel;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

//TODO: to do open recipe

public class UserRecipeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "open user recipe";

    private final OpenRecipeViewModel openRecipeViewModel;
    private final OpenRecipeController openRecipeController;


    private final GetRecipeViewModel getRecipeViewModel;
    private final GetRecipeController getRecipeController;

//    private final JButton collect;
    final JButton edit;
    final JButton delete;
    final JButton upload;

    private final String recipename;
    private final Integer recipeID;

    public UserRecipeView(OpenRecipeViewModel openRecipeViewModel,
                          OpenRecipeController openRecipeController,
                          GetRecipeViewModel getRecipeViewModel,
                          GetRecipeController getRecipeController,
                          //CollectRecipeViewModel collectViewModel,
                          // CollectRecipeController collectRecipeController,
                          JButton edit, JButton delete, JButton upload,
                          String recipename, Integer recipeID) {
        this.openRecipeViewModel = openRecipeViewModel;
        this.openRecipeController = openRecipeController;
        this.getRecipeViewModel = getRecipeViewModel;
        this.getRecipeController = getRecipeController;
        this.edit = edit;
        this.delete = delete;
        this.upload = upload;
        this.recipename = recipename;
        this.recipeID = recipeID;

       // this.collectViewModel = collectViewModel;
       // this.collectRecipeController = collectRecipeController;



        JPanel buttons = new JPanel();
        delete = new JButton(OpenRecipeViewModel.DELETERecipe_BUTTON_LABEL);
        edit = new JButton(OpenRecipeViewModel.EDITRecipe_BUTTON_LABEL);
        upload = new JButton(OpenRecipeViewModel.UPLOADRecipe_BUTTON_LABEL);
        buttons.add(delete);
        buttons.add(edit);
        buttons.add(upload);

        delete.addActionListener(this
        //TODO: DELETE button to be implemented
        );
        edit.addActionListener(this
        //TODO: EDIT button to be implemented
        );

        upload.addActionListener(this

                //TODO:UPLOAD button to be implemented
           );
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
