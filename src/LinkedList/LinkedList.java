package LinkedList;

public class LinkedList {

    Node head;

    static void main(){

        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);
        Node f = new Node(60);
        Node g = new Node(70);


        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        LinkedList list = new LinkedList();
        list.head = a;

        RemoveNthNodeFromEndofList remove=new RemoveNthNodeFromEndofList();

        Node temp=remove.removeNthFromEnd(list.head,3);

        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }

//        FindingNthNodeFromEnd node=new FindingNthNodeFromEnd();
//        Node result=node.findingNodeFromLast(list.head,6);
//        System.out.print(result.data);

    }
}

class Node{
    int data;
    Node next;

    Node(){}
    Node(int data){
        this.data=data;
    }
}
