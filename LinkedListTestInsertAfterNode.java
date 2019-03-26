import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void insertAfter() {
  LinkedList list = new LinkedList();
      list.addInTail(new Node(1));
      list.addInTail(new Node(2));
      list.addInTail(new Node(3));
      list.addInTail(new Node(4));
  //    list.printList();
      list.insertAfter(new Node(4),new Node(5));
      assertEquals(5,list.count());
      assertEquals(5,list.tail.value);
//      list.printList();
    }
}
