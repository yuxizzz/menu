package interface_adapter.my_folder;

import interface_adapter.ViewManagerModel;
import interface_adapter.open_folder.OpenFolderState;
import interface_adapter.open_folder.OpenFolderViewModel;
import interface_adapter.opened_folder.OpenedFolderState;
import interface_adapter.opened_folder.OpenedFolderViewModel;
import use_case.my_folder.MyFolderOutputBoundary;
import use_case.my_folder.MyFolderOutputData;
import use_case.open_folder.OpenFolderOutputBoundary;
import use_case.open_folder.OpenFolderOutputData;

public class MyFolderPresenter implements MyFolderOutputBoundary {

    private final MyFolderViewModel myFolderViewModel;
    private final OpenedFolderViewModel openedFolderViewModel;
    private ViewManagerModel viewManagerModel;

    public MyFolderPresenter(ViewManagerModel viewManagerModel,
                                   MyFolderViewModel myFolderViewModel,
                                   OpenedFolderViewModel openedFolderViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.myFolderViewModel = myFolderViewModel;
        this.openedFolderViewModel = openedFolderViewModel;
        }

        @Override
        public void prepareSuccessView(MyFolderOutputData response) {
            // On success, switch to the logged in view.

            OpenedFolderState openedFolderState = openedFolderViewModel.getState();
            openedFolderState.setFoldername(response.getFoldername());
            this.openedFolderViewModel.setState(openedFolderState);
            this.openedFolderViewModel.firePropertyChanged();

            this.viewManagerModel.setActiveView(openedFolderViewModel.getViewName());
            this.viewManagerModel.firePropertyChanged();
        }

        @Override
        public void prepareFailView(String error) {
            MyFolderState myFolderState = myFolderViewModel.getState();
            myFolderState.setFoldernameError(error);
            myFolderViewModel.firePropertyChanged();
        }

}
