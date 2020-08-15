import java.util.*;

class Heap {
    public int[] HeapArray; // contains non-negative numbers - keys

    public Heap() {
        HeapArray = null;
    }


    public void MakeHeap(int[] a, int depth) {
        // create a heap from a given array int[] a
        // the size of an array is chosen basing on the depth "argument depth"
        HeapArray = new int[(int) Math.pow(2, depth + 1) - 1];
        for (int i = 0; i < HeapArray.length; i++) HeapArray[i] = -1;

        for (int i = 0; i < a.length; i++) {
            Add(a[i]);
        }
    }

    public int GetMax() {
        //return the maxElement and rearrange the heap
        int max;
        if (HeapArray[0] == -1) {
            return -1;
        } else {
            max = HeapArray[0];
            HeapArray[0] = HeapArray[HeapArray.length-1];
            HeapArray[HeapArray.length-1] = -1;
            int i = 0;
            boolean greater = false;
            while (i < HeapArray.length && !greater) {
                if (2 * i + 1 < HeapArray.length) {
                    int node = Math.max(HeapArray[2 * i + 1], HeapArray[2 * i + 2]);
                    if (node > HeapArray[i]) {
                        int br = HeapArray[i];
                        if (node == HeapArray[2 * i + 1]) {
                            HeapArray[i] = node;
                            i = 2 * i + 1;
                        } else if (node == HeapArray[2 * i + 2]) {
                            HeapArray[i] = node;
                            i = 2 * i + 2;
                        }
                        HeapArray[i] = br;
                    }else {
                        greater = true;
                    }
                }else {
                    i = HeapArray.length;
                }
            }
        }
        return max;
    }

    public boolean Add(int key) {
        // add a new element to the heap and rearranges it
        if (HeapArray[0] == -1) {
            HeapArray[0] = key;
            return true;
        } else {
            for (int i = 1; i < HeapArray.length; i++) {
                if (HeapArray[i] == -1) {
                    HeapArray[i] = key;
                    for (; i >= 0; ) {
                        if (HeapArray[i] > HeapArray[(i - 1) / 2]) {
                            int temp = HeapArray[(i - 1) / 2];
                            HeapArray[(i - 1) / 2] = HeapArray[i];
                            HeapArray[i] = temp;
                        }
                        if (i == 0) {
                            return true;
                        }
                        i = (i - 1) / 2;
                    }
                }
            }
        }
        return false; // if the heap is full
    }

    public void print(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
