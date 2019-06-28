import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleTreeTest {

    @Test
    public void addChild() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(9, null);
        SimpleTree<Integer> tree = new SimpleTree<>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<>(4, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<>(17, root);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<>(3, root);
        tree.AddChild(root,node1);
        tree.AddChild(root, node2);
        tree.AddChild(node1,node3);
        assertEquals(root.Children.get(0).NodeValue,node1.NodeValue);
        assertEquals(root.Children.get(1).NodeValue,node2.NodeValue);
    }

    @Test
    public void deleteNode() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(9, null);
        SimpleTree<Integer> tree = new SimpleTree<>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<>(4, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<>(17, root);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<>(3, root);
        tree.AddChild(root,node1);
        tree.AddChild(root, node2);
        tree.AddChild(node1,node3);
        tree.DeleteNode(node1);
        assertEquals(tree.Count(),3);
        assertEquals(root.Children.get(0).NodeValue, node2.NodeValue);
    }

    @Test
    public void getAllNodes() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(9, null);
        SimpleTree<Integer> tree = new SimpleTree<>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<>(4, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<>(17, root);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<>(3, root);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<>(6, root);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<>(5, node1);
        SimpleTreeNode<Integer> node6 = new SimpleTreeNode<>(7,node5);
        SimpleTreeNode<Integer> node7 = new SimpleTreeNode<>(22, node1);
        SimpleTreeNode<Integer> node8 = new SimpleTreeNode<>(20, node1);
        tree.AddChild(root, node1);
        tree.AddChild(root, node2);
        tree.AddChild(node1, node3);
        tree.AddChild(node1,node4);
        tree.AddChild(node4,node5);
        tree.AddChild(node4,node6);
        tree.AddChild(node2,node7);
        tree.AddChild(node7,node8);
        tree.printTree(tree.GetAllNodes());
    }


    @Test
    public void moveNode() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(9, null);
       int [] i = {9,17,5,4,3,6,};
        SimpleTree<Integer> tree = new SimpleTree<>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<>(4, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<>(17, root);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<>(3, root);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<>(6, root);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<>(5, node1);
        tree.AddChild(root, node1);
        tree.AddChild(root, node2);
        tree.AddChild(node1, node3);
        tree.AddChild(node1, node4);
        tree.AddChild(node2, node5);
        tree.MoveNode(node1, node5);
        boolean check = true;
        tree.GetAllNodes();
        System.out.println(tree.nodes.size());
       for (int j = 0; j < tree.nodes.size(); j++){
           if (i[j] != tree.nodes.get(j).NodeValue){
               check = false;
           }
       }
        assertTrue(check);
    }

    @Test
    public void leafCount() {
    }
}
