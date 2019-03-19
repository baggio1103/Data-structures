import java.util.*;

public class LinkedList {

    public Node head;
    public Node tail;
    public int count;


    public LinkedList()
    {
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
        Node node = head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node node = head;
        // здесь будет ваш код поиска всех узлов
        while (node != null){
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }

        return nodes;
    }

    public boolean remove(int _value) {
        // здесь будет ваш код удаления одного узла по заданному значению
        Node node = head;
        Node newNode;
        while (node != null) {
        if(head.value == _value){
            newNode = head;
            head = null;
            head = newNode.next;
           printList();
            return true;
        }
        else if(node.next.value == _value ){
            newNode = node;
            node = node.next;
            newNode.next = node.next;
        //    printList();
            return true;
        }
        else
            node = node.next;
           if(node.next == null){
             break;
            }

        }
      return false;
      }

    public void removeAll(int _value)
    {
        Node node = head;
        Node newNode;
        // здесь будет ваш код удаления всех узлов по заданному значению
       while (node != null){
           if(node.next == null){
               tail = node;
               break;
           }

           if(head.next == null){
               break;
           }
    // we are checking  whether the first node contains the desired value
         if(head.value == _value){
           newNode = head;
           head = null;
           head = newNode.next;
           }
    // we are checking whether other nodes contain
            else if(node.next.value == _value){
                 newNode = node;
                 node = node.next;
                 newNode.next = node.next;
                 node = newNode;
            }
            else
                node = node.next;
        }
    }

    public void clear()
    {
        // здесь будет ваш код очистки всего списка
    Node node = head;
    while (head != null){
       head = node.next;
       head = null;
    }
    }


    public int count()
    {
        count = 0;
        Node node  = head;
        while (node != null){
            count++;
            node = node.next;
        }
        return count; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
     Node node = head;
        if(node == null){
            head = _nodeToInsert;
        }

     while (node != null){
         if(node == _nodeAfter){
          node = node.next;
          _nodeAfter.next = _nodeToInsert;
          _nodeToInsert.next = node;
         }
         else
         node = node.next;
     }
    }

    public LinkedList listReturn(LinkedList list, LinkedList list2){
        LinkedList newList = null;
        if(list.count() == list2.count()){
         newList = new LinkedList();
          Node node1 = list.head;
          Node node2 = list2.head;
            while (node1 != null && node2 != null){
                newList.addInTail(new Node(node1.value+node2.value));
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        newList.printList();
        return newList;
    }
    public void printList(){
        Node node = head;
        while (node != null){
            System.out.print(node.value+ "  ");
            node = node.next;
        }
        System.out.println();
    }

    public Node headOfList(LinkedList list){
    return list.head;
    }

    public Node tailOfList(LinkedList list){
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

