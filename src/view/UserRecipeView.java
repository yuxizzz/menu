package view;

import interface_adapter.collect_recipe.CollectRecipeController;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import interface_adapter.get_recipe.GetRecipeController;
import interface_adapter.get_recipe.GetRecipeViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//TODO: to do open recipe

public class UserRecipeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "recipe";
    private final GetRecipeViewModel getRecipeViewModel;
    private final GetRecipeController getRecipeController;
    private final CollectRecipeViewModel collectViewModel;
    private final CollectRecipeController collectRecipeController;
//    private final JButton collect;

    public UserRecipeView(GetRecipeViewModel getRecipeViewModel, GetRecipeController getRecipeController,
                          CollectRecipeViewModel collectViewModel, CollectRecipeController collectRecipeController) {
        this.getRecipeViewModel = getRecipeViewModel;
        this.getRecipeController = getRecipeController;

        this.collectViewModel = collectViewModel;
        this.collectRecipeController = collectRecipeController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
