package view;

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
    private final JButton collect;

    public RecipeView(GetRecipeViewModel getRecipeViewModel, GetRecipeController getRecipeController) {
        this.getRecipeViewModel = getRecipeViewModel;
        this.getRecipeController = getRecipeController;
        getRecipeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(GetRecipeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        collect = new JButton(GetRecipeViewModel.COLLECT_BUTTON_LABEL);
        buttons.add(collect);

//        collect.addActionListener();

        this.add(title);
        this.add(buttons);
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
//            ClearState clearState = (ClearState) evt.getNewValue();
//            if (clearState.getUserDeleted() != null) {
//                JOptionPane.showMessageDialog(this, clearState.getUserDeleted());
//            }
//        }
    }
}
