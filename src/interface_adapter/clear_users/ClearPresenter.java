<<<<<<< HEAD
package src.interface_adapter.clear_users;
import interface_adapter.ViewManagerModel;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearOutputData;


public class ClearPresenter implements ClearOutputBoundary {
    private final ClearViewModel clearViewModel;
    private ViewManagerModel viewManagerModel;


    public ClearPresenter(ViewManagerModel viewManagerModel,
                          ClearViewModel clearViewModel) {
        this.clearViewModel = clearViewModel;
        this.viewManagerModel = viewManagerModel;

    }

    @Override
    public void prepareSuccessView(ClearOutputData response){
        //on success switch to clear view & display deleted users
        ClearState clearState = clearViewModel.getState();
        clearState.setUserDeleted(response.getUserDeleted());
        this.clearViewModel.setState(clearState);
        clearViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(clearViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {
        ClearState clearState = clearViewModel.getState();
        clearState.setMessageError(error);
        clearViewModel.firePropertyChanged();
    }
}
=======
package interface_adapter.clear_users;


import use_case.clear_users.*;
import interface_adapter.ViewManagerModel;


public class ClearPresenter implements ClearOutputBoundary{
    private final ClearViewModel clearViewModel;
    private ViewManagerModel viewManagerModel;

    public ClearPresenter(ViewManagerModel viewManagerModel,
                          ClearViewModel clearViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.clearViewModel = clearViewModel;
    }

    public void prepareSuccessView(ClearOutputData response) {
        // On success, switch to the clear view.
        // Give response to the view model
        ClearState clearState = clearViewModel.getState();
        clearState.setclearedUserNames(response.getclearedUserNames());
        this.clearViewModel.setState(clearState);
        this.clearViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(clearViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void prepareFailView(String error) {
        ClearState clearState = clearViewModel.getState();
        clearViewModel.firePropertyChanged();
    }
}



>>>>>>> Hong
