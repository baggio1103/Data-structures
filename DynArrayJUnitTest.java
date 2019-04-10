import org.junit.Test;

import static org.junit.Assert.*;

public class DynArrayTest {

    @Test
    public void insert() {

    DynArray<Integer> list = new DynArray<>(Integer.class);
     assertEquals(0,list.count);
     list.insert(77,0);
     assertEquals(1,list.count);
     assertEquals(16,list.capacity);
    }

    @Test
    public void remove() {
        DynArray<Integer> list = new DynArray<>(Integer.class);
        for (int i = 0; i <1248;i++){
            list.append(i);
        }
//        System.out.println(list.count);
//        System.out.println(list.capacity);
        list.remove(99);
        assertEquals(2048,list.capacity);
        assertEquals(1247,list.count);
    }
}
