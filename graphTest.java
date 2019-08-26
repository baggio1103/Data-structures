import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleGraphTest {

    @Test
    public void depthFirstSearch() {
        SimpleGraph graph = new SimpleGraph(7);
        for (int i = 0; i < graph.vertex.length; i++) {
            int j = (int) (Math.random() * 16);
            graph.AddVertex(j);
        }
        graph.AddEdge(0, 1);
        graph.AddEdge(1, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(0, 3);
        graph.AddEdge(0, 4);
        graph.AddEdge(4, 5);
        graph.AddEdge(3, 5);
        graph.AddEdge(5, 6);
        graph.print(graph.DepthFirstSearch(0, 6));
    }

}
