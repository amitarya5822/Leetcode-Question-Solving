class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        int[] prevCount = null; // store char count of previous word

        for (String word : words) {
            int[] count = new int[26]; // count chars 'a' to 'z' for current word
            for (char c : word.toCharArray()) count[c - 'a']++;

            // compare with previous word's count
            if (!Arrays.equals(count, prevCount)) {
                res.add(word);     // keep word if not an anagram of previous
                prevCount = count; // update previous count
            }
        }

        return res;
    }
}
