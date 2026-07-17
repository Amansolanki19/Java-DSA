package LinkedList;

public class ListIntersection {

    Node head1,head2;
    static void main() {
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        Node g=new Node(7);
        Node h=new Node(8);
        Node i=new Node(9);
        Node j=new Node(10);

        Node z=new Node(3);
        Node y=new Node(4);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=g;
        g.next=h;
        h.next=i;
        i.next=j;

        z.next=y;
        y.next=g;

        ListIntersection list=new ListIntersection();
        list.head1=a;
        list.head2=z;

        Node temp1=list.head1;
        Node temp2=list.head2;

        while(temp1!=null){
            System.out.print(temp1.data+" -> ");
            temp1=temp1.next;
        }

        System.out.println("END");

        while (temp2!=null){
            System.out.print(temp2.data+" -> ");
            temp2=temp2.next;
        }
        System.out.println("END");

        System.out.println("Intersaction point: "+new ListIntersection().intersectionFinding(list.head1,list.head2).data);
    }

    Node intersectionFinding(Node head1,Node head2){
        Node temp1=head1;
        Node temp2=head2;

        while(temp1!=temp2){
            temp1=(temp1==null)?head2:temp1.next;
            temp2=(temp2==null)?head1:temp2.next;
        }
        return temp1;
    }
}
