package view;

import interface_adapter.edit_recipe.EditRecipeState;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
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

public class UploadView extends JPanel implements ActionListener, PropertyChangeListener {
   public final String viewName = "upload recipe";

   private final UploadRecipeViewModel uploadRecipeViewModel;

   private final UploadRecipeController uploadRecipeController;

   private final JTextField nameInputField = new JTextField(15);
    private final JTextField ingredientsInputField = new JTextField(15);
    private final JTextField nutritionInputField = new JTextField(15);
    private final JTextField instructionsInputField = new JTextField(15);
    private final JTextField imageInputField = new JTextField(15);
    private final JTextField recipeurlInputField = new JTextField(15);
    private final JTextField recipeidInputField = new JTextField(15);

    private final JButton upload;

    private final JButton cancel;

    public UploadView(UploadRecipeViewModel uploadRecipeViewModel, UploadRecipeController uploadRecipeController, JButton upload, JButton cancel) {
        this.uploadRecipeViewModel = uploadRecipeViewModel;
        this.uploadRecipeController = uploadRecipeController;


        uploadRecipeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(UploadRecipeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel(UploadRecipeViewModel.RECIPENANME_LABEL), nameInputField);
        LabelTextPanel ingredientsInfo = new LabelTextPanel(
                new JLabel(UploadRecipeViewModel.INGREDIENTS_LABEL), ingredientsInputField);
        LabelTextPanel nutritionInfo = new LabelTextPanel(
                new JLabel(UploadRecipeViewModel.NUTRITION_LABEL), nutritionInputField);
        LabelTextPanel instructionsInfo = new LabelTextPanel(
                new JLabel(UploadRecipeViewModel.INSTRUCTIONS_LABEL), instructionsInputField);
        LabelTextPanel imageInfo = new LabelTextPanel(
                new JLabel(UploadRecipeViewModel.IMAGE_LABEL), imageInputField);
        LabelTextPanel recipeurlPasswordInfo = new LabelTextPanel(
                new JLabel(UploadRecipeViewModel.RECIPEURL_LABEL), recipeurlInputField);
        LabelTextPanel recipeidInfo = new LabelTextPanel(
                new JLabel(UploadRecipeViewModel.RECIPEID_LABEL), recipeidInputField);

        JPanel buttons = new JPanel();
        this.upload = new JButton(UploadRecipeViewModel.UPLOAD_BUTTON_LABEL);
        buttons.add(upload);
        this.cancel = new JButton(UploadRecipeViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        upload.addActionListener(

                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(upload)) {
                            UploadRecipeState currentState = uploadRecipeViewModel.getState();

                            uploadRecipeController.execute(
                                    currentState.getRecipename(),
                                    currentState.getIngredients(),

                                    currentState.getNutrition(),
                                    currentState.getInstructions(),
                                    currentState.getImage(),
                                    currentState.getRecipeurl(),
                                    currentState.getRecipeID(),
                                    currentState.getUser()


                            );
                        }
                    }
                }
        );

        cancel.addActionListener(this);

        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the usernameInputField.
        //
        // Notice how it has access to instance variables in the enclosing class!

//TODO: implement the JTextLabels
        nameInputField.addKeyListener(
                new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                UploadRecipeState currentState = uploadRecipeViewModel.getState();
                String text = nameInputField.getText() + e.getKeyChar();
                currentState.setRecipename(text);
                uploadRecipeViewModel.setState(currentState);
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
                        UploadRecipeState currentState = uploadRecipeViewModel.getState();
                        String text = ingredientsInputField.getText() + e.getKeyChar();
                        currentState.setIngredients(text);
                        uploadRecipeViewModel.setState(currentState);
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
                        UploadRecipeState currentState = uploadRecipeViewModel.getState();
                        String text = nutritionInputField.getText() + e.getKeyChar();
                        currentState.setNutrition(text);
                        uploadRecipeViewModel.setState(currentState);
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
                        UploadRecipeState currentState = uploadRecipeViewModel.getState();
                        String text = instructionsInputField.getText() + e.getKeyChar();
                        currentState.setInstructions(text);
                        uploadRecipeViewModel.setState(currentState);
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
                        UploadRecipeState currentState = uploadRecipeViewModel.getState();
                        String text = imageInputField.getText() + e.getKeyChar();
                        currentState.setImage(text);
                        uploadRecipeViewModel.setState(currentState);
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
                        UploadRecipeState currentState = uploadRecipeViewModel.getState();
                        String text = recipeurlInputField.getText() + e.getKeyChar();
                        currentState.setRecipeurl(text);
                        uploadRecipeViewModel.setState(currentState);
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
                        UploadRecipeState currentState = uploadRecipeViewModel.getState();
                        Integer text = Integer.valueOf(recipeidInputField.getText() + e.getKeyChar());
                        currentState.setRecipeID(text);
                        uploadRecipeViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

    }






    @Override
    public void actionPerformed(ActionEvent e) {JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");

    }





    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof UploadRecipeState) {
            UploadRecipeState state = (UploadRecipeState) evt.getNewValue();
            if (state.getRecipeIDError() != null) {
                JOptionPane.showMessageDialog(this, state.getRecipeIDError());
            }else if (state.getRecipenameError() != null){
                JOptionPane.showMessageDialog(this, state.getRecipeIDError());
            }
        }

    }
}
