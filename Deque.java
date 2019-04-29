import java.util.*;
public class Deque<T>
{
    LinkedList<T> list;
     public Deque()
     {
      //инициализация внутреннего хранилища
     list = new LinkedList<T>();
     }

     public void addFront(T item)
     {
      //довабление в голову
     list.add(0,item);
     }

     public void addTail(T item)
     {
      //добавление в хвост
      list.add(item);
     }

     public T removeFront() {
         //
         if (list.size() > 0) {
         T type = list.get(0);
         list.remove(0);
         return type;
         } else {
             return null;
         }
     }

     public T removeTail()
     {
         //
         if (list.size() > 0) {
             T type = list.get(list.size()-1);
             list.remove(list.size()-1);
             return type;
         } else {
             return null;
         }
     }

     public int size()
     {
         return list.size(); // размер очереди
     }

     public boolean task3(Deque deque , Deque deque1, String s) {
         String front = "";
         String tail = "";
         for (int i = 0; i < s.length(); i++) {
             deque.addTail(s.charAt(i));
             deque1.addTail(s.charAt(i));
         }

         while (deque.size() > 0) {
             front += deque.removeFront();
         }

         while (deque1.size() > 0) {
             tail += deque1.removeTail();
         }
         if (front.equals(tail)) {
             return true;
         } else {
             return false;
         }
     }
}
