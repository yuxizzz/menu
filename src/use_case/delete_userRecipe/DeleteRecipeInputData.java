package use_case.delete_userRecipe;

public class DeleteRecipeInputData {
    final private Integer recipeid;
    public DeleteRecipeInputData(Integer recipeid){this.recipeid = recipeid;}

    Integer getRecipeid(){return recipeid;}
}
