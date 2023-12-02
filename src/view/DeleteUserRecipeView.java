package view;

import interface_adapter.delete_userRecipe.DeleteRecipeController;
import interface_adapter.delete_userRecipe.DeleteRecipeState;
import interface_adapter.delete_userRecipe.DeleteRecipeViewModel;
import interface_adapter.remove_recipe.RemoveState;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static javax.swing.JOptionPane.YES_OPTION;

public class DeleteUserRecipeView extends Component implements PropertyChangeListener {

    public final String viewName = "ensure";

    private final DeleteRecipeViewModel deleteRecipeViewModel;

    private final DeleteRecipeController deleteRecipeController;

    public DeleteUserRecipeView(DeleteRecipeViewModel deleteRecipeViewModel,
                                DeleteRecipeController deleteRecipeController) {
        this.deleteRecipeViewModel = deleteRecipeViewModel;
        this.deleteRecipeController = deleteRecipeController;
        deleteRecipeViewModel.addPropertyChangeListener(this);


        JLabel title = new JLabel(DeleteRecipeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

    }









    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getNewValue() instanceof DeleteRecipeState){
            DeleteRecipeState state = (DeleteRecipeState) evt.getNewValue();
            if (state.getRecipeDeleted() != null){
                final JOptionPane optionPane = new JOptionPane(
                        "Do you ensure to delete " + state.getRecipeDeleted()
                                + "?",
                        JOptionPane.QUESTION_MESSAGE,
                        JOptionPane.YES_NO_OPTION);
                Object selectedValue = optionPane.getValue();
                if(selectedValue.equals(YES_OPTION)){
                    deleteRecipeController.execute(state.getRecipeID());
                }

            }

        }

    }
}
