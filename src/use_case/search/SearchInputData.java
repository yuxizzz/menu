package use_case.search;

public class SearchInputData {
    final private String keyWords;

    public SearchInputData(String keyWords) {
        this.keyWords = keyWords;
    }

    String getKeyWords() {
        return keyWords;
    }
}
