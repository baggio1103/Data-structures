import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleGraphTest {
    @Test
    public void WeakVertices() {

        SimpleGraph graph = new SimpleGraph(9);
        graph.AddVertex(5);
        graph.AddVertex(7);
        graph.AddVertex(9);
        graph.AddVertex(11);
        graph.AddVertex(13);
        graph.AddVertex(15);
        graph.AddVertex(17);
        graph.AddVertex(19);
        graph.AddVertex(21);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);
        graph.AddEdge(1, 2);
        graph.AddEdge(1, 4);
        graph.AddEdge(2, 3);
        graph.AddEdge(2, 5);
        graph.AddEdge(4, 5);
        graph.AddEdge(5, 6);
        graph.AddEdge(5, 7);
        graph.AddEdge(6, 7);
        graph.AddEdge(7, 8);
        assertEquals(2,graph.WeakVertices().size());
        assertEquals(4,graph.WeakVertices().get(0).Value);
        assertEquals(8, graph.WeakVertices().get(1).Value);

        SimpleGraph graph1 = new SimpleGraph(9);
        graph1.AddVertex(5);
        graph1.AddVertex(7);
        graph1.AddVertex(9);
        graph1.AddVertex(11);
        graph1.AddVertex(13);
        graph1.AddVertex(15);
        graph1.AddVertex(17);
        graph1.AddVertex(19);
        graph1.AddVertex(21);
        graph1.AddEdge(0, 1);
        graph1.AddEdge(0, 2);
        graph1.AddEdge(0, 3);
        graph1.AddEdge(1, 2);
        graph1.AddEdge(1, 4);
        graph1.AddEdge(2, 3);
        graph1.AddEdge(2, 5);
        graph1.AddEdge(4, 5);
        graph1.AddEdge(5, 6);
        graph1.AddEdge(5, 7);
        graph1.AddEdge(6, 7);
        graph1.AddEdge(7, 8);
        graph1.AddEdge(1, 5);
        System.out.println(graph1.WeakVertices().size());
        assertEquals(1, graph1.WeakVertices().size());
        assertEquals(8, graph1.WeakVertices().get(0).Value);
    }
}
