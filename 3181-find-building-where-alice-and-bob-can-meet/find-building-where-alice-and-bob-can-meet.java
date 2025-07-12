class Solution {
    int[] segT;
    int[] heights;
    void buildSt(int idx,int low,int high){
        if(low == high){
            segT[idx] = low;
            return;
        }
        int mid = low+(high-low)/2;
        buildSt(2*idx+1,low,mid);
        buildSt(2*idx+2,mid+1,high);

        // store the index of max element
        int leftIdx = segT[2*idx+1];
        int rightIdx = segT[2*idx+2];

        segT[idx] = (heights[leftIdx] >= heights[rightIdx]) ? leftIdx : rightIdx;
    }
   void constructSegTree(int[] h, int n) {
        this.heights = h;
        this.segT = new int[4 * n];
        buildSt(0, 0, n - 1);
    }

    int range_q(int idx,int low,int high,int l,int r){
        if(high < l || low > r) return -1;
        if(l<= low &&  high <= r) return segT[idx];

        int mid = low+(high-low)/2;
        int leftMax = range_q(2*idx+1,low,mid,l,r);
        int rightMax = range_q(2*idx+2,mid+1,high,l,r);

        if(leftMax == -1) return rightMax;
        if(rightMax == -1) return leftMax;

        return heights[leftMax] >= heights[rightMax] ? leftMax : rightMax;
    }

    int RMIQ(int l,int r,int n){
        return range_q(0,0,n-1,l,r);
    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        constructSegTree(heights,n);
        List<Integer> result = new ArrayList<>();
        for(int[] query : queries){
            int min_idx = Math.min(query[0],query[1]);
            int max_idx = Math.max(query[0],query[1]);

            if(min_idx == max_idx){
                result.add(min_idx);
                continue;
            }
            else if(heights[max_idx] > heights[min_idx]){
                result.add(max_idx);
                continue;
            }

            int low = max_idx+1;
            int high = n-1;
            int result_idx = Integer.MAX_VALUE;
            while(low <= high){
                int mid = low+(high-low)/2;
                int index = RMIQ(low,mid,n);

                if(heights[index] > Math.max(heights[min_idx],heights[max_idx])){
                    result_idx = Math.min(result_idx,index);
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            if(result_idx == Integer.MAX_VALUE){
                result.add(-1);
            }
            else{
                result.add(result_idx);
            }
        }
            int[] resArr = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
              resArr[i] = result.get(i);
            }
        return resArr;
    }
}   
        
