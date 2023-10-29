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

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "search recipe";
    private final SearchViewModel searchViewModel;

    final JTextField searchInputField = new JTextField();
    private final JLabel searchErrorField = new JLabel();
    final JButton search;
    final JButton cancel;
    private final SearchController searchController;

    public SearchView(SearchViewModel searchViewModel, SearchController searchController) {

        this.searchController = searchController;
        this.searchViewModel = searchViewModel;
        this.searchViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SearchViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel searchRecipesInfo = new LabelTextPanel(
                new JLabel(SearchViewModel.SEARCH_BUTTON_LABEL), searchInputField);

        JPanel buttons = new JPanel();
        search = new JButton(SearchViewModel.SEARCH_BUTTON_LABEL);
        cancel = new JButton(SearchViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(search);

        search.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(search)) {
                            SearchState currentState = searchViewModel.getState();

                            searchController.execute(currentState.getKeyWords());
                        }
                    }
                }
        );

        cancel.addActionListener(this);

        searchInputField.addKeyListener(
            new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    SearchState currentState = searchViewModel.getState();
                    String text = searchInputField.getText() + e.getKeyChar();
                    currentState.setKeyWords(text);
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
        if (state.getKeyWordsError() != null) {
            JOptionPane.showMessageDialog(this, state.getKeyWordsError());
        }
    }}


