import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void remove() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(3));
//        System.out.println(list.count());
        int count = 0;
        list.remove(3);
        Node actualHead = null;
        Node actualTail = null;
        int expectedCount = list.count();
        Node head = list.head;
        Node tail = list.tail;
//        System.out.println(list.count());
        assertEquals(count,expectedCount);
        assertEquals(actualHead,head);
        assertEquals(actualTail,tail);
    }
}
