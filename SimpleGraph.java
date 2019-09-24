import java.util.*;
import java.util.Stack;

class Queue<T> {
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

class Vertex
{
    public int Value;
    public boolean Hit;
    public int parent;
    public Vertex(int val)
    {
        Value = val;
        Hit = false;
        parent = 0;
    }
}

class SimpleGraph {
    Vertex[] vertex;
    int[][] m_adjacency;
    int max_vertex;


    public SimpleGraph(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex = new Vertex[size];
    }

    public void AddVertex(int value) {
        // ваш код добавления новой вершины
        // с значением value
        // в незанятую позицию vertex
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == null) {
                vertex[i] = new Vertex(value);
                i = vertex.length;
            }
        }
    }

    // здесь и далее, параметры v -- индекс вершины
    // в списке  vertex
    public void RemoveVertex(int v) {
        // ваш код удаления вершины со всеми её рёбрами
        for (int i = 0; i < vertex.length; i++) {
            if (i == v) {
                for (int j = 0; j < vertex.length; j++) {
                    m_adjacency[j][i] = 0;
                }
                for (int j = 0; j < vertex.length; j++) {
                    m_adjacency[i][j] = 0;
                }
                vertex[i] = null;
                i = vertex.length;
            }
        }
    }

    public boolean IsEdge(int v1, int v2) {
        // true если есть ребро между вершинами v1 и v2
        if (m_adjacency[v1][v2] == 1 && m_adjacency[v2][v1] == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void AddEdge(int v1, int v2) {
        // добавление ребра между вершинами v1 и v2
        if (vertex[v1] != null && vertex[v2] != null) {
            m_adjacency[v1][v2] = 1;
            m_adjacency[v2][v1] = 1;
        }
    }

    public void RemoveEdge(int v1, int v2) {
        // удаление ребра между вершинами v1 и v2
        m_adjacency[v1][v2] = 0;
        m_adjacency[v2][v1] = 0;
    }

    public void turnToFalse() {
        for (Vertex v : vertex) {
            v.Hit = false;
        }
    }

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        ArrayList<Vertex> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        vertex[VFrom].Hit = true;
        if (IsEdge(VFrom, VTo) && VFrom == VTo) {
            stack.push(VFrom);
            turnToFalse();
            return stackToList(stack, list);
        } else {
            stack.push(VFrom);
            turnToFalse();
            return recursion(stack, stack.peek(), VTo, list);
        }
    }

    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo) {
        // Узлы задаются позициями в списке vertex.
        // Возвращается список узлов -- путь из VFrom в VTo.
        // Список пустой, если пути нету.
        ArrayList<Vertex> list = new ArrayList<>();
        Queue<Integer> queue = new Queue<>();
        vertex[VFrom].Hit = true;
        list.add(new Vertex(VFrom));
        queue.enqueue(VFrom);
        recursion(queue, queue.peek(), VTo, list);
        turnToFalse();
        for (int i = list.size() - 1; i >= 1; i--) {
            if (list.get(i).parent != list.get(i - 1).Value) {
                list.remove(i - 1);
            }
        }
        return list;
    }

    public ArrayList<Vertex> recursion(Queue<Integer> queue, int vert, int VTo, ArrayList<Vertex> list) {
        ArrayList<Integer> adjacent = adjacent(vert);
        if (adjacent.size() > 0) {
            for (int i = 0; i < adjacent.size(); i++) {
                if (!vertex[adjacent.get(i)].Hit) {
                    vertex[adjacent.get(i)].Hit = true;
                    if (adjacent.get(i) == VTo) {
                        queue.enqueue(adjacent.get(i));
                        list.add(new Vertex(adjacent.get(i)));
                        list.get(list.size() - 1).parent = queue.peek();
                        return list;
                    }
                    queue.enqueue(adjacent.get(i));
                    list.add(new Vertex(adjacent.get(i)));
                    list.get(list.size() - 1).parent = queue.peek();
                }
            }
            queue.dequeue();
            recursion(queue, queue.peek(), VTo, list);
        } else {
            queue.dequeue();
            if (queue.size() == 0) {
                return null;
            } else {
                recursion(queue, queue.peek(), VTo, list);
            }
        }
        return list;
    }


    public ArrayList<Vertex> recursion(Stack<Integer> stack, int vert, int VTO, ArrayList<Vertex> list) {
        ArrayList<Integer> adjacent = adjacent(vert); //This Arraylist gives a list of adjacent nodes
        if (adjacent.size() > 0) {
            for (int i = 0; i < adjacent.size(); i++) {
                if (adjacent.get(i) == VTO) {
                    vertex[adjacent.get(i)].Hit = true;
                    stack.push(adjacent.get(i));
                    return stackToList(stack, list);
                }
            }
            for (int i = 0; i < adjacent.size(); i++) {
                if (adjacent.get(i) == VTO && !vertex[adjacent.get(i)].Hit) {
                    vertex[adjacent.get(i)].Hit = true;
                    stack.push(adjacent.get(i));
                    return stackToList(stack, list);
                } else if (!vertex[adjacent.get(i)].Hit) {
                    vertex[adjacent.get(i)].Hit = true;
                    stack.push(adjacent.get(i));
                    recursion(stack, stack.peek(), VTO, list);
                }
            }
        } else {
            stack.pop();
            if (stack.size() == 0) {
                return null;
            } else
                recursion(stack, stack.peek(), VTO, list);
        }
        return list;
    }

    public ArrayList<Integer> adjacent(int vert) {
        ArrayList<Integer> vs = new ArrayList<>();
        for (int i = 0; i < vertex.length; i++) {
            if ((i != vert) && IsEdge(i, vert) && !vertex[i].Hit) {
                vs.add(i);
            }
        }
        return vs;
    }

    public ArrayList<Vertex> stackToList(Stack<Integer> stack, ArrayList<Vertex> list) {
        while (!stack.empty()) {
            list.add(0, new Vertex(stack.pop()));
        }
        return list;
    }

    public void print(ArrayList<Vertex> list) {
        if (list.size() != 0) {
            System.out.print("The route is : ");
            for (Vertex vertex : list) {
                System.out.print(vertex.Value + " ");
            }
        } else {
            System.out.print("There is no such a route");
        }
        System.out.println();
    }
    
    public ArrayList<Vertex> WeakVertices() {
        // возвращает список узлов вне треугольников
        ArrayList<Vertex> list = new ArrayList<>();
        Queue<Integer> queue = new Queue<>();
        boolean fixed = false;
        vertex[0].Hit = true;
        list.add(new Vertex(0));
        queue.enqueue(0);
        breadth(queue, queue.peek(), list);
        turnToFalse();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> arr = adjacent(list.get(i).Value);
            if (arr.size() >= 2) {
                for (int j = 0; j < arr.size() - 1; j++) {
                    if (IsEdge(arr.get(j), arr.get(j + 1))) {
                        fixed = true;
                    }
                }
                if (fixed) {
                    list.remove(i);
                    i--;
                }
            }
            fixed = false;
        }
        return list;
    }

    public ArrayList<Vertex> breadth(Queue<Integer> queue, int vFrom, ArrayList<Vertex> list) {
        ArrayList<Integer> adjacent = adjacent(vFrom);
        if (adjacent.size() > 0) {
            for (int i = 0; i < adjacent.size(); i++){
                if (!vertex[adjacent.get(i)].Hit) {
                    vertex[adjacent.get(i)].Hit = true;
                    list.add(new Vertex(adjacent.get(i)));
                    queue.enqueue(adjacent.get(i));
                }
            }
            queue.dequeue();
            breadth(queue, queue.peek(), list);
        } else {
            queue.dequeue();
            if (queue.size() == 0) {
                return list;
            }else {
                breadth(queue, queue.peek(), list);
            }
        }
        return list;
    }
    
}
