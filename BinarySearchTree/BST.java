import java.util.ArrayList;

//A Simple Binary Search Tree
public class BST {
    public Node top;
    private ArrayList<Node> trashCan = new ArrayList<Node>();
    public String io = "";
    public String po = "";

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

    public String inOrder(Node t) {
        if(top == null) return io;
        if(t.left != null)
            inOrder(t.left);
        io += (t.val + " ");
        if(t.right != null)
            inOrder(t.right);
        return io;
    }

    public String postOrder(Node t) {
        if(top == null) return po;
        if(t.left != null)
            postOrder(t.left);
        if(t.right != null)
            postOrder(t.right);
        po += (t.val + " ");
        return po;
    }

    public void balanceTree(Node t) {
        if(t == null) return;
        BST newNew = new BST();
        String inO = inOrder(top);
        int count = 0;
        while(inO.length() > 1) {
            inO = inO.substring(inO.indexOf(" ") + 1);
            count++;
        }
        inO = inOrder(top);
        int[] temp = new int[count];
        for(int i = 0; i < count; i++) {
            temp[i] = Integer.parseInt(inO.substring(0, inO.indexOf(" ")));
            inO = inO.substring(inO.indexOf(" ") + 1);
        }
        int up = (int)(count/2);
        int down = (int)(count/2 - 1);
        while (up < count || down > -1) {
            if(up < count) {
                System.out.println(temp[up]);
                newNew.add(temp[up++]);
            }
            if(down > -1) {
                System.out.println(temp[down]);
                newNew.add(temp[down--]);
            }
        }
        this.trashCan = newNew.trashCan;
        this.top = newNew.top;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int addit  = 0;
        for(int i = 0; i < Integer.parseInt(args[0]); i++) {
            addit = (int)(Math.random() * 100);
            System.out.println(addit);
            bst.add(addit);
        }
        System.out.println(bst.postOrder(bst.top));
        System.out.println(bst.inOrder(bst.top));
        bst.balanceTree(bst.top);
        bst.io = "";
        bst.po = "";
        System.out.println("Balancing...");
        System.out.println(bst.postOrder(bst.top));
        System.out.println(bst.inOrder(bst.top));
    }
}