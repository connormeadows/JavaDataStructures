public class Node {
    public Node left;
    public Node right;
    public int val;

    public Node() {
        this(0);
    }

    public Node(int val) {
        left = null;
        right = null;
        this.val = val;
    }
}