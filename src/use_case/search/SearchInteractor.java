package use_case.search;

public class SearchInteractor implements SearchInputBoundary {
    final SearchUserDataAccessInterface searchDataAccessObject;
    final SearchOutputBoundary searchPresenter;

    public SearchInteractor(SearchUserDataAccessInterface searchDataAccessInterface,
                            SearchOutputBoundary searchOutputBoundary) {
        this.searchDataAccessObject = searchDataAccessInterface;
        this.searchPresenter = searchOutputBoundary;
    }

    @Override
    public void execute(SearchInputData signupInputData) {

        // check for searchDataAccesObject  一些checking -> 然后给searchPresenter 反馈

//        if (searchDataAccessObject.existsByName(signupInputData.getUsername())) {
//            userPresenter.prepareFailView("User already exists.");
//        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
//            userPresenter.prepareFailView("Passwords don't match.");
//        } else {
//
//            LocalDateTime now = LocalDateTime.now();
//            User user = userFactory.create(signupInputData.getUsername(), signupInputData.getPassword(), now);
//            userDataAccessObject.save(user);
//
//            SignupOutputData signupOutputData = new SignupOutputData(user.getName(), now.toString(), false);
//            userPresenter.prepareSuccessView(signupOutputData);
//        }
    }
}
