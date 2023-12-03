package view;

import interface_adapter.edit_recipe.EditRecipeController;
import interface_adapter.edit_recipe.EditRecipeState;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.upload_recipe.UploadRecipeController;
import interface_adapter.upload_recipe.UploadRecipeState;
import interface_adapter.upload_recipe.UploadRecipeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;









public class EditView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "edit recipe";

    private final EditRecipeViewModel editRecipeViewModel;

    private final EditRecipeController editRecipeController;

    private final JTextField nameInputField = new JTextField(15);
    private final JTextField ingredientsInputField = new JTextField(15);
    private final JTextField nutritionInputField = new JTextField(15);
    private final JTextField instructionsInputField = new JTextField(15);
    private final JTextField imageInputField = new JTextField(15);
    private final JTextField recipeurlInputField = new JTextField(15);
    private final JTextField recipeidInputField = new JTextField(15);
    private final JButton edit;




//    private final JButton cancel;

    public EditView(EditRecipeViewModel editRecipeViewModel, EditRecipeController
            editRecipeController) {

        this.editRecipeViewModel = editRecipeViewModel;
        this.editRecipeController = editRecipeController;


        editRecipeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(EditRecipeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel(EditRecipeViewModel.RECIPENANME_LABEL), nameInputField);

        LabelTextPanel ingredientsInfo = new LabelTextPanel(
                new JLabel(EditRecipeViewModel.INGREDIENTS_LABEL), ingredientsInputField);

        LabelTextPanel nutritionInfo = new LabelTextPanel(
                new JLabel(EditRecipeViewModel.NUTRITION_LABEL), nutritionInputField);

        LabelTextPanel instructionsInfo = new LabelTextPanel(
                new JLabel(EditRecipeViewModel.INSTRUCTIONS_LABEL), instructionsInputField);

        LabelTextPanel imageInfo = new LabelTextPanel(
                new JLabel(EditRecipeViewModel.IMAGE_LABEL), imageInputField);

        LabelTextPanel recipeurlPasswordInfo = new LabelTextPanel(
                new JLabel(EditRecipeViewModel.RECIPEURL_LABEL), recipeurlInputField);

        LabelTextPanel recipeidInfo = new LabelTextPanel(
                new JLabel(EditRecipeViewModel.RECIPEID_LABEL), recipeidInputField);




        JPanel buttons = new JPanel();
        this.edit = new JButton(EditRecipeViewModel.EDIT_BUTTON_LABEL);
        buttons.add(edit);
//        this.cancel = new JButton(EditRecipeViewModel.CANCEL_BUTTON_LABEL);
//        buttons.add(cancel);




        edit.addActionListener(

                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(edit)) {
                            EditRecipeState currentState = editRecipeViewModel.getState();

                            editRecipeController.execute(
                                    currentState.getRecipeID(),
                                    currentState.getRecipename(),
                                    currentState.getIngredients(),
                                    currentState.getNutrition(),
                                    currentState.getInstructions(),
                                    currentState.getImage(),
                                    currentState.getRecipeurl(),
                                    currentState.getUsername()

                            );
                        }
                    }
                }
        );

//        cancel.addActionListener(this);




        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the usernameInputField.
        //
        // Notice how it has access to instance variables in the enclosing class!






        nameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditRecipeState currentState = editRecipeViewModel.getState();
                        String text = nameInputField.getText() + e.getKeyChar();
                        currentState.setRecipename(text);
                        editRecipeViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });





        ingredientsInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditRecipeState currentState = editRecipeViewModel.getState();
                        String text = ingredientsInputField.getText() + e.getKeyChar();
                        currentState.setIngredients(text);
                        editRecipeViewModel.setState(currentState);
                    }




                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        nutritionInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditRecipeState currentState = editRecipeViewModel.getState();
                        String text = nutritionInputField.getText() + e.getKeyChar();
                        currentState.setNutrition(text);
                        editRecipeViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });






        instructionsInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditRecipeState currentState = editRecipeViewModel.getState();
                        String text = instructionsInputField.getText() + e.getKeyChar();
                        currentState.setInstructions(text);
                        editRecipeViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });






        imageInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditRecipeState currentState = editRecipeViewModel.getState();
                        String text = imageInputField.getText() + e.getKeyChar();
                        currentState.setImage(text);
                        editRecipeViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });






        recipeurlInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditRecipeState currentState = editRecipeViewModel.getState();
                        String text = recipeurlInputField.getText() + e.getKeyChar();
                        currentState.setRecipeurl(text);
                        editRecipeViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });





        recipeidInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditRecipeState currentState = editRecipeViewModel.getState();
                        Integer text = Integer.valueOf(recipeidInputField.getText() + e.getKeyChar());
                        currentState.setRecipeID(text);
                        editRecipeViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });








        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(nameInfo);
        this.add(nutritionInfo);
        this.add(instructionsInfo);
        this.add(ingredientsInfo);
        this.add(imageInfo);
        this.add(recipeidInfo);
        this.add(recipeurlPasswordInfo);
        this.add(buttons);





    }




    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");


    }





    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof EditRecipeState) {
            EditRecipeState state = (EditRecipeState) evt.getNewValue();
            if (state.getRecipeIDError() != null) {
                JOptionPane.showMessageDialog(this, state.getRecipeIDError());
            }else if (state.getRecipenameError() != null){
                JOptionPane.showMessageDialog(this, state.getRecipeIDError());
            }
        }

    }
}
