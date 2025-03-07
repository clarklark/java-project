package d2_datastructures.linearList;

import java.util.Iterator;

public class Array_Main {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(5);
        dynamicArray.add(7);
        dynamicArray.add(1, 0);
        System.out.println(dynamicArray.remove(1));
        for (Integer ele : dynamicArray) {
            System.out.println(ele);
        }
    }
}

class DynamicArray implements Iterable<Integer> {
    private int size = 0;
    private int capacity = 8;
    private int[] array = {};//节约空间

    public void add(int element) {
        checkAndGrow();
        array[size] = element;
        size++;
    }

    public void add(int element, int index) {
        checkAndGrow();
        if (index < size && index >= 0) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    public int get(int index) {
        return array[index];
    }

    public int remove(int index) {
        int remove = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return remove;
    }
    public void checkAndGrow(){
        if(size==0){
            array=new int[capacity];
        }
        if(size==capacity){
            capacity+=capacity>>1;
            int []newArray=new int[capacity];
            System.arraycopy(array,0,newArray,0,size);
            array=newArray;
        }
    }



    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };

    }
}
