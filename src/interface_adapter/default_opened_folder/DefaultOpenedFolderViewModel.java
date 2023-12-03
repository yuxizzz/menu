package interface_adapter.default_opened_folder;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DefaultOpenedFolderViewModel extends ViewModel {
    public final String TITLE_LABEL = "Opened Default Folder View";
    private static DefaultOpenedFolderState state = new DefaultOpenedFolderState();
    public static final String DELETE_BUTTON_LABEL = "Delete recipe";
    public static final String GET_BUTTON_LABEL = "Get recipe";

    public static final String EDIT_BUTTON_LABEL = "Edit recipe";

    public static final String UPLOAD_BUTTON_LABEL = "Upload recipe";


    private String openedFolder;


    public DefaultOpenedFolderViewModel(String viewName) {
        super(viewName);
    }
    public void setState(DefaultOpenedFolderState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);}


    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public static DefaultOpenedFolderState getState(){return state;}

    public String getDefaultOpenedFolder(){return openedFolder;}

    public void setOpenedFolder(String openedFolder){this.openedFolder = openedFolder;}




}
