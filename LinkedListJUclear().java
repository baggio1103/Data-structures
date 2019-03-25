import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(4));
        list.addInTail(new Node(5));
        list.addInTail(new Node(6));
        list.addInTail(new Node(7));
        list.addInTail(new Node(8));
        list.clear();
        assertEquals(0, list.count());
        assertEquals(null, list.head);
        assertEquals(null, list.tail);
    }


}
