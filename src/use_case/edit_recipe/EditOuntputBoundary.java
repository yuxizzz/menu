package use_case.edit_recipe;

public interface EditOuntputBoundary {



    void prepareSuccessView(EditOutputData message);





    void prepareFailView(String error);
}
