class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> hs = new HashSet<>();
        int cnt = 0;
        for( char ch : word.toCharArray()){
            hs.add(ch);
        }
        for(char ch = 'Z';ch >= 'A';ch--){
            if(hs.contains(ch) && hs.contains(Character.toLowerCase(ch))){
                cnt++;
            }
        }
        return cnt;
    }
}