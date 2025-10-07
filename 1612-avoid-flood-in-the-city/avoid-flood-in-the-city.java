import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];          
        Arrays.fill(ans, 1);             

        Map<Integer, Integer> filledLake = new HashMap<>(); // Tracks last day each lake was filled
        TreeSet<Integer> sunnyDays = new TreeSet<>();      // Available sunny days indices

        for (int i = 0; i < n; i++) {
            int lake = rains[i];

            if (lake > 0) {
                // It's raining on lake
                ans[i] = -1; // Must mark as -1

                   // if Lake was already full, must find a sunny day to dry it before today
                if (filledLake.containsKey(lake)) {
                    
                    // Find the earliest sunny day after the last time this lake was filled
                    // This sunny day will be used to dry the lake to prevent flooding
                    Integer sunny = sunnyDays.higher(filledLake.get(lake));

                    
                    if (sunny == null) {
                        // No available sunny day → flood occurs
                        return new int[0];
                    }
                    // Use this sunny day to dry the lake
                    ans[sunny] = lake;
                    sunnyDays.remove(sunny);
                }

                // Update last filled day for this lake
                filledLake.put(lake, i);
            } else {
                // It's a sunny day, we can dry a lake later
                sunnyDays.add(i);
            }
        }

        return ans;
    }
}
