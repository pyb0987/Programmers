class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {-1, -1};
        int searchnum = (brown-2)/4;
        int searchnum2 = (brown-4)/4;
        for(int i = 0; i<searchnum2; i++){
            if((searchnum2-i)*(searchnum+i)==yellow){
                answer[0] = (searchnum+i)+2;
                answer[1] = (searchnum2-i)+2;
                break;
            }
        }
        return answer;
    }

}
class test{
    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println(a.solution(24, 24)[0]);
        System.out.println(a.solution(24, 24)[1]);
    }
}