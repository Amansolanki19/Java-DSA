package LinkedList;

import java.util.Scanner;



class MyLinkedList {

    private Node head;
    private int size;

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        size++;
    }

    public void insertLast(int value) {

        Node node = new Node(value);

        if (head == null) {
            head = node;
            size++;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
        size++;
    }

    public void insertAtIndex(int value, int index) {

        if (index == 0) {
            insertFirst(value);
            return;
        }

        if (index == size) {
            insertLast(value);
            return;
        }

        Node temp = head;

        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(value);

        node.next = temp.next;
        temp.next = node;

        size++;
    }

    public void deleteFirst() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;
        size--;
    }

    public void deleteLast() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        size--;
    }

    public void deleteAtIndex(int index) {

        if (index == 0) {
            deleteFirst();
            return;
        }

        Node temp = head;

        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }

    public void reverse() {

        Node prev = null;
        Node curr = head;

        while (curr != null) {

            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void sort() {

        for (int i = 0; i < size - 1; i++) {

            Node temp = head;

            while (temp != null && temp.next != null) {

                if (temp.data > temp.next.data) {

                    int t = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = t;
                }

                temp = temp.next;
            }
        }
    }

    public int size() {
        return size;
    }

    public MyLinkedList duplicate() {

        MyLinkedList copy = new MyLinkedList();

        Node temp = head;

        while (temp != null) {
            copy.insertLast(temp.data);
            temp = temp.next;
        }

        return copy;
    }

    public void display() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    public Node findTheMiddleElement(){
        Node fast=head;
        Node slow=head;
        while (fast != null && fast.next != null) {
            return head;
        }
        while (fast != null && fast.next != null) {
            fast=fast.next.next;
            slow=slow.next;
        }

        return slow;
    }

    public Node deleteTheMiddleNode() {
        if(head.next==null) return null;
        Node fast = head;
        Node slow = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}

public class SinglyLinkedList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList duplicateList = null;

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Insert at Start");
            System.out.println("2. Insert at Index");
            System.out.println("3. Insert at End");
            System.out.println("4. Delete Start");
            System.out.println("5. Delete Last");
            System.out.println("6. Delete at Index");
            System.out.println("7. Reverse");
            System.out.println("8. Sort");
            System.out.println("9. Display");
            System.out.println("10. Size");
            System.out.println("11. Create Duplicate");
            System.out.println("12. Display Duplicate");
            System.out.println("13. Find the Middle node of the Linked List");
            System.out.println("14. Delete the Middle node of the Linked List");
            System.out.println("15. Exit...");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    list1.insertFirst(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();

                    System.out.print("Enter index: ");
                    int index = sc.nextInt();

                    list1.insertAtIndex(value, index);
                    break;

                case 3:
                    System.out.print("Enter value: ");
                    list1.insertLast(sc.nextInt());
                    break;

                case 4:
                    list1.deleteFirst();
                    break;

                case 5:
                    list1.deleteLast();
                    break;

                case 6:
                    System.out.print("Enter index: ");
                    list1.deleteAtIndex(sc.nextInt());
                    break;

                case 7:
                    list1.reverse();
                    break;

                case 8:
                    list1.sort();
                    break;

                case 9:
                    list1.display();
                    break;

                case 10:
                    System.out.println("Size = " + list1.size());
                    break;

                case 11:
                    duplicateList = list1.duplicate();
                    System.out.println("Duplicate list created.");
                    break;

                case 12:
                    if (duplicateList != null)
                        duplicateList.display();
                    else
                        System.out.println("Duplicate list not created yet.");
                    break;

                case 13:
                    System.out.println("Middle Element of the Linked List"+ list1.findTheMiddleElement());
                    break;

                case 14:
                    list1.deleteTheMiddleNode();
                    list1.display();
                    break;

                case 15:
                    System.out.println("PROGRAM TERMINATED");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}