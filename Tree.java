import java.util.*;
public class SimpleTreeNode<T>
{
    public T nodeValue; // значение в узле
    public SimpleTreeNode<T> parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> children; // список дочерних узлов или null
    public boolean haveChild = false;


    public SimpleTreeNode(T val, SimpleTreeNode<T> parent)
    {
        nodeValue = val;
        this.parent = parent;
        children = new ArrayList<>();
    }
}

class SimpleTree<T> {
    public SimpleTreeNode<T> root; // корень, может быть null
    public int count;
    public List<SimpleTreeNode<T>> nodes = new ArrayList<>();
    public List<SimpleTreeNode<T>> values = new ArrayList<>();

    public SimpleTree(SimpleTreeNode<T> root) {
        this.root = root;
        count = 1;
    }

    public void addChild(SimpleTreeNode<T> parentNode, SimpleTreeNode<T> newChild) {
        // ваш код добавления нового дочернего узла существующему ParentNode
        parentNode.children.add(newChild);
        count++;
        parentNode.haveChild = true;
        if (parentNode == root) {
            newChild.parent = root;
        } else {
            newChild.parent = parentNode;
        }
    }

    public void deleteNode(SimpleTreeNode<T> nodeToDelete) {
        // ваш код удаления существующего узла NodeToDelete
        if (nodeToDelete == root){
            root = null;
        }
        else {
            nodeToDelete.parent.children.remove(nodeToDelete);
        }
        count--;
    }




    public List<SimpleTreeNode<T>> getAllNodes(){
      collectNodes(root, nodes);
      return nodes;
    }

    public void collectNodes(SimpleTreeNode<T> node, List<SimpleTreeNode<T>> list) {
            list.add(node);
            for (SimpleTreeNode<T> node1 : node.children) {
                    if (node1.haveChild) {
                        collectNodes(node1, list);
                    } else
                        list.add(node1);
            }
    }

    public List<SimpleTreeNode<T>> findNodesByValue(T val) {
        // ваш код поиска узлов по значению
        SimpleTreeNode<T> node = root;
        collectNodes(node, values);
        List<SimpleTreeNode<T>> list = new ArrayList<>();
        for (SimpleTreeNode<T> nod : values){
            if (nod.nodeValue.equals(val)){
                list.add(nod);
            }
        }
        return list;
    }

    public void moveNode(SimpleTreeNode<T> originalNode, SimpleTreeNode<T> newParent) {
        // ваш код перемещения узла вместе с его поддеревом --
        // в качестве дочернего для узла NewParent
        if (originalNode == root){
            return;
        }

        originalNode.parent.children.remove(originalNode);

        if (originalNode.parent.children.size() == 0){
            originalNode.parent.haveChild = false;
        }

       originalNode.parent = null;
       newParent.children.add(originalNode);
       newParent.haveChild = true;

    }


    public void printTree(List<SimpleTreeNode<T>> list) {
        for (SimpleTreeNode<T> nod : list){
            System.out.print(nod.nodeValue + " ");
        }
        System.out.println();
    }

    public int count() {
        // количество всех узлов в дереве
        return count;
    }

    public int leafCount() {
        // количество листьев в дереве
        int leafCount = 0;
        List<SimpleTreeNode<T>> leaves = new ArrayList<>();
        collectNodes(root, leaves);
        for (SimpleTreeNode<T> nods : leaves){
            if (!nods.haveChild){
                leafCount++;
            }
        }
        return leafCount;
    }
}
