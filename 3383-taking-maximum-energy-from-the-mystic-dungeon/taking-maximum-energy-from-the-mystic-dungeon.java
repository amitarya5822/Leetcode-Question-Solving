class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] ans = new int[n];
        // Traverse from the end because future (i+k) values are needed to compute current
        for(int i = n-1;i>=0;i--){
            int nextIdx = i+k; // next magician index after a teleport jump

            if(nextIdx >= n){  // If next jump goes out of bounds, you can only take current energy
                ans[i] = energy[i];
            }
            else{   //take current energy + energy gained from the next valid position
                ans[i] = energy[i] + ans[nextIdx];
            }
        }
        int maxEnergy = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            maxEnergy = Math.max(maxEnergy,ans[i]);
        }
        return maxEnergy;
    }
}