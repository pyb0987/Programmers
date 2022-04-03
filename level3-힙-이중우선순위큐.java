import java.util.ArrayList;
import java.util.List;

class minHeap<T extends Comparable<? super T>> {
    protected int size = 0;
    protected List<T> array = new ArrayList<>();

    minHeap(){
        this.size=0;
        this.array.add(null);
    }

    protected int getParent(int idx){
        return idx/2;
    }

    protected int getLchild(int idx){
        return idx*2;
    }

    protected int getRchild(int idx){
        return idx*2+1;
    }

    protected void compareWithParent(int coord){
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
    protected void compareTwoChildren(T root){
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

    public T getT(){
        T returnVal = this.array.get(1);
        T root = array.get(this.size);
        this.array.set(1, root);
        compareTwoChildren(this.array.get(1)); 
        this.array.remove(this.size);
        this.size -= 1;   
        return returnVal;
    }
    public T seeT(){
        T returnVal = this.array.get(1);
        return returnVal;
    }

    public void printHeap(){
        for(T i : this.array){
		System.out.print(i+" ");
    }
    System.out.println();
    }

    public void terminate(T target){
        List<T> tmpList = new ArrayList<>();
        for(int i=this.size; i>0; i--){
            T tmp = this.array.get(i);
            this.array.remove(i);
            this.size-=1;
            if (tmp==target){
                add(tmpList);
                break;
            }
            else{
                tmpList.add(tmp);
            }
        }
    }
    

}



class maxHeap<T extends Comparable<? super T>> extends minHeap<T>{


    protected void compareWithParent(int coord){
        T child = this.array.get(coord);
        while(coord>1){
            T parent = this.array.get(getParent(coord));
            int childIsBig = child.compareTo(parent);
            if (childIsBig>0){
                T temp = parent;
                this.array.set(getParent(coord),child);
                this.array.set(coord,temp);
                coord = getParent(coord);
            }else{
                break;
            }            
        }
    }

    protected void compareTwoChildren(T root){
        if(root == null){
            return;
        }
        int coord = 1;
        while(getLchild(coord)<=this.size){
        T Lchild = this.array.get(getLchild(coord));
        int LchildIsBig;
        T Rchild = null;
        if (getLchild(coord)==this.size){
            LchildIsBig = +1;
        }
        else{
        Rchild = this.array.get(getRchild(coord));
        LchildIsBig = Lchild.compareTo(Rchild);
        }      
        if (LchildIsBig<0){
            int parentIsBig = root.compareTo(Rchild);
            if (parentIsBig<0){
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
            if (parentIsBig<0){
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
    
}

class DoubleQueueControl<T extends Comparable<? super T>> {
    maxHeap<T> maxh = new maxHeap<T>();
    minHeap<T> minh = new minHeap<T>();
    DoubleQueueControl(){};

    public void Iinsert(T target){
        maxh.add(target);
        minh.add(target);
    }

    public void Dmax(){
        if(minh.size ==0){
            return;
        }
        minh.terminate(maxh.getT());
    }
    public void Dmin(){
        if(maxh.size ==0){
            return;
        }
        maxh.terminate(minh.getT());
    }
    public T RtnMax(){
        T a = maxh.seeT();
        return a;
    }
    public T RtnMin(){
        T a = minh.seeT();
        return a;
    }
    public void printHeap(){
        maxh.printHeap();
        minh.printHeap();
    }
    public int size(){
        return maxh.size;
    }

}

class Solution {
    public int[] solution(String[] operations) {
        DoubleQueueControl<Integer> a = new DoubleQueueControl<>();
        for (String query : operations){
            String[] splited = query.split(" ");
            if (splited[0].equals("I")){
                a.Iinsert(Integer.parseInt(splited[1]));
            }
            if (splited[0].equals("D")){
                if(splited[1].equals("1")){
                    a.Dmax();
                }
                else{
                    a.Dmin();
                }
            }
        }
        int[] answer = new int[2];
        if (a.size()==0){
            answer[0]=0;
            answer[1]=0;
        }
        else{
            answer[0]=a.RtnMax();
            answer[1]=a.RtnMin();
        }
        return answer;
    }
}


class Test{
    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1","D -1","I 333"};



        DoubleQueueControl<Integer> a = new DoubleQueueControl<>();
        for (String query : operations){
            String[] splited = query.split(" ");
            if (splited[0].equals("I")){
                a.Iinsert(Integer.parseInt(splited[1]));
            }
            if (splited[0].equals("D")){
                if(splited[1].equals("1")){
                    a.Dmax();
                }
                else{
                    a.Dmin();
                }
            }
        }
        if (a.size()==0){
            System.out.println(0);
            System.out.println(0);
        }
        else{
            System.out.println(a.RtnMax());
            System.out.println(a.RtnMin());
        }





    }
}