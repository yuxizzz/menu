package view;

import interface_adapter.search.SearchController;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "search recipes";
    private final SearchViewModel searchViewModel;
    final JTextField ingredientsInputField = new JTextField();
    final JTextField tagInputField = new JTextField();
    private final JLabel tagErrorField = new JLabel();

    private final JLabel ingredientsErrorField = new JLabel();
    final JButton search;
    final JButton cancel;

    final JButton myFolder;

    private final SearchController searchController;

    public SearchView(SearchViewModel searchViewModel, SearchController searchController) {

        this.searchController = searchController;
        this.searchViewModel = searchViewModel;
        this.searchViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SearchViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel IngredientRecipesInfo = new LabelTextPanel(
                new JLabel(SearchViewModel.INGREDIENT_BUTTON_LABEL), ingredientsInputField);
        LabelTextPanel searchRecipesInfo = new LabelTextPanel(
                new JLabel(SearchViewModel.TAG_BUTTON_LABEL), tagInputField);

        JPanel buttons = new JPanel();
        search = new JButton(SearchViewModel.SEARCH_BUTTON_LABEL);
        cancel = new JButton(SearchViewModel.CANCEL_BUTTON_LABEL);
        myFolder = new JButton(SearchViewModel.MYFOLDER_BUTTON_LABEL);
        buttons.add(search);
        buttons.add(cancel);
        buttons.add(myFolder);

        search.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(search)) {
                            SearchState currentState = searchViewModel.getState();

                            try {
                                searchController.execute(currentState.getIngredients(), currentState.getTags());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
        );

        cancel.addActionListener(this
        // TODO: CANCEL button to be implemented
        );

        myFolder.addActionListener(this
                // TODO: MY FOLDER to be implemented
                );

        ingredientsInputField.addKeyListener(
            new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    SearchState currentState = searchViewModel.getState();
                    String text = ingredientsInputField.getText() + e.getKeyChar();
                    currentState.setIngredients(text);
                    searchViewModel.setState(currentState);
                }

                @Override
                public void keyPressed(KeyEvent e){
                }

                @Override
                public void keyReleased(KeyEvent e){
                }
            });


        tagInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SearchState currentState = searchViewModel.getState();
                        String text = tagInputField.getText() + e.getKeyChar();
                        currentState.setTags(text);
                        searchViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e){
                    }

                    @Override
                    public void keyReleased(KeyEvent e){
                    }
                });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(searchRecipesInfo);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchState state = (SearchState) evt.getNewValue();
        if (state.getTagsError() != null) {
            JOptionPane.showMessageDialog(this, state.getTagsError());
        }
        if (state.getIngredientsError() != null) {
            JOptionPane.showMessageDialog(this, state.getIngredientsError());
        }
    }}


