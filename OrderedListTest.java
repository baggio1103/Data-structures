import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OrderedListTest

{

    @Test
    public void compare() {
        OrderedList list = new OrderedList(true);
        assertEquals(0, list.compare(25,25));
        assertEquals(-1, list.compare(199, 200));
        assertEquals(1, list.compare(99, 78));
    }

    @Test
    public void add() {
        OrderedList list = new OrderedList(true);
        list.add(1);
        list.add(13);
        list.add(-8);
        list.add(21);
        list.add(-555);
        list.add(79);
        list.add(25);
        assertEquals(7, list.count);
        assertEquals(79,list.tail.value);
        assertEquals(-555,list.head.value);
        assertEquals(25,list.tail.prev.value);

    }

    @Test
    public void find() {
        OrderedList list = new OrderedList(true);
        list.add(1);
        list.add(13);
        list.add(-8);
        list.add(21);
        list.add(-555);
        list.add(79);
        list.add(25);
     assertEquals(null, list.find(99));
     assertEquals(-555, list.find(-555).value);
     assertEquals(null,list.find(77));
    }

    @Test
    public void delete() {
        OrderedList list = new OrderedList(true);
        list.add(1);
        list.add(13);
        list.add(-8);
        list.add(21);
        list.add(-555);
        list.add(79);
        list.add(25);
        list.delete(-555);
        assertEquals(-8, list.head.value);
        list.delete(79);
        assertEquals(25,list.tail.value);
    }

    @Test
    public void clear() {
        OrderedList list = new OrderedList(true);
        list.add(1);
        list.add(13);
        list.add(-8);
        list.add(21);
        list.add(-555);
        list.add(79);
        list.add(25);
        list.add(121);
        list.clear(true);
       assertEquals(0, list.count);
       assertEquals(null, list.head);
       assertEquals(null, list.tail);

    }

    @Test
    public void getAll() {
        OrderedList list = new OrderedList(true);
        list.add(1);
        list.add(13);
        list.add(-8);
        list.add(21);
        list.add(-555);
        list.add(79);
        list.add(25);
        list.add(121);
        ArrayList<Node> list1 = list.getAll();
        assertEquals(8, list1.size());
        assertEquals(-555, list1.get(0).value);
        assertEquals(121, list1.get(7).value);
    }
}
