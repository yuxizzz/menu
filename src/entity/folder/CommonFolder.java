package entity.folder;

import entity.recipe.Recipe;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CommonFolder implements Folder {
    private String foldername;
    private HashMap<Integer, Recipe> recipeMap;
//    private String username;

    public CommonFolder(String foldername) {
        this.foldername = foldername;
        this.recipeMap = new HashMap<Integer, Recipe>();
//        this.username = username;
    }

    public CommonFolder(String foldername, HashMap recipeMap) {
        this.foldername = foldername;
        this.recipeMap = recipeMap;
//        this.username = username;
    }

    @Override
    public String getName() {
        return foldername;
    }
    @Override
    public HashMap<Integer, Recipe> getRecipeMap() {
        return recipeMap;
    }
    @Override
    public void removeRecipe(Integer recipeId) {
        if (recipeMap.containsKey(recipeId)) {
            recipeMap.remove(recipeId);
        }
    }
    @Override
    public void addRecipe(Integer recipeID, Recipe recipe) {
        recipeMap.put(recipeID, recipe);
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @NotNull
    @Override
    public Iterator<Recipe> iterator() {
        return new recipeIterator();
    }

    private class recipeIterator implements Iterator<Recipe> {

        private int current = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */

        @Override
        public boolean hasNext() {
            return current < recipeMap.size();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         */
        @Override
        public Recipe next() {
            Recipe res;

            // List.get(i) throws an IndexOutBoundsException if
            // we call it with i >= contacts.size().
            // But Iterator's next() needs to throw a
            // NoSuchElementException if there are no more elements.
            try {
                List<Recipe> list = new ArrayList<>(recipeMap.values());
                res = list.get(current);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
            current += 1;
            return res;
        }
    }
}
