package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonSearchResults {
    private String image;
    private String recipeid;
    private String title;
    private String imageType;


    public CommonSearchResults(String image, String recipeid, String title, String imageType) {
        this.image = image;
        this.recipeid = recipeid;
        this.title = title;
        this.imageType = imageType;
    }

    public static SearchResultsBuilder builder() {
        return new SearchResultsBuilder();
    }

    public static class SearchResultsBuilder {
        private String image;
        private String recipeid;
        private String title;
        private String imageType;

        SearchResultsBuilder() {
        }

        public SearchResultsBuilder image(String image) {
            this.image = image;
            return this;
        }

        public SearchResultsBuilder recipeid(String recipeid) {
            this.recipeid = recipeid;
            return this;
        }

        public SearchResultsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public SearchResultsBuilder imageType(String imageType) {
            this.imageType = imageType;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "image='" + image + '\'' +
                ", recipe id='" + recipeid + '\'' +
                ", title=" + title + '\'' +
                ", imageType='" + imageType + '\'' +
                '}';
    }

    public String getImage() {
        return image;
    }

    public String getRecipeid() {
        return recipeid;
    }

    public String getTitle() {
        return title;
    }

    public String getImageType() {
        return imageType;
    }

}
