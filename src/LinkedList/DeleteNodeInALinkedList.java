package LinkedList;

public class DeleteNodeInALinkedList {

    static class Node {
        int data;
        Node node;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String... args) {

        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);
        Node f = new Node(60);
        Node g = new Node(70);

        // Linking nodes
        a.node = b;
        b.node = c;
        c.node = d;
        d.node = e;
        e.node = f;
        f.node = g;

        Solution sol = new Solution();
        sol.deleteNode(e); // delete node containing 50

        // Print list
        Node temp = a;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.node;
        }
    }
}

class Solution {

    public void deleteNode(DeleteNodeInALinkedList.Node node) {

        if (node == null || node.node == null) {
            return; // can't delete last node
        }

        node.data = node.node.data;
        node.node = node.node.node;
    }
}