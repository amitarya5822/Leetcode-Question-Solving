class Solution {
    public String greatestLetter(String s) {
        HashSet<Character> hs = new HashSet<>();
        for( char ch : s.toCharArray()){
            hs.add(ch);
        }
        for(char ch = 'Z';ch >= 'A';ch--){
            if(hs.contains(ch) && hs.contains(Character.toLowerCase(ch))){
                return String.valueOf(ch);
            }
        }
        return "";
    }
}