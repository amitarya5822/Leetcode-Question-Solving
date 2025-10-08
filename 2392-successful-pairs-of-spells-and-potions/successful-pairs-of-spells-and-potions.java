class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
            int n = spells.length;
            int m = potions.length;

            Arrays.sort(potions);
            int[] result = new int[n];

            for(int i = 0;i<n;i++){
                int spell = spells[i];

                int left = 0,right = m-1,index = m;

                while(left <= right){
                    int mid = left+(right-left)/2;
                    long product = (long)spell * potions[mid];

                    if(product >= success){
                        index = mid;
                        right = mid-1;
                    }
                    else{
                        left = mid+1;
                    }
                }
                result[i] = m-index;
            }
         return result;
    }
}