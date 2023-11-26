package view;

import entity.recipe.Recipe;
import interface_adapter.open_recipe.OpenRecipeController;
import interface_adapter.open_recipe.OpenRecipeState;
import interface_adapter.open_recipe.OpenRecipeViewModel;
import interface_adapter.opened_folder.OpenedFolderState;
import interface_adapter.opened_folder.OpenedFolderViewModel;
import interface_adapter.remove_recipe.RemoveController;
import interface_adapter.remove_recipe.RemoveState;
import interface_adapter.remove_recipe.RemoveViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OpenedFolderView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "opened folder";
    private final OpenedFolderViewModel openedFolderViewModel;

// TODO import open recipe class
    private final OpenRecipeViewModel openRecipeViewModel;
    private final OpenRecipeController openRecipeController;

    private final RemoveViewModel removeViewModel;
    private final RemoveController removeController;

    JLabel foldername;
    final JButton remove;
    final JButton get;


    /**
     * A window with a title and a JButton.
     */
    public OpenedFolderView(OpenedFolderViewModel openedFolderViewModel, RemoveController removeController,
                            OpenRecipeViewModel openRecipeViewModel, OpenRecipeController openRecipeController,
                            RemoveViewModel removeViewModel) {
//    public OpenedFolderView(OpenedFolderViewModel openedFolderViewModel, RemoveController removeController,
//                            RemoveViewModel removeViewModel) {
        this.openedFolderViewModel = openedFolderViewModel;
        this.removeController = removeController;
        this.openRecipeController = openRecipeController;
        this.openRecipeViewModel = openRecipeViewModel;
        this.removeViewModel = removeViewModel;

        JButton get = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
        JButton remove = new JButton(OpenedFolderViewModel.REMOVE_BUTTON_LABEL);
        HashMap<Integer, ArrayList> recipeMap = openedFolderViewModel.getRecipeMap();


        this.remove = remove;
        this.get = get;

        for (Map.Entry<Integer, ArrayList> entry : recipeMap.entrySet()) {
            Integer key = entry.getKey();
            ArrayList value = entry.getValue();
        this.openedFolderViewModel.addPropertyChangeListener(this);
//        this.openRecipeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Opened Folder Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel foldernameInfo = new JLabel("Currently opened folder: ");
        foldername = new JLabel();

        JPanel buttons = new JPanel();
        buttons.add(get);
        buttons.add(remove);

//        JButton button = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
        get.setBounds(600, 10, 250, 100);
        get.setText("GET");

//        JButton buttonremove = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
        remove.setBounds(900, 10, 250, 100);
        remove.setText("REMOVE");

        get.addActionListener(

                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(get)) {
//                            OpenRecipeState currentState = openRecipeViewModel.getState();
//
//                            openRecipeController.execute(
//                                    currentState.getRecipeID(),
//                                    currentState.getName(),
//                                    currentState.getIngredients(),
//                                    currentState.getNutrition(),
//                                    currentState.getInstructions(),
//                                    currentState.getImage(),
//                                    currentState.getRecipeURL()
//                            );
                        }
                    }
                }
        );
        remove.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(remove)) {

                            RemoveState currentState = removeViewModel.getState();
                            removeController.execute();
                        }
                    }
                }
        );

//        TODO need to get information in folder for recipe


            Image image = null;
            try {
                URL url = new URL((String) value.get(1));
//                "https://spoonacular.com/productImages/436359-312x231.jpg"
                image = ImageIO.read(url);
            } catch (IOException e) {
                e.printStackTrace();
            }

//        Border border = BorderFactory.createLineBorder(Color.green,3);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setBounds(150, 250, 150, 150);
            label.setVisible(false);
            label.setText((String) value.get(1));
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

//        button.setFocusable(false);
//        button.setIcon(icon);
//        button.setHorizontalTextPosition(JButton.CENTER);
//        button.setVerticalTextPosition(JButton.BOTTOM);
//        button.setFont(new Font("Comic Sans",Font.BOLD,25));
//        button.setIconTextGap(-15);
//        button.setForeground(Color.cyan);
//        button.setBackground(Color.lightGray);
//        button.setBorder(BorderFactory.createEtchedBorder());
//
//
//        this.setLayout(null);
//        this.setSize(500,500);
//        this.setVisible(true);
//        this.add(button);
//        this.add(label);

            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.add(title);
            this.add(label);
            this.add(foldernameInfo);
            this.add(foldername);
            this.setSize(500, 500);
            this.setVisible(true);
        }
    }

//    example

    @Override


    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        OpenedFolderState state = (OpenedFolderState) evt.getNewValue();
        foldername.setText(state.getFoldername());
    }
}
