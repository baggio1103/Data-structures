import java.util.*;

class BSTNode
{
    public int NodeKey; // ключ узла
    public BSTNode Parent; // родитель или null для корня
    public BSTNode LeftChild; // левый потомок
    public BSTNode RightChild; // правый потомок
    public int     Level; // глубина узла

    public BSTNode(int key, BSTNode parent)
    {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST
{
    public BSTNode Root;

    public int [] BSTArray; // временный массив для ключей дерева

    public BalancedBST()
    {
        Root = null;
    }

    public void CreateFromArray(int[] a) {
        // создаём массив дерева BSTArray из заданного
            arraySort(a);
            int index = 0;
            int start = 0;
            int end = a.length - 1;
            BSTArray = new int[a.length];
            recursion(a, BSTArray, start, end, index);
    }

    public static void recursion(int[] array, int[] tree, int start, int end, int index){
        if (start > end){
            return;
        }
        int mid = (start+end)/2;
        tree[index] = array[mid];
        recursion(array,tree, start, mid-1, 2*index+1);
        recursion(array,tree,mid+1, end, 2*index+2);
    }


    public  void arraySort(int[] array){
        for (int i = array.length-1; i >= 0; i--){
            for (int j = 0; j < i; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public void GenerateTree() {
        // создаём дерево с нуля из массива BSTArray
        Root = new BSTNode(BSTArray[0], null);
        Root.Level = 1;
        int nodeLevel = 1;
        ArrayList<BSTNode> nodes = new ArrayList<>();
        nodes.add(Root);
        for (int i = 1; i < BSTArray.length; i++) {
            nodes.add(new BSTNode(BSTArray[i], nodes.get((i - 1) / 2)));
            nodeLevel++;
            nodes.get(i).Level = Math.getExponent(nodeLevel)+1;
            if (i % 2 == 0) {
                nodes.get((i - 1) / 2).RightChild = nodes.get(i);
            } else {
                nodes.get((i - 1) / 2).LeftChild = nodes.get(i);
            }
        }
    }

    public void deepAllNodes(BSTNode node) {
        LinkedList<BSTNode> list = new LinkedList<>();
        list.add(node);
        while (list.size() > 0){
            BSTNode nod = list.removeFirst();
            System.out.println(nod.NodeKey + " " + nod.Level);
            if (nod.LeftChild != null && nod.RightChild != null) {
                list.add(nod.LeftChild);
                list.add(nod.RightChild);
            }
            else if (nod.LeftChild != null){
                list.add(nod.LeftChild);
            }else if (nod.RightChild != null){
                list.add(nod.RightChild);
            }
        }
    }


    public  void print(int[] array){
        for (int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public boolean IsBalanced(BSTNode root_node) {
    // сбалансировано ли дерево с корнем root_node
        int leftSubtree;
        int rightSubtree;
        if (root_node == null){
            return true;
        }
        leftSubtree = height(root_node.LeftChild);
        rightSubtree = height(root_node.RightChild);

        if (Math.abs(leftSubtree - rightSubtree) <= 1 && IsBalanced(root_node.LeftChild) && IsBalanced(root_node.RightChild)){
            return true;
        }
        return false;
    }

    public int height(BSTNode node){
        if (node == null){
            return 0;
        }
        return 1 + Math.max(height(node.LeftChild), height(node.RightChild));
    }

    public int preOrder(BSTNode node){
        if (node == null){
            return 0;
        }
        preOrder(node.LeftChild);
        preOrder(node.RightChild);
        return node.Level;
    }
    
}
