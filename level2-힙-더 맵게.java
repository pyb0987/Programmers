import java.util.ArrayList;
import java.util.List;

class Heap<T extends Comparable<? super T>> {
    private int size = 0;
    private List<T> array = new ArrayList<>();

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

    private void compareWithParent(int coord){
        T child = this.array.get(coord);
        while(coord>1){
            T parent = this.array.get(getParent(coord));
            int childIsBig = child.compareTo(parent);
            if (childIsBig<0){
                T temp = parent;
                this.array.set(getParent(coord),child);
                this.array.set(coord,temp);
                coord = getParent(coord);
            }else{
                break;
            }            
        }
    }
    private void compareTwoChildren(T root){
        if(root == null){
            return;
        }
        int coord = 1;
        while(getLchild(coord)<=this.size){
        T Lchild = this.array.get(getLchild(coord));
        int LchildIsBig;
        T Rchild = null;
        if (getLchild(coord)==this.size){
            LchildIsBig = -1;
        }
        else{
        Rchild = this.array.get(getRchild(coord));
        LchildIsBig = Lchild.compareTo(Rchild);
        }      
        if (LchildIsBig>0){
            int parentIsBig = root.compareTo(Rchild);
            if (parentIsBig>0){
                T temp = root;
                this.array.set(coord,Rchild);
                this.array.set(getRchild(coord),temp);
                coord = getRchild(coord);
            }
            else{
                return;
            }
        }else{
            int parentIsBig = root.compareTo(Lchild);
            if (parentIsBig>0){
                T temp = root;
                this.array.set(coord,Lchild);
                this.array.set(getLchild(coord),temp);
                coord = getLchild(coord);
            }
            else{
                return;
            }
        }
        }
    }


    public int getSize(){
        return this.size;
    }

    public void add(T value){
        this.size += 1;
        this.array.add(value);
        int coord = this.size;
        compareWithParent(coord);        
    }
    
    public void add(List<T> values){
        for (T value : values){
            this.add(value);
        }      
    }

    public T getMinimumT(){
        T returnVal = this.array.get(1);
        T root = array.get(this.size);
        this.array.set(1, root);
        compareTwoChildren(this.array.get(1)); 
        this.array.remove(this.size);
        this.size -= 1;   
        return returnVal;
    }
    public T seeMinimumT(){
        T returnVal = this.array.get(1);
        return returnVal;
    }

    public void printHeap(){
        for(T i : this.array){
		System.out.print(i+" ");
    }
    System.out.println();
    }
}


class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        Heap<Integer> scov = new Heap<>();
        for(int i : scoville){
            scov.add(i);
        }
        while (scov.getSize() >=2 && scov.seeMinimumT()<K){
            int m1 = scov.getMinimumT();
            int m2 = scov.getMinimumT();
            scov.add(m1+m2*2);
            count +=1;
        }
        if (scov.seeMinimumT()>=K){
            return count;
        } else{
            return -1;
        }
    }

}
