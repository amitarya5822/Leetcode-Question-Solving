class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

       
        for (; i < n && intervals[i][1] < newInterval[0]; i++) {
            result.add(intervals[i]);
        }

       
        for (; i < n && intervals[i][0] <= newInterval[1]; i++) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        }
        result.add(newInterval);

        
        for (; i < n; i++) {
            result.add(intervals[i]);
        }

        return result.toArray(new int[result.size()][]);
    }
}