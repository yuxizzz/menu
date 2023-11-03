package use_case.search;

public interface SearchOutputBoundary {
    void prepareSuccessView(SearchOutputData message);

    void prepareFailView(String error);
}
