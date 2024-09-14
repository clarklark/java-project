package collection_.set;

public class HashSetStructure {
    public static void main(String[] args) {
        Node[]table=new Node[16];
        Node jack=new Node("jack",null);
        Node jerry=new Node("jerry",null);
        Node lucy=new Node("lucy",null);
        table[2]=jack;
        jack.next=jerry;
        jerry.next=lucy;
        System.out.println("table="+table);

    }
}
class Node{
    public Object data;
    public Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}