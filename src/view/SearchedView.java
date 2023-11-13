package view;

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

    private final JButton getRecipe1;
    private final JButton cancel;

    public SearchedView(SearchedViewModel searchedViewModel) {
        this.searchedViewModel = searchedViewModel;
        this.searchedViewModel.addPropertyChangeListener(this);

        JPanel buttons = new JPanel();
        cancel = new JButton(searchedViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        getRecipe1 = new JButton(searchedViewModel.GET_BUTTON_LABEL);
        buttons.add(getRecipe1);

        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        getRecipe1.addActionListener(this
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
