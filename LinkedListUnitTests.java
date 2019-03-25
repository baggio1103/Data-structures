import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void removeAll() {
     LinkedList list = new LinkedList();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(3));
        list.addInTail(new Node(3));
        list.removeAll(3);
        list.count();
        list.headOfList(list);
        list.tailOfList(list);
        int actual = 2;
        int expected = list.count();
        int headTest = 1;
        int tailTest = 2;
        int expectedHead = list.headOfList(list);
        int expectedTail =  list.tailOfList(list);
        assertEquals(actual,expected);
        assertEquals(headTest, expectedHead);
        assertEquals(tailTest,expectedTail);
        assertEquals(actual,expected);
    }
}
