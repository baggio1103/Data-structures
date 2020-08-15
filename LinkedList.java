import java.util.*;

public class LinkedList {
    public Node head;
    public Node tail;
    public int count;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        // здесь будет ваш код поиска всех узлов
        Node node = head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node node = head;
        Node newNode;
         if (head.next == null && head.value == _value) {
            head = null;
            tail = null;
            return true;
        }
        while (node != null) {
            if(head.value != _value && head.next == null){
                return false;
            }
            if (head.value == _value) {
                head = head.next;
                return true;
            }
            if ((node.next == tail) && (tail.value == _value)) {
                node.next = null;
                tail = node;
                return true;
            } else if (node.next.value == _value) {
                newNode = node;
                node = node.next;
                newNode.next = node.next;
                node = newNode;
                return true;
            } else {
                node = node.next;
            }

            if (node.next == null) {
                return false;
            }

        }
        return false;
    }

    public void removeAll(int _value) {
        Node node = head;
        Node newNode;
        // здесь будет ваш код удаления всех узлов по заданному значению
        while (node != null) {
            if (head.next == null && head.value == _value) {
                head = null;
                tail = null;
                break;
            }
              if(head.value != _value && head.next == null){
                break;
            }    
            if (head.value == _value) {
                newNode = head;
                head = null;
                head = newNode.next;
            }
            if ((node.next == tail) && (tail.value == _value)) {
               node.next = null;
               tail = node;
                break;
            } 
            else if (node.next.value == _value) {
                newNode = node;
                node = node.next;
                newNode.next = node.next;
                node = newNode;
            } else {
                node = node.next;
            }
           
            if (node.next == null) {
                break;
            }
        }
    }

    public void clear() {
      Node node = head;
    Node newNode;
    while (head != null) {
        newNode = head;
        head = null;
        head = newNode.next;
        if(head == tail){
            tail = null;
        }
     }
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

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        Node node = head;
        Node newNode;
         if(_nodeAfter == null && count() == 0){
            head = _nodeToInsert;
            tail = _nodeToInsert;
        }
                 else if(_nodeAfter != null) {
             while (node != null) {
                 
                 if(node == tail && node.value == _nodeAfter.value){
                    tail.next = _nodeToInsert;
                    tail = _nodeToInsert;
                    break;
                }
                else if (node.value == _nodeAfter.value) {
                     newNode = node;
                     node = node.next;
                     newNode.next = _nodeToInsert;
                     _nodeToInsert.next = node;
                     break;
                 } else
                     node = node.next;
             }
         }
    }

    public LinkedList listReturn(LinkedList list, LinkedList list2) {
        LinkedList newList = null;
        if (list.count() == list2.count()) {
            newList = new LinkedList();
            Node node1 = list.head;
            Node node2 = list2.head;
            while (node1 != null && node2 != null) {
                newList.addInTail(new Node(node1.value + node2.value));
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        newList.printList();
        return newList;
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + "  ");
            node = node.next;
        }
        System.out.println();
    }

    public Node headOfList(LinkedList list) {
        return list.head;
    }

    public Node tailOfList(LinkedList list) {
        return list.tail;
    }
}
class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}

