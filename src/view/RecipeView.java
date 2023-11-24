package view;

import interface_adapter.clear_users.ClearState;
import interface_adapter.collect_recipe.CollectRecipeController;
import interface_adapter.collect_recipe.CollectRecipeState;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import interface_adapter.get_recipe.GetRecipeController;
import interface_adapter.get_recipe.GetRecipeState;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RecipeView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "recipe view";

    private final GetRecipeViewModel getRecipeViewModel;
    private final CollectRecipeViewModel collectViewModel;
    private final CollectRecipeController collectRecipeController;

    private final GetRecipeController getRecipeController;

    private final JButton collect;


    public RecipeView(GetRecipeViewModel getRecipeViewModel, GetRecipeController getRecipeController,
                      CollectRecipeViewModel collectViewModel, CollectRecipeController collectRecipeController) {
        this.getRecipeViewModel= getRecipeViewModel;
        this.collectViewModel = collectViewModel;
        this.collectRecipeController = collectRecipeController;
        this.getRecipeController = getRecipeController;
        this.collectViewModel.addPropertyChangeListener(this);


//        JLabel title = new JLabel(GetRecipeViewModel.TITLE_LABEL);
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        collect = new JButton(CollectRecipeViewModel.COLLECT_BUTTON_LABEL);
        buttons.add(collect);

        collect.addActionListener(

                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(collect)) {
                            CollectRecipeState currentState = collectViewModel.getState();
                            collectRecipeController.execute(currentState.getRecipeID(), currentState.getUserID());
                        }
                    }
                }
        );



        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

//        this.add(title);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
