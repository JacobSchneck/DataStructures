// maybe not now

public class AvlTree<T extends Comparable<T>> implements Trees {
    /************ Instance Variables ***************************/
    private TreeNode<T> root;

    /************ Private AVL Balancing Methods ****************/
    private void calculateNodeHeight(TreeNode<T> root) {
        root.height = root.left.height > root.right.height ? root.left.height + 1 : root.right.height + 1;
    }

    private int getNodeHeight(TreeNode<T> node) {
        return node == null ? -1 : node.height;
    }

    private void singleRotationRight(TreeNode<T> root) {
        TreeNode<T> temp = root;
        root = root.left;
        temp.left = root.right;
        root.right = temp;
        calculateNodeHeight(root.right);
        calculateNodeHeight(root);
    }

    private void singleRotationLeft(TreeNode<T> root) {
        TreeNode<T> temp = root;
        root = root.right;
        temp.right = root.left;
        root.left = temp;
        calculateNodeHeight(root.left);
        calculateNodeHeight(root);
    }

    private void balance(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        if (getNodeHeight(root.left) - getNodeHeight(root.right) > 1) {
            if (getNodeHeight(root.left.left) >= getNodeHeight(root.left.right)) {
                singleRotationRight(root);
            } else { // double rotation
                singleRotationLeft(root.left);
                singleRotationRight(root);
            }
        } else if (getNodeHeight(root.right) - getNodeHeight(root.left) > 1) {
            if (getNodeHeight(root.right.right) >= getNodeHeight(root.right.left)) {
                singleRotationLeft(root);
            } else {
                singleRotationRight(root.right);
                singleRotationLeft(root);
            }
        }
        calculateNodeHeight(root);
    }

    /************ Constructors *********************************/
    AvlTree(TreeNode<T> root) {
        this.root = root;
    }


    
}