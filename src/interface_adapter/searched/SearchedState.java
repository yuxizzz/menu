package interface_adapter.searched;

public class SearchedState {
    private String keywords = "";
    public SearchedState(SearchedState copy){keywords = copy.keywords;}
    public SearchedState(){}

    public String getKeywords(){return keywords;}
    public void setKeywords(String keywords){this.keywords = keywords;}
}
