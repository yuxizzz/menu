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



