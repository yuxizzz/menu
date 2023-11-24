package view;

import interface_adapter.ViewModel;
import interface_adapter.get_recipe.GetRecipeController;
import interface_adapter.get_recipe.GetRecipeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//TODO: collect button addActionListener

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

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
