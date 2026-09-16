class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a->a[0]));
    //    res..
    //    res.add(meeting[0])
    //    meeting... start> merged_intervals(res last)
    //    maxEnd=meetings[0][1]
    //    from next mering onward....
    //    current meeting... start
        int maxEnd=meetings[0][1];
        int gap=0;
        for(int i=1;i<meetings.length;i++){
            if(meetings[i][0]>maxEnd){
                gap=gap+meetings[i][0]-maxEnd-1;

            }
            maxEnd=Math.max(maxEnd, meetings[i][1]);
        }
        gap=gap+meetings[0][0]-1;
        gap=gap+days-maxEnd;
        return gap;
    }
}