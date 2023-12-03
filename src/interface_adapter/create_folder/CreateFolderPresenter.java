package interface_adapter.create_folder;

import interface_adapter.ViewManagerModel;
import interface_adapter.my_folder.MyFolderState;
import interface_adapter.my_folder.MyFolderViewModel;
import use_case.create_folder.CreateFolderOutputBoundary;
import use_case.create_folder.CreateFolderOutputData;

public class CreateFolderPresenter implements CreateFolderOutputBoundary {
    private final CreateFolderViewModel createFolderViewModel;
    private final MyFolderViewModel myFolderViewModel;
    private ViewManagerModel viewManagerModel;

    public CreateFolderPresenter(CreateFolderViewModel createFolderViewModel, MyFolderViewModel myFolderViewModel, ViewManagerModel viewManagerModel) {
        this.createFolderViewModel = createFolderViewModel;
        this.myFolderViewModel = myFolderViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(CreateFolderOutputData folder) {
        CreateFolderState createFolderState = createFolderViewModel.getState();
        createFolderState.setFoldername(folder.getFoldername());
        createFolderState.setUsername(folder.getUsername());

        this.createFolderViewModel.setState(createFolderState);
        createFolderViewModel.firePropertyChanged();

        MyFolderState myFolderState = myFolderViewModel.getState();
        myFolderState.setUsername(folder.getUsername());
        myFolderState.addFoldernames(folder.getFoldername());

//       myFolderState.getFoldernames();
        this.myFolderViewModel.setState(myFolderState);
//        myFolderViewModel.firePropertyChanged();

        if (createFolderState.getFoldername().isEmpty()) {
            viewManagerModel.setActiveView(createFolderViewModel.getViewName());
        } else {
            viewManagerModel.setActiveView(myFolderViewModel.getViewName());
        }
//        viewManagerModel.setActiveView(createFolderViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        CreateFolderState createFolderState = createFolderViewModel.getState();
        createFolderState.setFoldernameError(error);
        createFolderViewModel.firePropertyChanged();
    }
}
