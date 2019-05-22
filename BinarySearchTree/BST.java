import java.util.ArrayList;

//A Simple Binary Search Tree
public class BST {
    public Node top;
    private ArrayList<Node> trashCan = new ArrayList<Node>();

    public BST() {
        top = null;
    }

    public void add(int v) {
        if (top == null)
            top = new Node(v);
        else {
            findPlace(top, v);
        }
    }

    private void findPlace(Node t, int v) {
        if (v < t.val) {
            if(t.left == null) {
                t.left = new Node(v);
                trashCan.add(t.left);
            }
            else {
                findPlace(t.left, v);
            }
        }
        else if (v > t.val) {
            if(t.right == null) {
                t.right = new Node(v);
                trashCan.add(t.right);
            }
            else {
                findPlace(t.right, v);
            }
        }
        else return;
    }

    public void postOrder(Node t) {
        if(top == null) return;
        if(t.left != null)
            postOrder(t.left);
        System.out.print(t.val + " ");
        if(t.right != null)
            postOrder(t.right);
    }

    public void inOrder(Node t) {
        if(top == null) return;
        System.out.print(t.val + " ");
        if(t.left != null)
            inOrder(t.left);
        if(t.right != null)
            inOrder(t.right);
    }

    public static void main(String[] args) {
        BST bst = new BST();
        for(int i = 0; i < Integer.parseInt(args[0]); i++) {
            bst.add((int)(Math.random() * 100));
        }
        bst.postOrder(bst.top);
        System.out.println();
        bst.inOrder(bst.top);
    }
}