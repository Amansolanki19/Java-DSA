package LinkedList;

public class FindingNthNodeFromEnd {
    public Node findingNodeFromLast(Node head,int n){
        int size=new RemoveNthNodeFromEndofList().sizeOfList(head);
        Node temp=head;
        for(int i=0;i<size-n;i++){
            temp=temp.next;
        }
        return temp;
    }

}
