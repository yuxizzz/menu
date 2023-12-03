package use_case.edit_recipe;

public interface EditOutputBoundary {



    void prepareSuccessView(EditOutputData message);





    void prepareFailView(String error);
}
