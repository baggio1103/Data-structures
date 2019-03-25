import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void remove() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(3));
//      System.out.println(list.count());
        list.remove(3);
//      System.out.println(list.count());
        assertEquals(0,list.count());
        assertEquals(null,list.head);
        assertEquals(null,list.tail);  
    }
}
