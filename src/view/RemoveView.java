package view;

import interface_adapter.remove_recipe.RemoveController;
import interface_adapter.remove_recipe.RemoveState;
import interface_adapter.remove_recipe.RemoveViewModel;
import interface_adapter.signup.SignupViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static javax.swing.JOptionPane.YES_OPTION;

public class RemoveView extends Component implements PropertyChangeListener {
    public final String viewName = "ensure";
    private final RemoveViewModel removeViewModel;

    private final RemoveController removeController;

    public RemoveView(RemoveViewModel removeViewModel, RemoveController removeController) {
        this.removeViewModel = removeViewModel;
        this.removeController = removeController;
        removeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SignupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
    }







    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getNewValue() instanceof RemoveState){
            RemoveState state = (RemoveState) evt.getNewValue();
            if (state.getRecipeRemoved() != null){
                final JOptionPane optionPane = new JOptionPane(
                        "Do you ensure to remove " + state.getRecipeRemoved()
                                + "?",
                        JOptionPane.QUESTION_MESSAGE,
                        JOptionPane.YES_NO_OPTION);
                Object selectedValue = optionPane.getValue();
                if(selectedValue.equals(YES_OPTION)){
                    removeController.execute();
                }

            }

        }

    }
}
