package LinkedList;

public class RemoveNthNodeFromEndofList {

    public Node removeNthFromEnd(Node head, int n) {

        int size = sizeOfList(head);

        if (size == n)
            return head.next;

        Node temp = head;

        for (int i = 0; i < size - n - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    int sizeOfList(Node head) {

        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }
}