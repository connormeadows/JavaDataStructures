public class Node {
    public Node prev;
    public Node next;

    public int val;

    public Node(){
        this(null, null, 0);
    }

    public Node(Node p, Node n, int v){
        prev = p;
        next = n;
        val = v;
    }
}