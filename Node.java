public class Node{
    private int item;
    private Node next;

    public Node(int number){
        this.item = number;
        this.next = null;
    }

    public Node next(){
        return this.next;
    }

    public void setNext(Node nextNode){
        this.next = nextNode;
    }

    public boolean hasNext(){
        return this.next != null;
    }

    public int getNumber(){
        return this.item;
    }
}
