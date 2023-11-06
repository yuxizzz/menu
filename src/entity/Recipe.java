package entity;

import java.util.List;
import java.util.Map;

public interface Recipe {
    String getName();
    String getIngredients();
    String getNutrition();
    String getInstructions();
    List<String> getTag();
    Map<String, Boolean> getAllergy();
}
