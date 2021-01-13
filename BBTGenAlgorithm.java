import java.util.*;

class BBTGenAlgorithm {

    public static int[] GenerateBBSTArray(int[] a) {
        int[] tree = new int[a.length];
        arraySort(a);
        int index = 0;
        int start = 0;
        int end = a.length-1;
        func(a,tree,start,end, index);
        return tree;
    }

    public static void arraySort(int[] array){
        for (int i = array.length-1; i >= 0; i--){
            for (int j = 0; j < i; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    
    public static void func(int[] array, int[] finalArray, int start, int end, int index){
       if (start > end){
           return;
       }
       int mid = (start+end)/2;
       finalArray[index] = array[mid];
       func(array, finalArray, start, mid-1, 2*index+1);
       func(array, finalArray,mid+1, end, 2*index+2);

    }

}
