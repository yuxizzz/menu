package interface_adapter.search;

public class SearchState {
    private String keyWords = "";
    private String keyWordsError = null;

    public SearchState(SearchState copy) {
        keyWords = copy.keyWords;
        keyWordsError = copy.keyWordsError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public SearchState() {
    }

    public String getKeyWords() {
        return keyWords;
    }

    public String getKeyWordsError() {
        return keyWordsError;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public void setKeyWordsError(String keyWordsError) {
        this.keyWordsError = keyWordsError;
    }

    @Override
    public String toString() {
        return "SearchState{" +
                "KeyWords='" + keyWords + '\'' +
                '}';
    }
}
