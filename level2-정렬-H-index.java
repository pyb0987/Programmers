import java.util.Arrays;


class Solution {
    
    public int solution(int[] citations) {
        
        int n = citations.length;
        Arrays.sort(citations);
        if(citations[0]>=n){
            return n;
        }
        int i = 1;
        while(true){
            if(citations[n-i]>i){
                i += 1;
            }else if(citations[n-i]==i){
                return i;
            }else if (citations[n-i]<i){
                return i-1;
            }
        }
    }
}