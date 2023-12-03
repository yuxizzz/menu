package view;

import interface_adapter.collect_recipe.CollectRecipeController;
import interface_adapter.collect_recipe.CollectRecipeState;
import interface_adapter.collect_recipe.CollectRecipeViewModel;
import interface_adapter.edit_recipe.EditRecipeController;
import interface_adapter.edit_recipe.EditRecipeState;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.get_recipe.GetRecipeController;
import interface_adapter.get_recipe.GetRecipeState;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.open_recipe.OpenRecipeController;
import interface_adapter.open_recipe.OpenRecipeState;
import interface_adapter.open_recipe.OpenRecipeViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;

//TODO: to do open recipe

public class UserRecipeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "open user recipe";

    private final OpenRecipeViewModel openRecipeViewModel;
    private final OpenRecipeController openRecipeController;



    private final CollectRecipeViewModel collectViewModel;
    private final CollectRecipeController collectRecipeController;



    private final EditRecipeViewModel editRecipeViewModel;
    private final EditRecipeController editRecipeController;

//    private final JButton collect;
    final JButton edit;
    final JButton collect;



    public UserRecipeView(OpenRecipeViewModel openRecipeViewModel,
                          OpenRecipeController openRecipeController,
                          CollectRecipeViewModel collectViewModel,
                          CollectRecipeController collectRecipeController,
                          EditRecipeController editRecipeController,
                          EditRecipeViewModel editRecipeViewModel) {
        this.openRecipeViewModel = openRecipeViewModel;
        this.openRecipeController = openRecipeController;
        openRecipeViewModel.addPropertyChangeListener(this);



        this.collectViewModel = collectViewModel;
        this.collectRecipeController = collectRecipeController;
        this.editRecipeController = editRecipeController;
        this.editRecipeViewModel = editRecipeViewModel;

        JLabel title = new JLabel(GetRecipeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        collect = new JButton(OpenRecipeViewModel.COLLECTRecipe_BUTTON_LABEL);

        edit = new JButton(OpenRecipeViewModel.EDITRecipe_BUTTON_LABEL);
        buttons.add(collect);
        buttons.add(edit);


        /**
         * set information of recipe and image (url)
         */
//        JLabel label = new JLabel();
        String recipeName = this.openRecipeViewModel.getState().getRecipename();
        String ingredients = this.openRecipeViewModel.getState().getIngredients();
        String nutrition = this.openRecipeViewModel.getState().getNutrition();
        String instructions = this.openRecipeViewModel.getState().getInstructions();
        String recipeURL = this.openRecipeViewModel.getState().getRecipeurl();
        String recipeImage = this.openRecipeViewModel.getState().getImage();

        Image image = null;
        try {
            URL url = new URL(recipeURL);
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Set JLabel to show information of the recipe
         */
        JLabel label = new JLabel(new ImageIcon(image));

//        label.setText(recipeName);

        label.setBounds(150, 250, 150, 150);
        label.setVisible(true);
// set information?
        label.setText(recipeName);
        label.setText(ingredients);
        label.setText(nutrition);
        label.setText(instructions);
        // set text of label label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        // set text LEFT,CENTER, RIGHT of imageicon
        label.setVerticalTextPosition(JLabel.TOP);
        // set text TOP,CENTER, BOTTOM of imageicon
//        label.setForeground(new Color(0x00FF00));
        // set font color of text
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        // set font of text
        label.setIconTextGap(-25);
        // set gap of text to image
        label.setBackground(Color.black);
        // set background color
        label.setOpaque(true);
        // display background color
//        label.setBorder(border);
        // sets border of label (not image+text)
        label.setVerticalAlignment(JLabel.CENTER);
        // set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER);
        // set horizontal position of icon+text within label
        label.setBounds(100, 10, 250, 250);







        collect.addActionListener(

                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(collect)) {
                            CollectRecipeState currentState = collectViewModel.getState();
                            collectRecipeController.execute(currentState.getRecipeID(), currentState.getUsername());
                }
            }
        }

        );
        edit.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(edit)) {
                            EditRecipeState currentState = editRecipeViewModel.getState();
                            editRecipeController.execute(currentState.getRecipeID(),currentState.getRecipename(),
                                    currentState.getIngredients(),currentState.getNutrition(),currentState.getInstructions(),
                                    currentState.getImage(),currentState.getRecipeurl(),currentState.getUsername());
                        }
                    }
                }
        );
        this.add(title);
        this.add(buttons);
        this.add(label);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }




    @Override
    public void actionPerformed(ActionEvent e) {JOptionPane.showConfirmDialog(this, "Try again");}

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */



    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof OpenRecipeState) {
            OpenRecipeState state = (OpenRecipeState) evt.getNewValue();
            if (state.getRecipeIDError() != null) {
                JOptionPane.showMessageDialog(this, state.getRecipeIDError());
            }

        }
        else if (evt.getNewValue() instanceof CollectRecipeState) {
            CollectRecipeState state = (CollectRecipeState) evt.getNewValue();

            if (state.getCollectSuccessMsg() != null) {
                JOptionPane.showMessageDialog(this, state.getCollectSuccessMsg());
            }

        }else if (evt.getNewValue() instanceof EditRecipeState){
            EditRecipeState state = (EditRecipeState) evt.getNewValue();

            if (state.getRecipeIDError() != null) {
                JOptionPane.showMessageDialog(this, state.getRecipeIDError());
            }

        }

    }
}
