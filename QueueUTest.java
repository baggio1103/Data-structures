import org.junit.Test;
import java.util.Stack;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void enqueue() {
        Queue queue = new Queue();
        queue.enqueue("success");
        for(int i = 0; i < 10; i++){
        queue.enqueue(i);
        }
        assertEquals(11, queue.size());
        assertEquals("success", queue.dequeue());

    }

    @Test
    public void dequeue() {
        Queue queue = new Queue();
       assertEquals(null, queue.dequeue());
       for (int i = 5; i < 25; i++){
           queue.enqueue(i);
       }
       for(int i = 0; i < 9; i++){
           queue.dequeue();
       }
       assertEquals(14,queue.dequeue());
    }

    @Test
    public void size() {
        Queue queue = new Queue();
        assertEquals(0, queue.size());
        for (int i = 0; i < 25; i++) {
            queue.enqueue(i);
        }
        assertEquals(25, queue.size());
        for (int i = 0; i < 11; i++){
            queue.dequeue();
        }
        assertEquals(14,queue.size());

    }

    @Test
    public void task4() {
        Queue queue = new Queue();
        Stack stack = new Stack();
        for (int i = 1; i < 10; i++){
            stack.push(i);
        }
        int z = 1;
        Stack stack1 = new Stack();
        while (queue.task4(stack, stack1).size() > 0){
        assertEquals(z,queue.task4(stack, stack1).pop());
        z++;
        }

    }

    @Test
    public void rotation() {
        Queue queue = new Queue();
        for (int i = 1; i < 10; i++) {
        queue.enqueue(i);
        }
        queue.rotation(queue,5);
        assertEquals(6,queue.dequeue());
//        while (queue.size() > 0){
//            System.out.print(queue.dequeue() + " ");
//        }

    }
}
