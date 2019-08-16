import java.util.*;
class SimpleTreeNode<T>
{
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null
    public boolean haveChild = false;


    public SimpleTreeNode(T val, SimpleTreeNode<T> parent)
    {
        NodeValue = val;
        this.Parent = parent;
        Children = new ArrayList<>();
    }
}

class SimpleTree<T> {
    public SimpleTreeNode<T> Root; // корень, может быть null
    public int count;
    public List<SimpleTreeNode<T>> values = new ArrayList<>();
    public int nums;

    public SimpleTree(SimpleTreeNode<T> root) {
        this.Root = root;
        count = 1;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) {
        // ваш код добавления нового дочернего узла существующему ParentNode
        ParentNode.Children.add(NewChild);
        count++;
        ParentNode.haveChild = true;
        if (ParentNode == Root) {
            NewChild.Parent = Root;
        } else {
            NewChild.Parent = ParentNode;
        }
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete) {
        // ваш код удаления существующего узла NodeToDelete
        if (NodeToDelete == Root) {
            Root = null;
        } else {
            NodeToDelete.Parent.Children.remove(NodeToDelete);
        }
        count--;
    }

    public List<SimpleTreeNode<T>> GetAllNodes() {
        List<SimpleTreeNode<T>> listOfNodes = new ArrayList<>();
        GetAllNodesRec(Root, listOfNodes);
        return listOfNodes;
    }

    public void GetAllNodesRec(SimpleTreeNode<T> node, List<SimpleTreeNode<T>> list) {
        list.add(node);
        for (SimpleTreeNode<T> node1 : node.Children) {
            if (node1.haveChild) {
                GetAllNodesRec(node1, list);
            } else
                list.add(node1);
        }
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
        // ваш код поиска узлов по значению
        List<SimpleTreeNode<T>> list = new ArrayList<>();
        for (SimpleTreeNode<T> nod : GetAllNodes()) {
            if (nod.NodeValue.equals(val)) {
                list.add(nod);
            }
        }
        return list;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) {
        // ваш код перемещения узла вместе с его поддеревом --
        // в качестве дочернего для узла NewParent
        if (OriginalNode == Root) {
            return;
        }

        OriginalNode.Parent.Children.remove(OriginalNode);

        if (OriginalNode.Parent.Children.size() == 0) {
            OriginalNode.Parent.haveChild = false;
        }

        OriginalNode.Parent = null;
        NewParent.Children.add(OriginalNode);
        NewParent.haveChild = true;
    }

    public void printTree(List<SimpleTreeNode<T>> list) {
        for (SimpleTreeNode<T> nod : list) {
            System.out.print(nod.NodeValue + " ");
        }
        System.out.println();
    }

    public int Count() {
        // количество всех узлов в дереве
        return count;
    }

    public int LeafCount() {
        // количество листьев в дереве
        int leafCount = 0;

        for (SimpleTreeNode<T> nods : GetAllNodes()) {
            if (nods.Children.size() == 0) {
                leafCount++;
            }
        }
        return leafCount;
    }

    public ArrayList<Integer> EvenTrees() {
        // ...
        ArrayList<Integer> list = new ArrayList<>();
        for (SimpleTreeNode<T> nodes : GetAllNodes()) {
            recCount(nodes);
            if (((nums % 2) == 0) && (nums != 0) && (nodes != Root)) {
                list.add((Integer) nodes.Parent.NodeValue);
                list.add((Integer) nodes.NodeValue);
            }
            nums = 0;
        }
        return list;
    }
    
    public void recCount(SimpleTreeNode<T> node) {
        nums++;
        for (SimpleTreeNode<T> node1 : node.Children) {
            if (node1.haveChild) {
                recCount(node1);
            } else {
                nums++;
            }
        }
    }
}
