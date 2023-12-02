package interface_adapter.default_opened_folder;

import interface_adapter.opened_folder.OpenedFolderState;

import java.util.ArrayList;
import java.util.HashMap;

public class DefaultOpenedFolderState {
        private String foldername = "";
        private String username = "";

        private HashMap<Integer, ArrayList> recipeMap;


        public DefaultOpenedFolderState(interface_adapter.default_opened_folder.DefaultOpenedFolderState copy) {
            foldername = copy.foldername;
            username = copy.username;
        }

        // Because of the previous copy constructor, the default constructor must be explicit.
        public DefaultOpenedFolderState() {
        }

        public String getFoldername() {
            return foldername;
        }

        public void setFoldername(String foldername) {

            this.foldername = foldername;

        }
        public void setFoldernameError(String error) {
        }

        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }

        public void setRecipeMap(HashMap<Integer, ArrayList> recipeMap) {
            this.recipeMap = recipeMap;
        }

        public HashMap<Integer, ArrayList> getRecipeMap(){
            return recipeMap;
        }
    }
