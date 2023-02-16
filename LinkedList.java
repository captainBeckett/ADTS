public class LinkedList {
    private Node head;
    private int numItems;

    public LinkedList(){
        this.head = null;
        this.numItems = 0;
    }

    public void add(int element){
        //linked list is empty
        if(isEmpty()){
            //create new node and set it equal to head of the list
            this.head = new Node(element);
            //increase total number of nodes
            this.numItems++;
        }else{
            //linked list is not empty
            //add node to head of the list (or left to right)
            Node nodeToAdd = new Node(element);
            //set pointer to previous node
            nodeToAdd.setNext(this.head);
            //set new node as head
            this.head = nodeToAdd;
            //increase total number of nodes
            this.numItems++;
        }
    }      

    //add new node at a specified index of list
    public void add(int index, int element){
        //create new node with specified element
        Node nodeToAdd = new Node(element);

        //create a reference node to allow us to move throughout the list
        Node start = this.head;

        //make sure start node is pointing to something
        if(start != null){
            //move to the specified index or the last element in the list, whichever comes first
            for(int i = 0; i < index - 1 && start.hasNext(); i++){
                start = start.next();
            }
        }else{
            throw new IndexOutOfBoundsException("Use add(element) method to insert node at end of list");
        }

        //set the noew node's pointer to the start node's pointer
        nodeToAdd.setNext(start.next());

        //set the start node pointer to the nodetoAdd
        start.setNext(nodeToAdd);

        //increase total number of nodes
        this.numItems++;


    }

    public int get(int index){
        //error checking
        //make sure index >= 0
        if(index >= 0){
            //create a reference node for movement
            Node start = this.head;
            for(int i = 0; i < index; i++){
                if(start.hasNext() == false){
                    //throw exception
                    throw new IndexOutOfBoundsException("There is no node value at index " + index);
                }else{
                    start = start.next();
                }
            }
            return start.getNumber();
        }else{
            //throw exception
            throw new IndexOutOfBoundsException("Index's can't be negative in LinkedList");
        }
    }

    public int remove(int index){
        //error checking
        if(index < 0 || index > numItems){
            //throw exception
            throw new IndexOutOfBoundsException("Index is outside of list range");
        }else{
            //create a reference node for movement
            Node start = this.head;
            //make sure list isn't empty and starting node is point to something
            if(isEmpty() == false){
                //move to the specified index or the last element in the list, whichever comes first
                for(int i = 0; i < index - 1; i++){
                    if(start.hasNext() == false){
                        //throw exception
                        throw new IndexOutOfBoundsException("There is no node value at index " + index);
                    }else{
                        start = start.next();
                    }
                }
                Node removedNode = start.next();
                start.setNext(removedNode.next());
                this.numItems--;
                return removedNode.getNumber();
        }else{
            //throw exception
            throw new IndexOutOfBoundsException("The list is empty");
        }
    }
    }

    public int size(){
        return this.numItems;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public static void main(String[] args) {
        //test out linkedlist
        LinkedList myNumbers = new LinkedList();
        myNumbers.add(15);
        myNumbers.add(8);
        myNumbers.add(9);
        myNumbers.add(10);
        myNumbers.add(2, 21);
        System.out.println(myNumbers.remove(4));
        for(int i = 0; i < myNumbers.size(); i++){
            System.out.print(myNumbers.get(i) + ", ");
        }
    }
}