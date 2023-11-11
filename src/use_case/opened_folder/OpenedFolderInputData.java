package use_case.opened_folder;

import entity.recipe.Recipe;

import java.awt.*;
import java.util.HashMap;

public class OpenedFolderInputData {

    final private Integer recipeid;
    final private HashMap<Integer, Boolean> pressremove;

    public OpenedFolderInputData(Integer recipeid, HashMap<Integer, Boolean> pressremove) {
        this.pressremove = pressremove;
        this.recipeid = recipeid;
    }


    Integer getRecipeid() {
        return recipeid;
    }
    HashMap<Integer, Boolean> getPressRemove(){
        return pressremove;
    }

}

