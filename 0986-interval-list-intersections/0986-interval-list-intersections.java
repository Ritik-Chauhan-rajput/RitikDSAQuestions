class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> result = new ArrayList<>();
        for(int i=0;i<firstList.length;i++){
            for(int j=0;j<secondList.length;j++){
                int start=Math.max(firstList[i][0],secondList[j][0]);
                int end=Math.min(firstList[i][1],secondList[j][1]);
                if(start<=end){
                   result.add(new int[]{start, end});
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}