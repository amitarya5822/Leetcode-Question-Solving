class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0; // total gas earn
        int sum1 = 0; // total cost

        // if total gas earn is less thentotal cost then it impossible to  circulate around ,return -1
        for(int i = 0;i<gas.length;i++){
            sum += gas[i];
            sum1 += cost[i];
        }
            if(sum < sum1) return -1;
        

        int total = 0;
        int result = 0;
        for(int i = 0;i<n;i++){
            total  += gas[i]-cost[i];
            if(total < 0) {
                total = 0;
            result = i+1;
            }
        }
        return result;

            
    }
}
