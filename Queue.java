import java.util.*;
import java.util.Stack;

public class Queue<T> {
    public ArrayList list;

    public Queue() {
        // инициализация внутреннего хранилища очереди
        list = new ArrayList();
    }

    public void enqueue(T item) {
        // вставка в хвост
        list.add(item);
    }

    public T dequeue() {
        // выдача из головы
        if (list.size() > 0) {
            T type = (T) list.get(0);
            list.remove(0);
            return type;
        } else
            return null; // null если очередь пустая
    }

    public T peek(){
        if (list.size() > 0){
            T type = (T) list.get(0);
            return type;
        }else
            return null;
    }

    public int size() {
        return list.size();
        // размер очереди
    }

    public Stack task4(Stack stack, Stack stack1) {
        while (stack.size() > 0) {
            stack1.push(stack.pop());
        }
        return stack1;
    }

    public Queue rotation(Queue queue, int cycle) {

        for (int i = 0; i < cycle; i++) {
            queue.enqueue(queue.dequeue());
        }
        return queue;
    }
    
}
