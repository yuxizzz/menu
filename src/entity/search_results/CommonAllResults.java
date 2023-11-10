package entity.search_results;

import java.util.HashMap;

public class CommonAllResults implements AllResults {
    private HashMap<Object, SearchResult> results;


    public CommonAllResults(HashMap<Object, SearchResult> results) {
        this.results = results;
    }

    public static CommonAllResults.AllResultsBuilder builder() {
        return new CommonAllResults.AllResultsBuilder();
    }

    public static class AllResultsBuilder {
        private HashMap<Object, SearchResult> results;

        AllResultsBuilder() {
        }

        public CommonAllResults.AllResultsBuilder results(HashMap<Object, SearchResult> results) {
            this.results = results;
            return this;
        }



        public CommonAllResults build() {
            return new CommonAllResults(results);
        }
    }

    @Override
    public String toString() {
        return "Results{" +
                "results='" + results + '}';
    }

    public HashMap<Object, SearchResult> getSearchResults() {
        return results;
    }


}
