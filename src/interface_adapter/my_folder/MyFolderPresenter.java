package interface_adapter.my_folder;

import interface_adapter.ViewManagerModel;
import interface_adapter.create_folder.CreateFolderState;
import interface_adapter.create_folder.CreateFolderViewModel;
import interface_adapter.delete_folder.DeleteFolderState;
import interface_adapter.delete_folder.DeleteFolderViewModel;
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
    private final OpenFolderViewModel openFolderViewModel;
    private final DeleteFolderViewModel deleteFolderViewModel;
    private final CreateFolderViewModel createFolderViewModel;
    private ViewManagerModel viewManagerModel;

    public MyFolderPresenter(ViewManagerModel viewManagerModel,
                                   MyFolderViewModel myFolderViewModel,
                             DeleteFolderViewModel deleteFolderViewModel,
                                   OpenFolderViewModel openFolderViewModel,
                             CreateFolderViewModel createFolderViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.myFolderViewModel = myFolderViewModel;
        this.openFolderViewModel = openFolderViewModel;
        this.deleteFolderViewModel = deleteFolderViewModel;
        this.createFolderViewModel = createFolderViewModel;
        }

        @Override
        public void prepareSuccessView(MyFolderOutputData response) {
            // On success, switch to the

            MyFolderState myFolderState = myFolderViewModel.getState();
            myFolderState.setUsername(response.getUserName());
            myFolderState.setFoldernames(response.getFoldernames());
            this.myFolderViewModel.setState(myFolderState);
            this.myFolderViewModel.firePropertyChanged();


            OpenFolderState openFolderState = openFolderViewModel.getState();
            openFolderState.setUsername(myFolderState.getUsername());
            this.openFolderViewModel.setState(openFolderState);
//            this.openFolderViewModel.firePropertyChanged();

            DeleteFolderState deleteFolderState = deleteFolderViewModel.getState();
            deleteFolderState.setUsername(myFolderState.getUsername());
            this.deleteFolderViewModel.setState(deleteFolderState);
//            this.deleteFolderViewModel.firePropertyChanged();

            CreateFolderState createFolderState = createFolderViewModel.getState();
            createFolderState.setUsername(myFolderState.getUsername());
            this.createFolderViewModel.setState(createFolderState);
//            this.createFolderViewModel.firePropertyChanged();

            this.viewManagerModel.setActiveView(myFolderViewModel.getViewName());
            this.viewManagerModel.firePropertyChanged();
        }

        @Override
        public void prepareFailView(String error) {
            MyFolderState myFolderState = myFolderViewModel.getState();
            myFolderState.setFoldernameError(error);
            myFolderViewModel.firePropertyChanged();
        }

}
