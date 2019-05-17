public class HashTable
{
    public int size;
    public int step;
    public String [] slots;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
        // всегда возвращает корректный индекс слота
        int index = 0;
        for (int i = 0; i < value.length();i++){
            index +=(int)value.charAt(i);
        }
        if (index >= size){
            return index % size;
        }
        else
            return index;
    }

    public int seekSlot(String value) {
        int counter = hashFun(value);
        // находит индекс пустого слота для значения, или -1
        if (isEmpty(slots) == 0) {
            return -1;
        }
        while (slots[counter] != null) {
                counter += step;
                counter %= size;
        }
        return counter;

    }

    public int put(String value) {
        // записываем значение по хэш-функции
        // возвращается индекс слота или -1
        // если из-за коллизий элемент не удаётся разместить
        int counter = hashFun(value);
        int isEmpty = isEmpty(slots);
        while (slots[counter] != null) {
            counter += step;
            counter %= size;
            if (isEmpty == 0) {
                return -1;
            }
        }
            slots[counter] = value;
            return counter;

    }
    public int isEmpty(String [] array){
    int amount = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == null){
                amount++;
            }
        }
        return amount;
    }

    public int find(String value) {
        // находит индекс слота со значением, или -1
        int counter = hashFun(value);
        int times = 0;
        while (slots[counter] != null) {
            if (slots[counter].equals(value)) {
                System.out.println(value + " was found in index " + counter);
                return counter;
            }
            counter += step;
            counter %= size;
            times++;
            if (times == size){
                return -1;
            }
        }
        return -1;
    }

    public void display() {
        for (int i = 0; i < size; i++){
            System.out.print("| " + slots[i] + " ");
        }
        System.out.println("|");
    }
}
