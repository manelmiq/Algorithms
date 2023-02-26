package support;

public class MyLinkedList {


    protected Node start;
    protected Node end;
    public int size;


    class Node {
        String x;
        Node next;
        Node previous;

        public Node(String x) {
            this.x = x;
        }

        public Node(String x, Node next, Node previous) {
            this.x = x;
            this.next = next;
            this.previous = previous;
        }
    }


    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c = new String ("abc");
        if(a == b && b.equals(c)){
            System.out.println("there are equal");
        }else{
            System.out.println("there are not equal");

        }


    }


}