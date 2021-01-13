import java.util.*;

public class aBST
{
    public Integer Tree []; // массив ключей
    public aBST(int depth)
    {
        // правильно рассчитайте размер массива для дерева глубины depth:
        int tree_size = (int) (Math.pow(2, depth+1)-1);
        Tree = new Integer[ tree_size ];
        for(int i=0; i<tree_size; i++) Tree[i] = null;
    }


    public Integer FindKeyIndex(int key)
    {
        // ищем в массиве индекс ключа
        for (int i = 0; i < Tree.length;){
            if (Tree[i] == null){
                return -i;
            }
            else if (Tree[i] == key){
                return i;
            }
            else if (Tree[i] < key){
                i = 2*i+2;
            }
            else if (Tree[i] > key){
                i = 2*i+1;
            }
        }
        return null; // не найден
    }

    public int AddKey(int key)
    {
        // добавляем ключ в массив
        for (int i = 0; i < Tree.length;){

            if (Tree[i] == null){
                Tree[i] = key;
                return i;
            }
            else if (Tree[i] == key){
                return i;
            }
            else if (Tree[i] > key){
                 i = 2*i+1;
            }
            else if (Tree[i] < key){
                i = 2*i+2;
            }
        }
        // индекс добавленного/существующего ключа или -1 если не удалось
        return -1;
    }

    public void printArray(){
        for (Integer i : Tree){
            System.out.print(i + " ");
        }
        System.out.println();
    }

}

