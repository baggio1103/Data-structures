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
        for (int i =0; i < 1125; i++){
            list.append(i);
        }
        assertEquals(1126,list.count);
        assertEquals(2048,list.capacity);
        for (int i = list.count-1; i > 100; i--){
            list.remove(i);
        }
    }

    @Test
    public void remove() {
     DynArray<Integer> list = new DynArray<>(Integer.class);
     for (int i = 0; i <1048; i++){
         list.append(i);
     }
     list.remove(999);
     assertEquals(2048,list.capacity);
     for (int i = list.count-1; i >47; i--){
         list.remove(i);
     }
     assertEquals(79,list.capacity);
    for (int i =list.count-1; i > 8; i--){
        list.remove(i);
    }
        assertEquals(16,list.capacity);
     }
}
