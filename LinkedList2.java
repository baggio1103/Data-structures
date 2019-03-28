import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;
    public int count;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value) {
        // здесь будет ваш код поиска
        Node node = head;
        while (node != null) {
            if (node.value == _value) {
                return node;
            } else
                node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        // здесь будет ваш код поиска всех узлов по заданному значению
        Node node = head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
                node = node.next;
            } else
                node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        // здесь будет ваш код удаления одного узла по заданному значению
        Node node = head;
        Node newNode;
        if (head == null) {
            return false;
        }
        if (head.next == null && head.value == _value) {
            head = null;
            tail = null;
            return true;
        }
        while (node != null) {
            if (head.value != _value && head.next == null) {
                return false;
            }
            if (head.value == _value) {
                newNode = head.next;
                head = null;
                head = newNode;
                head.prev = null;
                return true;
            }

            if (node.next == tail && tail.value == _value) {
                node.next = null;
                tail = node;
                tail.prev = node.prev;
                return true;
            } else if (node.next.value == _value) {
                newNode = node;
                node = node.next;
                newNode.next = node.next;
                node = newNode;
                return true;
            } else
                node = node.next;
            if (node.next == null) {
                return false;
            }

        }
        return false;
    }

    public void removeAll(int _value) {
        // здесь будет ваш код удаления всех узлов по заданному значению
        Node node = head;
        Node newNode;
        while (node != null) {
            if (head.value == _value) {
                head = head.next;
                head.prev = null;
            } else if (node.next == tail && tail.value == _value) {
                newNode = node.prev;
                node.next = null;
                tail = node;
                tail.prev = newNode;
                tail.next = null;
                break;
            } else if (node.next.value == _value) {
                newNode = node;
                node = node.next;
                newNode.next = node.next;
                node = newNode;
            } else {
                head.prev = null;
                newNode = node;
                node = node.next;
                node.prev = newNode;
            }
            if (node.next == null) {
                break;
            }
        }
    }

    public void clear() {
        // здесь будет ваш код очистки всего списка
        Node node = head;
        Node newNode;
        while (head != null) {
            newNode = head.next;
            head.prev = null;
            head = null;
            head = newNode;
             if(head == null){
                tail = null;
            }
          }
       }

    public int count() {
        // здесь будет ваш код подсчёта количества элементов в списке
        count = 0;
        Node node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        // здесь будет ваш код вставки узла после заданного узла
        // если _nodeAfter = null
        // добавьте новый элемент первым в списке
        Node node = head;
        Node newNode;
        if (_nodeAfter == null && count() == 0) {
            head = _nodeToInsert;
            tail = _nodeToInsert;
            head.prev = null;
        } else if (_nodeAfter == null) {
            newNode = head;
            head.prev = _nodeToInsert;
            head = _nodeToInsert;
            head.next = newNode;
        } else
            while (node != null) {
                if (node == tail && node.value == _nodeAfter.value) {
                    tail.next = _nodeToInsert;
                    tail = _nodeToInsert;
                    tail.prev = node;
                    break;
                } else if (node.value == _nodeAfter.value) {
                    newNode = node;
                    node = node.next;
                    newNode.next = _nodeToInsert;
                    _nodeToInsert.next = node;
                    _nodeToInsert.prev = newNode;
                    break;
                } else
                    node = node.next;
            }
    }

    public void addInHead(Node item) {
        if (head == null) {
            head = item;
            tail = item;
            head.prev = null;
            head.next = null;
        } else {
            head.prev = item;
            item.next = head;
        }
        head = item;
        head.prev = null;
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
    public Node headOfList(LinkedList2 list2) {
        return list2.head;
    }

    public Node tailOfList(LinkedList2 list2) {
        return list2.tail;
    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}
