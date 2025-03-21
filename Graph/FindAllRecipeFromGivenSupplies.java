package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * 			Leetcode Medium 2115. Find All Possible Recipes from Given Supplies
 * 
 * 
You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. A recipe can also be an ingredient for other recipes, i.e., ingredients[i] may contain a string that is in recipes.

You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.

Return a list of all the recipes that you can create. You may return the answer in any order.

Note that two recipes may contain each other in their ingredients.

 

Example 1:

Input: recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
Output: ["bread"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
*/
public class FindAllRecipeFromGivenSupplies {
	
	 public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients,
             String[] supplies) {
List<String> ans = new ArrayList<>();
Set<String> suppliesSet = new HashSet<>();
for (final String supply : supplies)
suppliesSet.add(supply);
Map<String, List<String>> graph = new HashMap<>();
Map<String, Integer> inDegrees = new HashMap<>();


for (int i = 0; i < recipes.length; ++i)
for (final String ingredient : ingredients.get(i))
if (!suppliesSet.contains(ingredient)) {
graph.putIfAbsent(ingredient, new ArrayList<>());
graph.get(ingredient).add(recipes[i]);
inDegrees.merge(recipes[i], 1, Integer::sum);
}


Queue<String> q = Arrays.stream(recipes)
  .filter(recipe -> inDegrees.getOrDefault(recipe, 0) == 0)
  .collect(Collectors.toCollection(ArrayDeque::new));

while (!q.isEmpty()) {
final String u = q.poll();
ans.add(u);
if (!graph.containsKey(u))
continue;
for (final String v : graph.get(u)) {
inDegrees.merge(v, -1, Integer::sum);
if (inDegrees.get(v) == 0)
q.offer(v);
}
}

return ans;
}

}
