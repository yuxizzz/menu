package use_case.remove_recipe;

public class RemoveInputData {

    final private Integer recipeID;

    final private String username;

    final private String foldername;


    public RemoveInputData(Integer recipeID, String username, String foldername){

        this.recipeID = recipeID;
        this.username = username;
        this.foldername = foldername;
    }

    Integer getRemovedRecipeID(){


        return recipeID;


    }

    String getUsername(){
        return  username;
    }

    String getFoldername(){
        return foldername;
    }

}
