package view;

import entity.search_results.SearchResult;
import interface_adapter.get_recipe.GetRecipeController;
import interface_adapter.get_recipe.GetRecipeState;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.open_recipe.OpenRecipeState;
import interface_adapter.searched.SearchedState;
import interface_adapter.searched.SearchedViewModel;
import interface_adapter.signup.SignupState;

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

public class SearchedView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "searched result";
    private final SearchedViewModel searchedViewModel;
    private final GetRecipeViewModel getRecipeViewModel;
    private final GetRecipeController getRecipeController;

    private final JButton get;

    public SearchedView(SearchedViewModel searchedViewModel,
                        GetRecipeViewModel getRecipeViewModel,
                        GetRecipeController getRecipeController) {
        this.searchedViewModel = searchedViewModel;
        this.getRecipeViewModel = getRecipeViewModel;
        this.getRecipeController = getRecipeController;
        this.searchedViewModel.addPropertyChangeListener(this);

        HashMap<Integer, ArrayList> result = searchedViewModel.getState().getResult();


        JLabel title = new JLabel("Search Results Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        get = new JButton(searchedViewModel.GET_BUTTON_LABEL);

        for (Map.Entry<Integer, ArrayList> entry : result.entrySet()) {
            Integer key = entry.getKey();
            ArrayList value = entry.getValue();
            this.searchedViewModel.addPropertyChangeListener(this);
//        this.openRecipeViewModel.addPropertyChangeListener(this);

            JPanel buttons = new JPanel();
            buttons.add(get);

//        JButton button = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
            get.setBounds(600, 10, 250, 100);
            get.setText("GET");

            get.addActionListener(

                    // This creates an anonymous subclass of ActionListener and instantiates it.
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(get)) {
                                GetRecipeState currentState = getRecipeViewModel.getState();

                                try {
                                    getRecipeController.execute(
                                            currentState.getRecipeID());
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    }
            );
        Image image = null;
        try {
            URL url = new URL((String) value.get(0));
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

            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.add(title);
            this.add(label);
            this.setSize(500, 500);
            this.setVisible(true);
            this.add(buttons);
        }

    }

    @Override
    public void actionPerformed(ActionEvent evt) {System.out.println("Click " + evt.getActionCommand());}

//    TODO
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof SearchedState) {
            SearchedState state = (SearchedState) evt.getNewValue();
        } else if (evt.getNewValue() instanceof GetRecipeState) {
            GetRecipeState getRecipeState = (GetRecipeState) evt.getNewValue();
        }
    }
}
