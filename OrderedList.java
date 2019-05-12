import java.util.*;
class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}
public class OrderedList<T> {
    public Node<T> head;
    public Node<T> tail;
    private boolean _ascending;
    public int count = 0;


    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        // -1 если v1 < v2
        // 0 если v1 == v2
        // +1 если v1 > v2
        if (v1 instanceof Integer && v2 instanceof Integer) {
         return ((Integer) v1).compareTo((Integer) v2);
        }
        else if (v1 instanceof String && v2 instanceof String) {
            return ((String) v1).compareTo((String) v2);
        }
        else return 0;
    }

    public void add(T value) {
        // автоматическая вставка value
        // в нужную позицию
        Node node = head;
        Node newNode = new Node(value);
        if (_ascending == true) {
            if (count == 0) {
                head = new Node<>(value);
                tail = head;
                count++;
            } else if (count == 1 && compare(value, head.value) < 0) {
                Node node1 = head;
                head.prev = newNode;
                head = newNode;
                head.next = node1;
                tail = node1;
                tail.prev = head;
                count++;
            } else if (count == 1 && compare(value, head.value) >= 0) {
                tail.next = newNode;
                tail = newNode;
                tail.prev = head;
                count++;
            } else if (compare(value, head.value) <= 0) {
                Node node1 = head;
                head.prev = newNode;
                head = newNode;
                head.next = node1;
                count++;
            } else if (compare(value, tail.value) >= 0) {
                Node node1 = tail;
                tail.next = newNode;
                tail = newNode;
                tail.prev = node1;
                count++;
            } else {
                while (compare(value, (T) node.value) >= 0) {
                    if (node.next != null && compare(value, (T) node.next.value) <= 0) {
                        Node node1 = node.next;
                        node.next = newNode;
                        newNode.next = node1;
                        node1.prev = newNode;
                        newNode.prev = node;
                        if (node == tail) {
                            Node nod = tail.prev;
                            tail.prev = newNode;
                            newNode.prev = nod;
                        }
                        count++;
                        break;
                    } else
                        node = node.next;
                    if (node == null) {
                        break;
                    }
                }
            }
        }
        else {
            addDescending(value);
        }
    }

    public Node<T> find(T val) {
        Node node = head;
        while (node != null) {
            if (node.value.equals(val)) {
                return node;
            } else
                node = node.next;
        }
        return null;
    }

    public void addDescending(T value){
        Node node = head;
        Node newNode = new Node(value);
        if (count == 0) {
            head = new Node<>(value);
            tail = head;
            count++;
        } else if (count == 1 && compare(value, head.value) < 0) {
            head.next = newNode;
            tail = newNode;
            tail.prev = head;
            count++;
        } else if (count == 1 && compare(value, head.value) >= 0) {
            Node nod = head;
            head.prev = newNode;
            head = newNode;
            head.next = nod;
            tail = nod;
            tail.prev = head;
            count++;
        } else if (compare(value, tail.value) <= 0) {
            Node node1 = tail;
            tail.next = newNode;
            tail = newNode;
            tail.prev = node1;
            count++;
        } else if (compare(value, head.value) >= 0) {
            Node node1 = head;
            head.prev = newNode;
            head = newNode;
            head.next = node1;
            count++;
        } else {
            while (compare(value, (T) node.value) <= 0) {
                if (node.next != null && compare(value, (T) node.next.value) >= 0) {
                    Node node1 = node.next;
                    node.next = newNode;
                    newNode.next = node1;
                    node1.prev = newNode;
                    newNode.prev = node;
                    if (node == tail) {
                        Node nod = tail.prev;
                        tail.prev = newNode;
                        newNode.prev = nod;
                    }
                    count++;
                    break;
                } else
                    node = node.next;
                if (node == null) {
                    break;
                }
            }
        }
    }

    public void delete(T val) {
        // здесь будет ваш код
        if (count() > 0) {
            Node node = head;
            Node newNode;
            if (head == null) {
                tail = null;
            }
            if (head.next == null && head.value.equals(val)) {
                head = null;
                tail = null;
                count--;
            } else {
                while (node != null) {
                    if (head.value.equals(val)) {
                        newNode = head.next;
                        head = null;
                        head = newNode;
                        head.prev = null;
                        count--;
                        break;
                    }
                    if (node.next == tail && tail.value.equals(val)) {
                        node.next = null;
                        tail = node;
                        tail.prev = node.prev;
                        count--;
                        break;
                    } else if (node != tail && node.next.value.equals(val)) {
                        newNode = node;
                        node = node.next;
                        Node nod = node.next;
                        newNode.next = nod;
                        nod.prev = newNode;
                        count--;
                        break;
                    } else {
                        node = node.next;
                    }
                }
            }
        }
    }

    public void clear(boolean asc) {
        _ascending = asc;
        // здесь будет ваш код
        Node node = head;
        Node newNode;
        while (head != null) {
            newNode = head.next;
            head.prev = null;
            head = null;
            head = newNode;
            if (head == null) {
                tail = null;
            }
        }
        count = 0;
    }

    public int count() {
        count = 0;
        Node node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void reversedList() {
        Node node = tail;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.prev;
        }
        System.out.println();
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного
    // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}
