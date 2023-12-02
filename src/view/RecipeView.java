package view;

import interface_adapter.collect_recipe.CollectRecipeController;
import interface_adapter.collect_recipe.CollectRecipeState;
import interface_adapter.collect_recipe.CollectRecipeViewModel;

import interface_adapter.get_recipe.GetRecipeController;
import interface_adapter.get_recipe.GetRecipeState;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.login.LoginState;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;

//TODO: collect button addActionListener
//TODO: actionPerformed message "Try again"
//TODO: propertyChange

public class RecipeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "recipe";
    private final GetRecipeViewModel getRecipeViewModel;
    private final CollectRecipeViewModel collectViewModel;
    private final CollectRecipeController collectRecipeController;
    private final JButton collect;

    public RecipeView(GetRecipeViewModel getRecipeViewModel,
                      CollectRecipeViewModel collectViewModel, CollectRecipeController collectRecipeController) {
        this.getRecipeViewModel = getRecipeViewModel;
//        this.getRecipeController = getRecipeController;
        getRecipeViewModel.addPropertyChangeListener(this);

        this.collectViewModel = collectViewModel;
        this.collectRecipeController = collectRecipeController;
        this.collectViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(GetRecipeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        collect = new JButton(GetRecipeViewModel.COLLECT_BUTTON_LABEL);
        buttons.add(collect);

        /**
         * set information of recipe and image (url)
         */
//        JLabel label = new JLabel();
        String recipeName = this.getRecipeViewModel.getState().getRecipename();
        String ingredients = this.getRecipeViewModel.getState().getIngredients();
        String nutrition = this.getRecipeViewModel.getState().getNutrition();
        String instructions = this.getRecipeViewModel.getState().getInstructions();
        String recipeULR = this.getRecipeViewModel.getState().getRecipeULR();
        String recipeImage = this.getRecipeViewModel.getState().getImage();

        Image image = null;
        try {
            URL url = new URL(recipeULR);
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
//set recipe name
        label.setFont(new Font(recipeName, Font.PLAIN, 20));
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
        this.add(title);
        this.add(buttons);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Try again");
    }


    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof GetRecipeState) {
            GetRecipeState state = (GetRecipeState) evt.getNewValue();
            if (state.getRecipeIDError() != null) {
                JOptionPane.showMessageDialog(this, state.getRecipeIDError());
            }
        }
        else if (evt.getNewValue() instanceof CollectRecipeState) {
            CollectRecipeState state = (CollectRecipeState) evt.getNewValue();

        }
    }
}
