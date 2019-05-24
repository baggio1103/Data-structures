import java.util.ArrayList;
public class PowerSet {
  
    public PowerSet() {
        // ваша реализация хранилища
      ArrayList list = new ArrayList();
    }

    public int size() {
        // количество элементов в множестве
        return list.size();
    }


    public void put(String value) {
        // всегда срабатывает
        if (!get(value)) {
            list.add(value);
        }
    }

    public boolean get(String value) {
        // возвращает true если value имеется в множестве,
        // иначе false
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(String value) {
        // возвращает true если value удалено
        // иначе false
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public PowerSet intersection(PowerSet set2) {
        // пересечение текущего множества и set2
        PowerSet set = new PowerSet();
        for (int i = 0; i < list.size(); i++) {
            if (set2.get((String) list.get(i))) {
                set.put((String) list.get(i));
            }
        }
        return set;
    }


    public ArrayList convert() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(list.get(i));
        }
        return arrayList;
    }


    public PowerSet union(PowerSet set2) {
        PowerSet unionSet = new PowerSet();
        // объединение текущего множества и set2
        for (int i = 0; i < list.size(); i++) {
            unionSet.put((String) list.get(i));
        }
        for (int i = 0; i < set2.convert().size(); i++) {
            unionSet.put((String) set2.convert().get(i));
        }
        return unionSet;
    }

    public PowerSet difference(PowerSet set2) {
        // разница текущего множества и set2
        PowerSet set = new PowerSet();
        for (int i = 0; i < list.size(); i++) {
            if (!set2.get((String) list.get(i))) {
                set.put((String) list.get(i));
            }
        }
        return set;
    }

    public boolean isSubset(PowerSet set2) {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        int counter = 0;
        if (set2.size() < list.size()) {
            for (int i = 0; i < list.size(); i++) {
                if (set2.get((String) list.get(i))) {
                    counter++;
                }
            }

            return counter == set2.size();
        }
        return false;
    }
}
