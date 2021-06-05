import java.util.List;

interface Trees<T> {
    public List<TreeNode<T>> BFS();
    public boolean find(T val);
    public boolean add(T val);
    public void remove(T val);
}