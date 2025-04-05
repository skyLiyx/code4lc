package lyx.lc.c23;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 2353.设计食物评分系统
 *
 * @date 2025/02/28
 */
public class Lc2353 {

    public static class FoodRatings {

        private final Map<String, Food> foodMap = new HashMap<>();

        private final Map<String, PriorityQueue<Food>> cuisineFoodsMap = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                Food food = new Food(foods[i], cuisines[i], ratings[i]);
                foodMap.put(foods[i], food);
                if (!cuisineFoodsMap.containsKey(cuisines[i])) {
                    PriorityQueue<Food> pq = new PriorityQueue<>();
                    pq.offer(food);
                    cuisineFoodsMap.put(cuisines[i], pq);
                } else {
                    cuisineFoodsMap.get(cuisines[i]).offer(food);
                }
            }
        }

        public void changeRating(String food, int newRating) {
            Food f = foodMap.get(food);
            Food nf = new Food(f.name, f.cuisine, newRating);
            foodMap.put(food, nf);
            cuisineFoodsMap.get(f.cuisine).offer(nf);
        }

        public String highestRated(String cuisine) {
            PriorityQueue<Food> pq = cuisineFoodsMap.get(cuisine);
            Food f = pq.peek();
            while (foodMap.get(f.name).rating != f.rating) {
                pq.poll();
                f = pq.peek();
            }
            return f.name;
        }

        static class Food implements Comparable<Food>{
            String name;
            String cuisine;
            int rating;

            public Food(String name, String cuisine, int rating) {
                this.name = name;
                this.cuisine = cuisine;
                this.rating = rating;
            }

            @Override
            public int compareTo(Food food) {
                if (rating == food.rating) {
                    return name.compareTo(food.name);
                }
                return food.rating - rating;
            }
        }
    }

}
