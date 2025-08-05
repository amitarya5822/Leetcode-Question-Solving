class Solution {
    public String toLowerCase(String s) {
        char[] ch = s.toCharArray(); // convert String into char Array b/c array is mutable but String not
        for(int i = 0;i<ch.length;i++){
            if(ch[i] >= 'A' && ch[i] <= 'Z'){ //ASCII ranges from 65 to 90
                ch[i] = (char) (ch[i]+32); // b/c ASCII of a is 97,diff.is 32

            }
        }
        return new String(ch);
    }
}

