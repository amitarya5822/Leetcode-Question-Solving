class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> first = new HashSet<>();
        first.add(s.charAt(0));
        for(int i = 1;i<s.length();i++){
            if(first.contains(s.charAt(i))){
                return s.charAt(i);
            }
            else{
                first.add(s.charAt(i));
            }
        }
        return 'a';
    }
}