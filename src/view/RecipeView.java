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


public class RecipeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "recipe";
    private final GetRecipeViewModel getRecipeViewModel;
    private final CollectRecipeViewModel collectViewModel;
    private final CollectRecipeController collectRecipeController;
    private final JButton collect;

//    private String recipeURL = "";

    public RecipeView(GetRecipeViewModel getRecipeViewModel,
                      CollectRecipeViewModel collectViewModel, CollectRecipeController collectRecipeController) throws IOException {
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
        String recipeURL = this.getRecipeViewModel.getState().getRecipeURL();
        String recipeImage = this.getRecipeViewModel.getState().getImage();

        Image image = null;
        URL url = new URL(recipeImage);
        image = ImageIO.read(url);
        JLabel label = new JLabel(new ImageIcon(image));

        /**
         * Set JLabel to show information of the recipe
         */


//        label.setText(recipeName);

        label.setBounds(150, 250, 150, 150);
        label.setVisible(true);
// set name
        label.setText(recipeName);
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

// set text

        JLabel label1 = new JLabel(ingredients);
        label1.setVisible(true);
//        label1.setBackground(Color.red);
//        label1.setText(ingredients);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.TOP);
        label1.setOpaque(true);
        label1.setVerticalAlignment(JLabel.CENTER);
        // set vertical position of icon+text within label
        label1.setHorizontalAlignment(JLabel.CENTER);
        // set horizontal position of icon+text within label
        label1.setBounds(100, 510, 900, 250);

        JLabel label2 = new JLabel(nutrition);
        label2.setVisible(true);
//        label2.setBackground(Color.cyan);
//        label2.setText(nutrition);
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setVerticalTextPosition(JLabel.TOP);
        label2.setOpaque(true);
        label2.setVerticalAlignment(JLabel.CENTER);
        // set vertical position of icon+text within label
        label2.setHorizontalAlignment(JLabel.CENTER);
        // set horizontal position of icon+text within label
        label2.setBounds(350, 10, 250, 250);

        JLabel label3 = new JLabel(instructions);
        label3.setVisible(true);
//        label3.setBackground(Color.ORANGE);
//        label3.setText(instructions);
        label3.setHorizontalTextPosition(JLabel.CENTER);
        label3.setVerticalTextPosition(JLabel.TOP);
        label3.setOpaque(true);
        label3.setVerticalAlignment(JLabel.CENTER);
        // set vertical position of icon+text within label
        label3.setHorizontalAlignment(JLabel.CENTER);
        // set horizontal position of icon+text within label
        label3.setBounds(350, 260, 250, 250);


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
        this.add(label);
        this.add(label1);
        this.add(label2);
        this.add(label3);
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

            if (state.getCollectSuccessMsg() != null) {
                JOptionPane.showMessageDialog(this, state.getCollectSuccessMsg());
            }

        }
    }
}
