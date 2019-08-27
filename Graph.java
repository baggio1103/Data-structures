import java.util.*;
import java.util.Stack;

class Vertex
{
    public int Value;
    public boolean Hit;
    public Vertex(int val)
    {
        Value = val;
        Hit = false;
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

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        ArrayList<Vertex> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        vertex[VFrom].Hit = true;
        if (IsEdge(VFrom, VTo) && VFrom == VTo){
            stack.push(VFrom);
            return stackToList(stack, list);
        }
        stack.push(VFrom);
        return recursion(stack, stack.peek(), VTo, list);

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
            System.out.println("There is no such a route");
        }
    }

}
