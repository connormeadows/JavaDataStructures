import java.util.ArrayList;

public class LinkedList {
    private Node first;
    private Node last;
    private ArrayList<Node> trashCan = new ArrayList<Node>();

    public LinkedList() {
        first = null;
        last = null;
    }

    public void addNode(int v) {
        if(first == null) {
            first = new Node(null, null, v);
            last = first;
        }
        else {
            Node temp = new Node(last, null, v);
            last.next = temp;
            last = temp;
        }
        trashCan.add(last);
    }

    public void printList() {
        Node curr = first;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        for(int i = 0; i < Integer.parseInt(args[0]); i++) {
            ll.addNode(i);
        }
        ll.printList();
    }
}