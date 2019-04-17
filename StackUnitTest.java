import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void size() {
    Stack stack = new Stack();
    assertEquals(0, stack.size());
    for (int i = 0; i < 25; i++){
        stack.push(i);
    }
    assertEquals(25, stack.size());
    for (int i = 24; i >= 0; i--){
        stack.pop();
    }
    assertEquals(0 , stack.size());
    }
    @Test
    public void pop() {
    Stack stack = new Stack();
    assertEquals(null, stack.pop());
    for (int i = 0; i < 20; i++){
        stack.push(i);
    }
    assertEquals(19,stack.pop());
    assertEquals(19,stack.size());
    assertEquals(18, stack.pop());
    }
    @Test
    public void push() {
    Stack stack = new Stack();
    stack.push(77);
    assertEquals(77, stack.peek());
    stack.push("science");
    assertEquals("science", stack.peek());
    }
    @Test
    public void peek() {
    Stack stack = new Stack();
    assertEquals(null, stack.peek());
    for (int i = 0; i < 5; i++){
      stack.push(i);
    }
    assertEquals(4,stack.peek());
    stack.pop();
    assertEquals(3,stack.peek());
    }

    @Test
    public void extraTask() {
    Stack stack1 = new Stack();
     stack1.push('=');
     stack1.push('+');
     stack1.push(9);
     stack1.push('*');
     stack1.push(5);
     stack1.push('+');
     stack1.push(2);
     stack1.push(8);
     assertEquals(59,stack1.extraTask(stack1));


    }

    @Test
    public void task4() {
    Stack stack = new Stack();
    assertEquals("Balanced", stack.task4("(()((())()))"));
    assertEquals("Not balanced", stack.task4("())("));
    }
}
