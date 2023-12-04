package view;

import interface_adapter.default_opened_folder.DefaultOpenedFolderState;
import interface_adapter.default_opened_folder.DefaultOpenedFolderViewModel;
import interface_adapter.delete_userRecipe.DeleteRecipeController;
import interface_adapter.delete_userRecipe.DeleteRecipeState;
import interface_adapter.delete_userRecipe.DeleteRecipeViewModel;
import interface_adapter.edit_recipe.EditRecipeController;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.get_recipe.GetRecipeState;
import interface_adapter.open_recipe.OpenRecipeController;
import interface_adapter.open_recipe.OpenRecipeState;
import interface_adapter.open_recipe.OpenRecipeViewModel;
import interface_adapter.upload_recipe.UploadRecipeController;
import interface_adapter.upload_recipe.UploadRecipeState;
import interface_adapter.upload_recipe.UploadRecipeViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DefaultOpenedFolderView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "opened default folder";
    private final DefaultOpenedFolderViewModel defaultOpenedFolderViewModel;
    private final OpenRecipeViewModel openRecipeViewModel;
    private final OpenRecipeController openRecipeController;

    private final DeleteRecipeViewModel deleteRecipeViewModel;

    private final DeleteRecipeController deleteRecipeController;

    private final UploadRecipeViewModel uploadRecipeViewModel;
    private final UploadRecipeController uploadRecipeController;



    JLabel defaultfolder;
    final JButton delete;
    final JButton get;
    final JButton upload;

    private HashMap<Integer, ArrayList> userRecipes;

    public DefaultOpenedFolderView(DefaultOpenedFolderViewModel defaultOpenedFolderViewModel,
                                   OpenRecipeViewModel openRecipeViewModel,
                                   OpenRecipeController openRecipeController,
                                   DeleteRecipeViewModel deleteRecipeViewModel,
                                   DeleteRecipeController deleteRecipeController,
                                   UploadRecipeViewModel uploadRecipeViewModel,
                                   UploadRecipeController uploadRecipeController) {
        this.defaultOpenedFolderViewModel = defaultOpenedFolderViewModel;
        this.openRecipeViewModel = openRecipeViewModel;
        this.openRecipeController = openRecipeController;
        this.deleteRecipeViewModel = deleteRecipeViewModel;
        this.deleteRecipeController = deleteRecipeController;
        this.uploadRecipeController = uploadRecipeController;
        this.uploadRecipeViewModel = uploadRecipeViewModel;

        this.defaultOpenedFolderViewModel.addPropertyChangeListener(this);
        this.deleteRecipeViewModel.addPropertyChangeListener(this);
        this.uploadRecipeViewModel.addPropertyChangeListener(this);


        JButton delete = new JButton(DefaultOpenedFolderViewModel.DELETE_BUTTON_LABEL);
        JButton get = new JButton(DefaultOpenedFolderViewModel.GET_BUTTON_LABEL);
        JButton upload = new JButton(DefaultOpenedFolderViewModel.UPLOAD_BUTTON_LABEL);

        this.delete = delete;
        this.get = get;
        this.upload = upload;

        JLabel title = new JLabel("Opened Default Folder Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel foldernameInfo = new JLabel("Currently opened folder: My Recipes");
        defaultfolder = new JLabel();

        HashMap<Integer, ArrayList> recipeMap = defaultOpenedFolderViewModel.getState().getRecipeMap();
        this.userRecipes = recipeMap;
        Integer count = 0;

        //HashMap<String, ArrayList<JButton>> addButtons = new HashMap<>();
        for (Map.Entry<Integer, ArrayList> entry : userRecipes.entrySet()) {
            Integer key = entry.getKey();
            ArrayList value = entry.getValue();

        this.openRecipeViewModel.addPropertyChangeListener(this);

            JLabel recipeName = new JLabel(value.get(0).toString());



            JPanel buttons = new JPanel();
            buttons.add(get);
            buttons.add(delete);



//        JButton button = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
            get.setBounds(600, 10, 250, 100);
            get.setText("GET");

//        JButton buttonremove = new JButton(OpenedFolderViewModel.GET_BUTTON_LABEL);
            delete.setBounds(900, 10, 250, 100);
            delete.setText("DELETE");


            get.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(get)) {
                            OpenRecipeState currentState = openRecipeViewModel.getState();

                            try {
                                openRecipeController.execute(
                                        (Integer) value.get(7),
                                        currentState.getUsername(),
                                        currentState.getFoldername()
                               );
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            );
            delete.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(delete)) {
                            DeleteRecipeState currentState = deleteRecipeViewModel.getState();
                            deleteRecipeController.execute((Integer) value.get(7),
                                    currentState.getUsername());
                        }
                    }
                });

//
//            Image image = null;
//            try {
//                URL url = new URL((String) value.get(0));
////                "https://spoonacular.com/productImages/436359-312x231.jpg"
//                image = ImageIO.read(url);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

////        Border border = BorderFactory.createLineBorder(Color.green,3);
//            JLabel label = new JLabel(new ImageIcon(image));
//            label.setBounds(150, 250, 150, 150);
//            label.setVisible(false);
//            label.setText((String) value.get(1));
//            // set text of label label.setIcon(image);
//            label.setHorizontalTextPosition(JLabel.CENTER);
//            // set text LEFT,CENTER, RIGHT of imageicon
//            label.setVerticalTextPosition(JLabel.TOP);
//            // set text TOP,CENTER, BOTTOM of imageicon
////        label.setForeground(new Color(0x00FF00));
//            // set font color of text
//            label.setFont(new Font("MV Boli", Font.PLAIN, 20));
//            // set font of text
//            label.setIconTextGap(-25);
//            // set gap of text to image
//            label.setBackground(Color.black);
//            // set background color
//            label.setOpaque(true);
//            // display background color
////        label.setBorder(border);
//            // sets border of label (not image+text)
//            label.setVerticalAlignment(JLabel.CENTER);
//            // set vertical position of icon+text within label
//            label.setHorizontalAlignment(JLabel.CENTER);
//            // set horizontal position of icon+text within label
//            label.setBounds(100, 10, 250, 250);

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
//            this.add(label);
            this.add(foldernameInfo);
//            this.add(defaultfolder);
            this.setSize(500, 500);
            this.setVisible(true);
            this.add(buttons);
            this.add(recipeName);
        }

        upload.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(upload)) {
                            UploadRecipeState currentState = uploadRecipeViewModel.getState();
                            uploadRecipeController.execute(currentState.getRecipename(),
                                    currentState.getIngredients(),
                                    currentState.getNutrition(),
                                    currentState.getInstructions(),
                                    currentState.getImage(),
                                    currentState.getRecipeurl(),
                                    currentState.getRecipeID(),
                                    currentState.getUsername());
                        }
                    }
                });
        this.add(upload);
    }

        /**

     * React to a button click that results in evt.
     */
    @Override
    public void actionPerformed(ActionEvent evt) {System.out.println("Click " + evt.getActionCommand());

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof GetRecipeState){
            GetRecipeState state = (GetRecipeState) evt.getNewValue();
            if (state.getRecipeIDError() != null){
                JOptionPane.showMessageDialog(this, state.getRecipeIDError());
            }
        } else if(evt.getNewValue() instanceof DeleteRecipeState){
            DeleteRecipeState state = (DeleteRecipeState) evt.getNewValue();
        }else if (evt.getNewValue() instanceof UploadRecipeState){
            UploadRecipeState state = (UploadRecipeState) evt.getNewValue();
        }

    }


}
