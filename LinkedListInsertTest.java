import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void insertAfter() {
    LinkedList list = new LinkedList();
    list.insertAfter(null,new Node(5));
    assertEquals(1,list.count());
    assertEquals(5,list.head.value);
    assertEquals(5,list.tail.value);
 }
}
