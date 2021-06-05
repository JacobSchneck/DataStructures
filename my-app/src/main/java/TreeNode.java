public class TreeNode<T> {
T val;
TreeNode<T> left;
TreeNode<T> right;

TreeNode(T val) {
    this.val = val;
    this.left = null;
    this.right = null;
}

public String toString() {
    if (left == null && right == null) {
        return val + ": (N/A, N/A)";
    } else if (left == null) {
        return val + ": (N/A,  " + right.val + ")";
    } else if (right == null) {
        return val + ": (" + left.val + ", N/A)";
    } else {
        return val + ": (" + left.val + ", " + right.val + ")";
    }
}
}