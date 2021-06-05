// sad I didn't make a good linked list
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class BinaryTree <T extends Comparable<T>> implements Trees<T> {
    /************** Instance Variables **************/
    private TreeNode<T> root;

    /************** Constructors ********************/
    BinaryTree(TreeNode<T> root) {
        this.root = root;
    }

    /************** find ****************************/
    private boolean findRec(TreeNode<T> root, T val) {
        if (root == null) {
            return false;
        } else if (root.val.compareTo(val) == 0) {
            return true;
        } else if (root.val.compareTo(val) > 0) {
            return findRec(root.left, val);
        } else {
            return findRec(root.right, val);
        }
    }

    public boolean find(T val) {
        return findRec(root, val);
    }

    public TreeNode<T> findMin(TreeNode<T> root) {
        if (root.left == null) {
            return root;
        } else {
            return findMin(root.right);
        }
    }

    /************** add ****************************/
    private boolean addRec(TreeNode<T> root, T val) {
        boolean added = false;
        if (root.val.compareTo(val) > 0 ) {
            if (root.left == null) {
                root.left = new TreeNode<T>(val);
                added = true;
            } else {
                addRec(root.left, val);
            }
        } else if (root.val.compareTo(val) < 0) {
            if (root.right == null) {
                root.right = new TreeNode<T>(val);
                added = true;
            } else {
                addRec(root.right, val);
            }
        }
        return added;    
    }

    public boolean add(T val) {
        return addRec(root, val);
    }

    /************** remove *************************/
    private TreeNode<T> removeRec(TreeNode<T> root, T val) {
        if (root == null) {
            return null;
        } 
        if (root.val.compareTo(val) > 0) { 
            root.left = removeRec(root.left, val);
        } else if (root.val.compareTo(val) < 0) {
            root.right = removeRec(root.right, val);
        } else {
            if (root.left != null && root.right != null) {
                // TreeNode<T> temp = root;
                root.val = findMin(root.right).val;
                root.right = removeRec(root.right, root.val);
            } else if (root.left != null || root.right != null) {
                root = root.left != null ? root.left : root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    public void remove(T val) {
        removeRec(root, val);
    }
    
    /************** BFS ****************************/
    public List<TreeNode<T>> BFS() { // sort of... no searching in place

        List<TreeNode<T>> list = new ArrayList<TreeNode<T>>();
        LinkedList<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
        
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.poll(); // pop(0) also works for removing head
            list.add(node);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return list;
    }

    /************** Print Tree *********************/
    // will implement BFS
    public void printBinaryTree() {
        List<TreeNode<T>> list = BFS();
        for (TreeNode<T> item : list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        TreeNode<Character> n0 = new TreeNode<Character>('a');
        TreeNode<Character> n1 = new TreeNode<Character>('b');
        TreeNode<Character> n2 = new TreeNode<Character>('c');
        TreeNode<Character> n3 = new TreeNode<Character>('d');
        
        n0.left = n1;
        n2.right = n3;
        n0.right = n2;

        // System.out.println("HI");
        System.out.println(n0);
        System.out.println(n1);
        System.out.println(n2);

        BinaryTree<Character> tree = new BinaryTree<Character>(n0);
        System.out.println(tree.find('c'));
        System.out.println(tree.find('e'));
        System.out.println(tree.find('d'));

        tree.printBinaryTree();
        System.out.println();

        tree.add('f');
        tree.add('e');
        tree.add('g');
        System.out.println(tree.add('c'));

        tree.printBinaryTree();
        System.out.println();

        tree.remove('a');
        tree.printBinaryTree();
        System.out.println();

        tree.remove('f');
        tree.printBinaryTree();
    }
}