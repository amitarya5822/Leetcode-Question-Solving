class Solution {
    public int countEven(int num) {
        int sum = 0, n = num;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return (sum % 2 == 0) ? num / 2 : (num - 1) / 2;
    }
}