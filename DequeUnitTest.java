import org.junit.Test;
import static org.junit.Assert.*;

public class DequeTest {

    @Test
    public void addFront() {
     Deque deque = new Deque();
     assertEquals(0,deque.size());
     deque.addFront(99);
     assertEquals(1,deque.size());
     assertEquals(99,deque.removeFront());
     deque.addFront(55);
     deque.addFront(77);
     assertEquals(2,deque.size());
     assertEquals(77,deque.removeFront());
    }

    @Test
    public void addTail() {
     Deque deque = new Deque();
     deque.addTail(11);
     assertEquals(11,deque.removeTail());
     deque.addTail(22);
     deque.addTail(33);
     deque.addTail(121);
     deque.addTail(77);
     assertEquals(4,deque.size());
     assertEquals(77,deque.removeTail());
    }

    @Test
    public void removeFront() {
     Deque deque = new Deque();
     for (int i = 0; i < 10; i++){
         deque.addTail(i);
     }
     assertEquals(10,deque.size());
     assertEquals(0,deque.removeFront());
     assertEquals(1,deque.removeFront());
     assertEquals(2,deque.removeFront());
     assertEquals(3,deque.removeFront());
     deque.addFront(12345);
     assertEquals(12345,deque.removeFront());
    }

    @Test
    public void removeTail() {
     Deque deque = new Deque();
        for (int i = 0; i < 20; i++) {
        deque.addTail(i);
        }
     assertEquals(20,deque.size());
     assertEquals(19,deque.removeTail());
     assertEquals(18,deque.removeTail());
     assertEquals(17,deque.removeTail());
     assertEquals(16,deque.removeTail());
     deque.addTail(478);
     deque.addTail(785);
     assertEquals(785,deque.removeTail());
     assertEquals(17,deque.size());
    }

    @Test
    public void task3() {
    Deque deque = new Deque();
    Deque deque1 = new Deque();
    assertEquals(true , deque.task3(deque, deque1, "hoohooh"));
    assertEquals(false, deque.task3(deque,deque1, "lamp"));
    assertEquals(true, deque.task3(deque, deque1, "шалаш"));
    }
}
