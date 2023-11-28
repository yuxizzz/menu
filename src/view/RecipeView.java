package view;

import interface_adapter.collect_recipe.CollectRecipeController;
import interface_adapter.collect_recipe.CollectRecipeState;
import interface_adapter.collect_recipe.CollectRecipeViewModel;

import interface_adapter.get_recipe.GetRecipeController;
import interface_adapter.get_recipe.GetRecipeState;
import interface_adapter.get_recipe.GetRecipeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//TODO: collect button addActionListener
//TODO: actionPerformed message "Try again"

public class RecipeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "recipe";
    private final GetRecipeViewModel getRecipeViewModel;
    private final GetRecipeController getRecipeController;
    private final CollectRecipeViewModel collectViewModel;
    private final CollectRecipeController collectRecipeController;
    private final JButton collect;

    public RecipeView(GetRecipeViewModel getRecipeViewModel, GetRecipeController getRecipeController,
                      CollectRecipeViewModel collectViewModel, CollectRecipeController collectRecipeController) {
        this.getRecipeViewModel = getRecipeViewModel;
        this.getRecipeController = getRecipeController;
        getRecipeViewModel.addPropertyChangeListener(this);

        this.collectViewModel = collectViewModel;
        this.collectRecipeController = collectRecipeController;
        this.collectViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(GetRecipeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        collect = new JButton(GetRecipeViewModel.COLLECT_BUTTON_LABEL);
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
        this.add(title);
        this.add(buttons);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Try again");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof GetRecipeState) {
            GetRecipeState state = (GetRecipeState) evt.getNewValue();
            if (state.getRecipeError() != null) {
                JOptionPane.showMessageDialog(this, state.getRecipeError());
            } else {
                JOptionPane.showMessageDialog(this, state.getRecipe());
            }
        }
//        else if (evt.getNewValue() instanceof ClearState) {
//          clearState = (ClearState) evt.getNewValue();
//            if (clearState.getUserDeleted() != null) {
//                JOptionPane.showMessageDialog(this, clearState.getUserDeleted());
//            }
//        }
    }
}
