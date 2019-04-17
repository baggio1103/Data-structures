import java.util.ArrayList;
import java.util.*;

public class Stack<T> {
    public ArrayList list;
    public int stackSize;

    public Stack() {
        // инициализация внутреннего хранилища стека
        list = new ArrayList();
    }

    public int size() {
        // размер текущего стека
        return list.size();
    }

    public T pop() {
        // ваш код
        if (list.size() > 0) {
            T t = (T) list.get(0);
            list.remove(0);
            return t;
        } else
            return null;
    }

    public void push(T val) {
        // ваш код
        list.add(0, val);
    }

    public T peek() {
        // ваш код
        if (list.size() > 0) {
            return (T) list.get(0);
        } else
            return null; // если стек пустой
    }

    public int extraTask(Stack stack) {
        int result = 0;
        Stack stack2 = new Stack();
        while (stack.size() > 0) {
            Object ob = stack.pop();
            if ((!ob.equals('+') && !ob.equals('*')) && !ob.equals('=')) {
                stack2.push(ob);
            } else if (ob.equals('*')) {
                while (stack2.size() > 0) {
                    result *= (int) stack2.pop();
                }
            } else if (ob.equals('+')) {
                while (stack2.size() > 0) {
                    result += (int) stack2.pop();
                }
            } else if (ob.equals('=')) {
                return result;
            }
        }
        return 0;
    }

    public String task4(String s) {
        //передается строка , состоящая только из открывающих и закрывающих скобок
        Stack stack = new Stack();
        int count = 0;
        for (int i = s.length()-1; i >=0; i--) {
            stack.push(s.charAt(i));
        }
        if (stack.size() % 2 == 0) {
            while (stack.size() > 0) {
                if (count < 0) {
                    return "Not balanced";
                }
                if (stack.pop().equals('(')) {
                    count++;
                } else
                    count--;
            }

            if (count == 0) {
                return "Balanced";
            } else {
                return "Not balanced";
            }

        } else {
            return "Not balanced";
        }
    }
}
