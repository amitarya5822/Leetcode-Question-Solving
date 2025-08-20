class Solution {
    public int maximum69Number (int num) {
      char[] arr = String.valueOf(num).toCharArray();    // change number into array
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '6') {   
                arr[i] = '9';     
                break;            // only change one digit
            }
        }
        return Integer.parseInt(new String(arr));  //convert back into num
    }
}