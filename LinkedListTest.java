import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void removeAll() {
     LinkedList list = new LinkedList();
     list.addInTail(new Node(1));
     list.removeAll(1);
     Node actualHead = null;
     Node actualTail = null;
     int numberOfElements = 0;
     assertEquals(actualHead, list.head);
     assertEquals(actualTail, list.tail);
     assertEquals(numberOfElements, list.count());

    }
}
