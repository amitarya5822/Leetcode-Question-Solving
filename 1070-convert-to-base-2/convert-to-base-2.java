class Solution {
    public String baseNeg2(int n) {
        if(n == 0) return "0";
        StringBuilder binaryNeg2 = new StringBuilder();
        while(n != 0){
            int rem = n%-2;
            n /= -2;
            if(rem < 0){     // if remainder is in negative then add 2 in rem & add 1 in n
                rem += 2;
                n += 1;
            }
                binaryNeg2.append(rem);
            
        }
        return binaryNeg2.reverse().toString();
    }
}