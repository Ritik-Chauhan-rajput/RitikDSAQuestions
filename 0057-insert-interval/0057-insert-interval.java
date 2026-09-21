class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // insert position.... keep inserting intervals in the res
        // while overlaping.... update interval
        // no overlapping.... insert newinterval into res
        // insert remaining intervals in the res
        int i=0;
        List<int[]> res=new ArrayList<>();
        while(i<intervals.length &&newInterval[0]>intervals[i][1]){
            res.add(intervals[i]);
            i=i+1;
        }
        // correct position
        // intervals[i][0]-s1
        // intervals[i][1]-e1
        // newinterval[0]-s2
        // newinterval[1]-e2
        // intervals[i][1]>=newinterval[0] && newinterval[1]>=intervals[i][0]
        // 
        while(i<intervals.length && intervals[i][1]>=newInterval[0] && newInterval[1]>=intervals[i][0]){
            // update new interval
            newInterval[0]=Math.min( newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max( newInterval[1],intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while(i<intervals.length){
            res.add(intervals[i]);
            i++;
        }
        // res->output
        int[][] ans=new int[res.size()][2];

        for(int j=0;j<res.size();j++){
            ans[j]=res.get(j);
        }
        return ans;
    }
}