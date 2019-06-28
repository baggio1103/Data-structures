import java.util.*;
public class SimpleTreeNode<T>
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
    public List<SimpleTreeNode<T>> nodes = new ArrayList<>();
    public List<SimpleTreeNode<T>> values = new ArrayList<>();

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
        if (NodeToDelete == Root){
            Root = null;
        }
        else {
            NodeToDelete.Parent.Children.remove(NodeToDelete);
        }
        count--;
    }




    public List<SimpleTreeNode<T>> GetAllNodes(){
      collectNodes(Root, nodes);
      return nodes;
    }

    public void collectNodes(SimpleTreeNode<T> node, List<SimpleTreeNode<T>> list) {
            list.add(node);
            for (SimpleTreeNode<T> node1 : node.Children) {
                    if (node1.haveChild) {
                        collectNodes(node1, list);
                    } else
                        list.add(node1);
            }
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
        // ваш код поиска узлов по значению
        SimpleTreeNode<T> node = Root;
        collectNodes(node, values);
        List<SimpleTreeNode<T>> list = new ArrayList<>();
        for (SimpleTreeNode<T> nod : values){
            if (nod.NodeValue.equals(val)){
                list.add(nod);
            }
        }
        return list;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) {
        // ваш код перемещения узла вместе с его поддеревом --
        // в качестве дочернего для узла NewParent
        if (OriginalNode == Root){
            return;
        }

        OriginalNode.Parent.Children.remove(OriginalNode);

        if (OriginalNode.Parent.Children.size() == 0){
            OriginalNode.Parent.haveChild = false;
        }

       OriginalNode.Parent = null;
       NewParent.Children.add(OriginalNode);
       NewParent.haveChild = true;

    }


    public void printTree(List<SimpleTreeNode<T>> list) {
        for (SimpleTreeNode<T> nod : list){
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
        List<SimpleTreeNode<T>> leaves = new ArrayList<>();
        collectNodes(Root, leaves);
        for (SimpleTreeNode<T> nods : leaves){
            if (!nods.haveChild){
                leafCount++;
            }
        }
        return leafCount;
    }
}
