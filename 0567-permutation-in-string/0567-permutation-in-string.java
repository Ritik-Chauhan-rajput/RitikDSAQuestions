import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq[] = new int[26];
        for(int i = 0; i < s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;
        }
        int windowSize = s1.length();
        for(int j = 0; j <= s2.length() - windowSize; j++){
            int windowIdx = 0;
            int idx = j;
            int windFreq[] = new int[26];
            while(windowSize > windowIdx){
                windFreq[s2.charAt(idx) - 'a']++;
                windowIdx++;
                idx++;
            }
            if(Arrays.equals(freq, windFreq)){
                return true;
            }
        }
        return false;
    }
}