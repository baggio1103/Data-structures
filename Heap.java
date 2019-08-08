import java.util.*;

class Heap
{
    public int [] HeapArray; // хранит неотрицательные числа-ключи

    public Heap()
    {
        HeapArray = null;
    }


    public void MakeHeap(int[] a, int depth)
    {
        // создаём массив кучи HeapArray из заданного
        // размер массива выбираем на основе глубины depth
        HeapArray = new int[(int) Math.pow(2, depth+1)-1];
        for (int i = 0; i < HeapArray.length; i++) HeapArray[i] = -1;

        for (int i = 0; i < a.length; i++){
            Add(a[i]);
        }
    }

    public int GetMax()
    {
        // вернуть значение корня и перестроить кучу
        int max;
        if (HeapArray[0] == -1){
            return -1;
        }else {
            max = HeapArray[0];
            HeapArray[0] = -1;
            int index = getMaxIndex(HeapArray);
            HeapArray[0] = HeapArray[index];
            for (; index < HeapArray.length;) {
                if (2 * index + 1 < HeapArray.length) {
                    int temp = Math.max(HeapArray[2 * index + 1], HeapArray[2 * index + 2]);
                    int i = 0;
                    if (temp == HeapArray[2*index+1]){
                        i = index*2+1;
                    }else if (temp == HeapArray[2*index+2]){
                        i = index*2+2;
                    }
                    HeapArray[index] = temp;
                    HeapArray[i] = -1;
                }
                index = 2*index+1;
            }
            return max;
        }
    }

    public boolean Add(int key)
    {
        // добавляем новый элемент key в кучу и перестраиваем её
        if(HeapArray[0] == -1){
            HeapArray[0] = key;
            return true;
        }else {
            for (int i = 1; i < HeapArray.length; i++) {
                if (HeapArray[i] == -1) {
                    HeapArray[i] = key;
                    for (; i >= 0; ) {
                        if (HeapArray[i] > HeapArray[(i - 1) / 2]) {
                            int temp = HeapArray[(i-1)/2];
                            HeapArray[(i - 1) / 2] = HeapArray[i];
                            HeapArray[i] = temp;
                        }
                        if (i == 0){
                            return true;
                        }
                        i = (i - 1) / 2;
                    }
                }
             }
        }
        return false; // если куча вся заполнена
    }

    public void print(int[] array){
        for (int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public int getMaxIndex(int[] array){
        int index = 0;
        int max = array[0];
        for (int i = 1; i < array.length-1; i++){
            if (array[i] > max){
                max = array[i];
                index = i;
            }
        }
        return index;
    }

}
