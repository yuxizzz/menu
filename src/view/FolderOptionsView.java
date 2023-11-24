package view;

import interface_adapter.collect_recipe.CollectRecipeState;
import interface_adapter.login.LoginState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FolderOptionsView extends JPanel implements ActionListener, PropertyChangeListener {
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

    }

    private void setFields(CollectRecipeState state) {
    }
}
