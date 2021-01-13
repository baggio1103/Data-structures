import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleGraphTest {
    @Test
    public void depthFirstSearch() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(-25);
        graph.AddVertex(5);
        graph.AddVertex(10);
        graph.AddVertex(15);
        graph.AddVertex(20);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);
        graph.AddEdge(1, 4);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 3);
        graph.AddEdge(3, 3);
        graph.AddEdge(3, 4);
        graph.print(graph.DepthFirstSearch(0,1));
        System.out.println();
        graph.print(graph.DepthFirstSearch(0,4));
        System.out.println();
        System.out.println(graph.DepthFirstSearch(0,1).size());

    }
}
