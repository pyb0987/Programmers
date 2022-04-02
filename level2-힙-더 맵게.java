import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;

class Heap<T> {
    private int size = 0;
    private List<T extends Comparable<? super T>> array = new ArrayList<>();

    Heap(){
        this.size=0;
        this.array.add(null);
    }

    private int getParent(int idx){
        return idx/2;
    }

    private int getLchild(int idx){
        return idx*2;
    }

    private int getRchild(int idx){
        return idx*2+1;
    }
    public int getSize(){
        return this.size;
    }

    public void add(Comparable<? super T> value){
        this.size += 1;
        this.array.add(value);
        int coord = this.size;
        


    }

}


class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        return answer;
    }

}

class Test{
    public static void main(String[] args){
        
        Heap<Integer> a = new Heap<Integer>();
        a.add(1);
  

        System.out.println(a.getSize());



    }



}