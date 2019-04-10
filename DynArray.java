import java.lang.reflect.Array;
import java.util.ArrayList;

public class DynArray<T> {
    public T[] array;
    public int count;
    public int capacity;
    public Class clazz;

    public DynArray(Class clazz) {
        this.clazz = clazz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity) {
        // array = (T[]) Array.newInstance(this.clazz, new_capacity);
        // ваш код
        if (count == 0) {
            capacity = new_capacity;
            array = (T[]) Array.newInstance(this.clazz, capacity);
        }
        T[] temp = (T[]) Array.newInstance(this.clazz, capacity);
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }

        if (count > capacity) {
            capacity = capacity * 2;
            array = (T[]) Array.newInstance(this.clazz, capacity);
            for (int i = 0; i < temp.length; i++) {
                array[i] = temp[i];
            }
        } else if (count <= 16) {
            capacity = 16;
            array = (T[]) Array.newInstance(this.clazz, capacity);
            for (int i = 0; i < count; i++) {
                array[i] = temp[i];
            }
        } else if (count < capacity / 2) {
            capacity = (int) (capacity / 1.5);
            array = (T[]) Array.newInstance(this.clazz, capacity);
            for (int i = 0; i < count; i++) {
                array[i] = temp[i];
            }
        }
    }

    public void append(T item) {
        // ваш код
        count++;
        if (count >= capacity) {
            makeArray(array.length);
            array[count - 1] = item;
        } else if (count + 1 <= capacity) {
            array[count - 1] = item;
        }
    }

    public T getItem(int index) {
        // ваш код
        if (index < count && index >= 0) {
            return array[index];
        } else
            throw new IndexOutOfBoundsException();
    }

    public void insert(T item, int index) {
        // ваш код
        if (index <= count && index >= 0) {
            count++;
            if (count >= capacity) {
                makeArray(array.length);
                if (index == 0) {
                    for (int i = count - 2; i >= 0; i--) {
                        array[i + 1] = array[i];
                    }
                    array[index] = item;
                } else if (index == count - 2) {
                    T type = array[index];
                    array[index + 1] = type;
                    array[index] = item;
                } else if (index == capacity - 1) {
                    array[index] = item;
                } else {
                    for (int i = count - 2; i >= index; i--) {
                        array[i + 1] = array[i];
                    }
                    array[index] = item;
                }
            } else if (count + 1 <= capacity) {
                if (index == 0) {
                    for (int i = count - 1; i >= 0; i--) {
                        array[i + 1] = array[i];
                    }
                    array[index] = item;
                } else if (index == count - 2) {

                    T type = array[index];
                    array[index + 1] = type;
                    array[index] = item;

                } else if (index == capacity - 1) {
                    array[index] = item;
                } else {
                    for (int i = count - 1; i >= index; i--) {
                        array[i + 1] = array[i];
                    }
                    array[index] = item;
                }
            }
        } else
            throw new IndexOutOfBoundsException();
    }

    public void remove(int index) {
        // ваш код
        if (index < count && index >= 0) {

            if (index == 0) {
                for (int i = 0; i < count - 1; i++) {
                    array[i] = array[i + 1];
                }
                array[count - 1] = null;
                count--;
            } else if (index == count - 1) {
                array[index] = null;
                count--;
            } else {
                for (int i = index; i < count - 1; i++) {
                    array[i] = array[i + 1];
                }
                array[count - 1] = null;
                count--;
            }
        } else
            throw new IndexOutOfBoundsException();

        if (count <= 16){
            makeArray(16);
        }
        else if (count < capacity/2){
            makeArray(array.length);
        }
    }
}
