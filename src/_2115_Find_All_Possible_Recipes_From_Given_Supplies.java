import java.util.*;

class RecipeFinder {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // Step 1: Create graph structures
        Map<String, List<String>> ingredientToRecipe = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();

        // Step 2: Initialize in-degree count for each recipe
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            inDegree.put(recipe, ingredients.get(i).size()); // Track required ingredients count

            for (String ing : ingredients.get(i)) {
                ingredientToRecipe.putIfAbsent(ing, new ArrayList<>());
                ingredientToRecipe.get(ing).add(recipe); // Add dependency
            }
        }

        // Step 3: Initialize queue with available supplies
        Queue<String> queue = new LinkedList<>();
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();

        // Add all initial supplies to the queue
        queue.addAll(available);

        // Step 4: Process the queue using BFS (Topological Sort)
        while (!queue.isEmpty()) {
            String ingredient = queue.poll();

            if (inDegree.containsKey(ingredient)) { // If it's a recipe, add to result
                result.add(ingredient);
            }

            // Reduce in-degree of dependent recipes
            if (ingredientToRecipe.containsKey(ingredient)) {
                for (String recipe : ingredientToRecipe.get(ingredient)) {
                    inDegree.put(recipe, inDegree.get(recipe) - 1);

                    // If all ingredients are available, add recipe to queue
                    if (inDegree.get(recipe) == 0) {
                        queue.add(recipe);
                        available.add(recipe);
                    }
                }
            }
        }

        return result;
    }
}
public class _2115_Find_All_Possible_Recipes_From_Given_Supplies
{
    public static void main(String[] args) {
        RecipeFinder obj = new RecipeFinder();

        String[] recipes = {"bread", "sandwich", "burger"};
        List<List<String>> ingredients = Arrays.asList(
                Arrays.asList("yeast", "flour"),
                Arrays.asList("bread", "ham"),
                Arrays.asList("sandwich", "meat")
        );
        String[] supplies = {"yeast", "flour", "meat", "ham"};

        System.out.println(obj.findAllRecipes(recipes, ingredients, supplies));
    }
}
