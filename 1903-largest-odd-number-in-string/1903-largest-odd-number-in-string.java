class Solution {
    public String largestOddNumber(String num) {
       char[] arr=num.toCharArray();
       for(int i=arr.length-1;i>=0;i--){
        int n=arr[i]-'0';
        if(n%2!=0){
            return num.substring(0,i+1);
        }
       } 
       return "";
    }
}