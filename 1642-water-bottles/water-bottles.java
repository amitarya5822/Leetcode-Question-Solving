class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles; // drink all  bottles
        
        int empty = numBottles; //  empty bottles
        
        while (empty >= numExchange) {
            int newBottles = empty / numExchange; // exchange empty for new
            count += newBottles; // drink them
            empty = newBottles + (empty % numExchange); // leftover + new empty
        }
        
        return count;
    }
}

// using formula
// return numBottles + (numBottles - 1) / (numExchange - 1);
