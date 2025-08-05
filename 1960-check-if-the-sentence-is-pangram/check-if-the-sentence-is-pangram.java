class Solution {
//     public boolean checkIfPangram(String sentence) {
//         for(char ch = 'a';ch<='z';ch++){
//             if(sentence.indexOf(ch) == -1) return false;  //this method returns the starting index of the first occurrence
//         }
//         return true;

//     }
// }
    public boolean checkIfPangram(String sentence) {
        Set<Character> s = new HashSet<>();
        for (int i = 0; i < sentence.length(); ++i)
            s.add(sentence.charAt(i));
        return s.size() == 26;
    }
}