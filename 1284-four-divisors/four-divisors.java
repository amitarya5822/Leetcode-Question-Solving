class Solution {
    public int sumFourDivisors(int[] nums) {
        int result = 0;
        for(int num : nums){
            result += findSumFourDivisors(num);
        }
        return result;
    }
    public int findSumFourDivisors(int num){
        int cnt = 0;
        int sum = 0;
        for(int i =1;i*i <= num;i++){
            if(num % i == 0){
                int otherFact = num/i;
                if(otherFact == i){  //eg. square number
                    cnt += 1;
                    sum += i;
                }
                else{
                    cnt += 2;
                    sum += (i+otherFact);
                }
            }
            if(cnt > 4) break;
        }
        return cnt == 4 ? sum:0;

    }
}