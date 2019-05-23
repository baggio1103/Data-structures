import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        // всегда возвращает корректный индекс слота
        int result = 0;
        for (int i = 0; i < key.length(); i++) {
            result += (int) key.charAt(i);
        }
        result %= size;
        return result;
    }

    public boolean isKey(String key) {
        // возвращает true если ключ имеется,
        // иначе false
        int times = 0;
        int counter = hashFun(key);
        while (slots[counter] != null) {
            if (slots[counter].equals(key)) {
                return true;
            }
            counter += 3;
            counter %= size;
            times++;
            if (times == size) {
                return false;
            }
        }
        return false;
    }

    public void put(String key, T value) {
        // гарантированно записываем
        // значение value по ключу key
        int counter = hashFun(key);
        int isEmpty = isEmpty(slots);
        if (isEmpty != 0) {
            while (slots[counter] != null && !values[counter].equals(value)) {
                counter += 3;
                counter %= size;
            }
            slots[counter] = key;
            values[counter] = value;
        }
    }

    public int isEmpty(String[] array) {
        int amount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                amount++;
            }
        }
        return amount;
    }

    public T get(String key) {
        // возвращает value для key,
        // или null если ключ не найден
        int counter = hashFun(key);
        int times = 0;
        while (slots[counter] != null) {
            if (slots[counter].equals(key)) {
                return values[counter];
            }
            counter += 3;
            counter %= size;
            times++;
            if (times == size) {
                return null;
            }
        }
        return null;
    }

    public void display() {
        System.out.println("Slots:");
        for (int i = 0; i < size; i++) {
            System.out.print("| " + slots[i] + " ");
        }
        System.out.println("|");
        System.out.println("Values");
        for (int i = 0; i < size; i++) {
            System.out.print("| " + values[i] + " ");
        }
        System.out.println("|");
    }
}
