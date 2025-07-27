class Solution {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> prime = new HashSet<>();
        for(int num : nums){
            for(int i = 2;i<=Math.sqrt(num);i++){
                while(num % i == 0){
                    prime.add(i);
                    num = num/i;
                }
            }
            if (num > 1) {
                prime.add(num); 
            }
        }
        return prime.size();
    }
     public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}