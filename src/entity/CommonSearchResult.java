package entity;

public class CommonSearchResult implements SearchResult {
    private String image;
    private String recipeid;
    private String title;
    private String imageType;


    public CommonSearchResult(String image, String recipeid, String title, String imageType) {
        this.image = image;
        this.recipeid = recipeid;
        this.title = title;
        this.imageType = imageType;
    }

    public static SearchResultBuilder builder() {
        return new SearchResultBuilder();
    }

    public static class SearchResultBuilder {
        private String image;
        private String recipeid;
        private String title;
        private String imageType;

        SearchResultBuilder() {
        }

        public SearchResultBuilder image(String image) {
            this.image = image;
            return this;
        }

        public SearchResultBuilder recipeid(String recipeid) {
            this.recipeid = recipeid;
            return this;
        }

        public SearchResultBuilder title(String title) {
            this.title = title;
            return this;
        }

        public SearchResultBuilder imageType(String imageType) {
            this.imageType = imageType;
            return this;
        }

        public SearchResult build() {
            return new CommonSearchResult(image, recipeid, title, imageType);
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
