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

class Job implements Comparable<Job>{
    int a;
    int b;
    Job(int[] ab){
        a = ab[0];
        b = ab[1];
    }
    @Override
    public int compareTo(Job o) {
        return this.b - o.b;
    }
    
}



class Solution {
    public int solution(int[][] jobs) {
        Heap<Job> jobs_Heap = new Heap<>();
        for (int[] i : jobs){
            Job a = new Job(i);
            jobs_Heap.add(a);
        }
        int jobN = jobs_Heap.getSize();
        Job[] jobList = new Job[jobN];
        int jobindex = -1;
        int time = 0;
        int sumup = 0;
        while(jobs_Heap.getSize()>0){
            int minimumB = 1000;
            while(true){
                Job onjob = jobs_Heap.getMinimumT();
                if (onjob.a <= time){
                    time += onjob.b;
                    sumup += (time-onjob.a);
                    for (;jobindex>-1;jobindex--){
                        jobs_Heap.add(jobList[jobindex]);
                    }
                    break;
                }
                else{
                    jobindex+=1;
                    jobList[jobindex] = onjob;
                    if (onjob.a<minimumB){
                        minimumB = onjob.a;
                    }
                }
                if (jobindex>=0 && jobs_Heap.getSize()==0){
                    time = minimumB;
                    for (;jobindex>-1;jobindex--){
                        jobs_Heap.add(jobList[jobindex]);
                    }
                }
        }

        }
        return sumup/jobN;
    }
}