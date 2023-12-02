package view;

import interface_adapter.get_recipe.GetRecipeController;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.searched.SearchedState;
import interface_adapter.searched.SearchedViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchedView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "searched result";
    private final SearchedViewModel searchedViewModel;
    private final GetRecipeViewModel getRecipeViewModel;
    private final GetRecipeController getRecipeController;

    private final JButton get;

    public SearchedView(SearchedViewModel searchedViewModel, GetRecipeViewModel getRecipeViewModel,
                        GetRecipeController getRecipeController) {
        this.searchedViewModel = searchedViewModel;
        this.getRecipeViewModel = getRecipeViewModel;
        this.getRecipeController = getRecipeController;
        this.searchedViewModel.addPropertyChangeListener(this);

        JPanel buttons = new JPanel();

        get = new JButton(searchedViewModel.GET_BUTTON_LABEL);
        buttons.add(get);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        get.addActionListener(this
                // TODO: Get Recipe to be implemented
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        this.add(buttons);



    }

    @Override
    public void actionPerformed(ActionEvent evt) {System.out.println("Click " + evt.getActionCommand());}

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchedState state = (SearchedState) evt.getNewValue();

    }
}
