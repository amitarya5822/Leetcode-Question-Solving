class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] times = new long[n];

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                long t = (long) mana[i] * skill[j];  // time taken by wizard j on potion i
                if(j == 0){
                    times[0] = times[0]+ t;   // First wizard starts immediately after finishing previous potion
                }
                else{
                    // Other wizards can start only after:
                    // 1. They finish previous potion (times[j])
                    // 2. Previous wizard finishes this potion (times[j - 1])
                    times[j] = Math.max(times[j],times[j-1]) + t;
                }
            }
            // Adjust overlapping times so next potion can start properly
            // This "backward correction" ensures timing is synced between wizards
            for(int j = n-2;j>=0;j--){
                times[j] = times[j+1] - (long) mana[i] * skill[j+1];
            }
        }
        return times[n-1];
    }
}