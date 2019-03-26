import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void insertAfter() {
    LinkedList list = new LinkedList();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(5));
        //list.printList();
        list.insertAfter(new Node(3),new Node(4));
        assertEquals(5,list.count());
        //list.printList();

  }
}
