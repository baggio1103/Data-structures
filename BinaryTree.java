import sun.misc.Queue;
import java.util.*;
class BSTNode<T>
{
    public int NodeKey; // ключ узла
    public T NodeValue; // значение в узле
    public BSTNode<T> Parent; // родитель или null для корня
    public BSTNode<T> LeftChild; // левый потомок
    public BSTNode<T> RightChild; // правый потомок
    public boolean haveOneChild; //true, if a node have a child
    public boolean leftOrRightChild;
    public boolean haveTwoChildren;

    public BSTNode(int key, T val, BSTNode<T> parent)
    {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

// промежуточный результат поиска
class BSTFind<T>
{
    // null если не найден узел, и в дереве только один корень
    public BSTNode<T> Node;

    // true если узел найден
    public boolean NodeHasKey;

    // true, если родительскому узлу надо добавить новый левым
    public boolean ToLeft;

    public BSTFind() {
        Node = null;
    }
}

class BST<T>
{
    BSTNode<T> Root; // корень дерева, или null
    public int count;

    public BST(BSTNode<T> node)
    {
        Root = node;
        count = 1;
    }

    public BSTFind<T> FindNodeByKey(int key) {
        // ищем в дереве узел и сопутствующую информацию по ключу
        BSTFind<T> bstFind = new BSTFind<>();
        BSTNode<T> parentNode;// in case of null we have a parentNode to which a new node is added
        BSTNode<T> node = Root;
        if (node.NodeKey == key){
            bstFind.Node = node;
            bstFind.NodeHasKey = true;
            bstFind.Node.Parent = null;
            return bstFind;
        }
        else {
            while (true) {
                if (node.NodeKey == key) {
                    bstFind.Node = node;
                    bstFind.NodeHasKey = true;
                    if (bstFind.Node.RightChild != null && bstFind.Node.LeftChild != null){
                        bstFind.Node.haveTwoChildren = true;
                    }
                    return bstFind;
                } else if (node.NodeKey < key) {
                    bstFind.ToLeft = false;
                    parentNode = node;
                    node = node.RightChild;
                } else {
                    bstFind.ToLeft = true;
                    parentNode = node;
                    node = node.LeftChild;
                }
                if (node == null) {
                    bstFind.Node = parentNode;
                    return bstFind;
                }
            }
        }
    }

    public boolean AddKeyValue(int key, T val) {
        // добавляем ключ-значение в дерево
        BSTFind<T> bstFind = FindNodeByKey(key);
        BSTNode<T> nodeToAdd = new BSTNode<>(key, val, bstFind.Node);
        if (!bstFind.NodeHasKey) {
            count++;
            bstFind.Node.haveOneChild = true;
            if (bstFind.ToLeft) {
                bstFind.Node.LeftChild = nodeToAdd;
                nodeToAdd.leftOrRightChild = true; // i.e. added node is a left child
                return true;
            } else {
                bstFind.Node.RightChild = nodeToAdd;
                nodeToAdd.leftOrRightChild = false; // i.e. added node is a right child
                return true;
            }
        } else {
            return false; // если ключ уже есть
        }
    }

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax)
    {
        // ищем максимальное/минимальное в поддереве
        if (FindMax){
            while (true){
                if (FromNode.RightChild == null){
                    return FromNode;
                }
                else {
                    FromNode = FromNode.RightChild;
                }
            }
        }
        else {
            while (true){
                if (FromNode.LeftChild == null){
                    return FromNode;
                }else {
                    FromNode = FromNode.LeftChild;
                }
            }
        }
    }

    public boolean DeleteNodeByKey(int key) {
        // удаляем узел по ключу
        BSTFind<T> bst = FindNodeByKey(key);
        BSTNode<T> tempNode;
        if (bst.NodeHasKey) {
           count--;
            //case1: a node has no child-node
            if (!bst.Node.haveOneChild) {
                if (bst.Node == Root){ // case when the only node is Root and it is to be deleted
                    Root = null;
                }else {
                    if (bst.Node.leftOrRightChild) {
                        bst.Node.Parent.LeftChild = null;
                    } else {
                        bst.Node.Parent.RightChild = null;
                    }
                }
            }
            //case2: a node has two child-nodes
            else if (bst.Node.haveTwoChildren) {
                if (bst.Node == Root) {
                    tempNode = Root.RightChild;
                    while (true){
                        if (tempNode.LeftChild == null){
                            BSTNode<T> node1 = Root.RightChild;
                            tempNode.Parent = null;
                            Root = tempNode;
                            tempNode.RightChild = node1;
                            break;
                        }
                        tempNode = tempNode.LeftChild;
                    }
                    tempNode = tempNode.RightChild;
                    while (tempNode != null){
                        if (tempNode.LeftChild == null && tempNode.RightChild != null){
                            tempNode.Parent.LeftChild = tempNode.RightChild;
                            tempNode.RightChild.Parent = tempNode.Parent;
                        }else {
                            tempNode.Parent.LeftChild = null;
                        }
                        tempNode = tempNode.LeftChild;
                    }

                } else {
                    tempNode = bst.Node.RightChild;
                    while (true) { // in this block I swapped the node to be deleted by the smallest node in the right subtree
                        if (tempNode.LeftChild == null) {
                            if (bst.Node.leftOrRightChild) {
                                bst.Node.Parent.LeftChild = tempNode;
                                tempNode.Parent = bst.Node.Parent;
                            } else {
                                bst.Node.Parent.RightChild = tempNode;
                                tempNode.Parent = bst.Node.Parent;
                            }
                            break;
                        }
                        tempNode = tempNode.LeftChild;
                    }
                    tempNode.RightChild = bst.Node.RightChild;
                    while (tempNode != null) { // here it is needed to remove the node to be deleted after swapping the positions
                        if (tempNode.LeftChild == null && tempNode.RightChild != null) {
                            tempNode.Parent.LeftChild = tempNode.RightChild;
                            tempNode.RightChild.Parent = tempNode.Parent;
                        } else {
                            tempNode.Parent.LeftChild = null;
                        }
                        tempNode = tempNode.LeftChild;
                    }
                }
            }

            //case3: a node has one-child node
            else {
                if (bst.Node == Root){
                    if (Root.RightChild == null){
                        tempNode = Root.LeftChild;
                        tempNode.Parent = null;
                        Root = tempNode;
                    }else {
                        tempNode = Root.RightChild;
                        tempNode.Parent = null;
                        Root = tempNode;
                    }

                }else {
                    if (bst.Node.LeftChild == null) {
                        tempNode = bst.Node.RightChild;
                    } else {
                        tempNode = bst.Node.LeftChild;
                    }
                    if (bst.Node.leftOrRightChild) {
                        bst.Node.Parent.LeftChild = tempNode;
                        tempNode.Parent = bst.Node.Parent;
                    } else {
                        bst.Node.Parent.RightChild = tempNode;
                        tempNode.Parent = bst.Node.Parent;
                    }
                }
            }
            return true;
        }
        return false; // если узел не найден
    }

    public void treeTraverse(BSTNode<T> root){
        if (root == null){
            return;
        }
        System.out.print(root.NodeKey + " ");
        treeTraverse(root.LeftChild);
        treeTraverse(root.RightChild);
    }


    public int Count()
    {
        return count; // количество узлов в дереве
    }

    public ArrayList<BSTNode> DeepAllNodes(int treeOrder ) {
        ArrayList<BSTNode> list = new ArrayList<>();
        if (treeOrder == 0) {
            System.out.print("The In-order traversal of binary tree is : ");
            inOrder(list, Root);
        } else if (treeOrder == 1) {
            System.out.print("\nThe Post-order traversal of binary tree is : ");
            postOrder(list, Root);
        } else if (treeOrder == 2) {
            System.out.print("\nThe Pre-order traversal of binary tree is : ");
            preOrder(list, Root);
        }

        return null;
    }

    public void preOrder(ArrayList<BSTNode> list, BSTNode<T> node){
        if (node == null){
            return ;
        }
        list.add(node);
        System.out.print(node.NodeKey + " ");
        preOrder(list, node.LeftChild);
        preOrder(list, node.RightChild);
    }

    public void inOrder(ArrayList<BSTNode> list, BSTNode<T> node){
        if (node == null){
            return;
        }
        inOrder(list, node.LeftChild);
        list.add(node);
        System.out.print(node.NodeKey + " ");
        inOrder(list, node.RightChild);
    }

    public void postOrder(ArrayList<BSTNode> list, BSTNode<T> node){
        if (node == null){
            return;
        }
        postOrder(list, node.LeftChild);
        postOrder(list, node.RightChild);
        list.add(node);
        System.out.print(node.NodeKey + " ");
    }

    public  ArrayList<BSTNode> WideAllNodes() throws InterruptedException {
        ArrayList<BSTNode> list = new ArrayList<>();
        Queue<BSTNode> queue = new Queue<>();
        queue.enqueue(Root);
        System.out.print("\nThe level order traverse of the tree is : ");
        while (!queue.isEmpty()){
            BSTNode node = queue.dequeue();
            list.add(node);
            System.out.print(node.NodeKey + " ");
            if (node.LeftChild != null && node.RightChild != null){
                queue.enqueue(node.LeftChild);
                queue.enqueue(node.RightChild);
            }else if (node.LeftChild != null){
                queue.enqueue(node.LeftChild);
            }
            else if (node.RightChild != null){
                queue.enqueue(node.RightChild);
            }
        }
        return list;
    }
}
