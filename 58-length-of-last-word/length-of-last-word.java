class Solution {
    public int lengthOfLastWord(String s) {
        return s.trim().substring(s.trim().lastIndexOf(" ") + 1).length();
        /* trim remove leading and ending whitespace s.trim().lastIndexOf(" ")
           Finds the last space in the trimmed string.
           substring(lastIndex + 1) starts from the character after the last space.*/
    }
}